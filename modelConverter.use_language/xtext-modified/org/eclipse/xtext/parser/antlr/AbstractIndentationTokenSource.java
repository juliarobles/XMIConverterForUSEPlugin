/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.Stack;

import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.parser.antlr.ITokenAcceptor;

import fixerror.antlr.CommonToken_FIX;
import fixerror.antlr.TokenSource_FIX;
import fixerror.antlr.Token_FIX;

/**
 * Abstract implementation of a token source, that splits according to indentation levels
 * after newlines.
 * Blank lines are ignored. At the end of file token, all pending indentations will be handled
 * and dedentation tokens will be issued accordingly if {@link #shouldEmitPendingEndTokens()} returns true.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public abstract class AbstractIndentationTokenSource extends AbstractSplittingTokenSource {

	protected AbstractIndentationTokenSource(TokenSource_FIX delegate) {
		setDelegate(delegate);
	}
	
	protected Stack<Integer> indentationStack = new Stack<Integer>();

	// make sure we never face an empty indentation stack.
	{
		indentationStack.push(0);
	}
	
	protected int currentOffset = 0;
	protected int currentIndentation = 0;
	protected int currentEnd = 0;
	protected int nextOffset = 0;
	
	@Override
	protected boolean shouldSplitToken(Token_FIX token) {
		return token.getType() == Token_FIX.EOF || shouldSplitTokenImpl(token);
	}
	
	/**
	 * Return {@code true} if the given token is a whitespace token that should be splitted.
	 * Usually the token type will be compared to one of the int constants from the parser.
	 */
	protected abstract boolean shouldSplitTokenImpl(Token_FIX token);

	/**
	 * @since 2.13
	 */
	protected void doSplitEofToken(Token_FIX token, ITokenAcceptor result) {
		if (shouldEmitPendingEndTokens()) {
			while(indentationStack.size() > 1) {
				indentationStack.pop();
				result.accept(createEndToken(nextOffset));
			}
		}
		result.accept(token);
	}
	
	@Override
	protected void doSplitToken(Token_FIX token, ITokenAcceptor result) {
		if (token.getType() == Token_FIX.EOF) {
			doSplitEofToken(token, result);
		} else {
			doSplitTokenImpl(token, result);	
		}
	}
	
	protected boolean shouldEmitPendingEndTokens() {
		return true;
	}
	
	@Override
	public Token_FIX nextToken() {
		Token_FIX result = super.nextToken();
		if (result instanceof CommonToken_FIX) {
			nextOffset = ((CommonToken_FIX) result).getStopIndex() + 1;
		} else {
			throw new IllegalArgumentException(String.valueOf(result));
		}
		return result;
	}

	/**
	 * The token was previously determined as potentially to-be-splitted thus we
	 * emit additional indentation or dedenting tokens.
	 */
	protected void doSplitTokenImpl(Token_FIX token, ITokenAcceptor result) {
		String text = token.getText();
		int indentation = computeIndentation(text);
		if (indentation == -1 || indentation == currentIndentation) {
			// no change of indentation level detected simply process the token
			result.accept(token);
		} else if (indentation > currentIndentation) {
			// indentation level increased
			splitIntoBeginToken(token, indentation, result);
		} else if (indentation < currentIndentation) {
			// indentation level decreased
			int charCount = computeIndentationRelevantCharCount(text);
			if (charCount > 0) {
				// emit whitespace including newline
				splitWithText(token, text.substring(0, charCount), result);	
			}
			// emit end tokens at the beginning of the line
			decreaseIndentation(indentation, result);
			if (charCount != text.length()) {
				handleRemainingText(token, text.substring(charCount), indentation, result);
			}
		} else {
			throw new IllegalStateException(String.valueOf(indentation));
		}
	}

	/**
	 * @since 2.13
	 */
	protected void handleRemainingText(Token_FIX token, String text, int indentation, ITokenAcceptor result) {
		CommonToken_FIX trailingToken = createToken((CommonToken_FIX) token, text, null, null, nextOffset, null, null);
		if (indentation > currentIndentation) {
			splitIntoBeginToken(trailingToken, indentation, result);
		} else {
			// emit pending whitespace
			result.accept(trailingToken);
		}
	}

	protected void decreaseIndentation(int indentation, ITokenAcceptor result) {
		while(indentation < currentIndentation) {
			indentationStack.pop();
			currentIndentation = indentationStack.peek();
			result.accept(createEndToken(nextOffset));
		}
	}

	protected void splitWithText(Token_FIX token, String text, ITokenAcceptor result) {
		CommonToken_FIX leadingToken = createToken((CommonToken_FIX) token, text, null, null, nextOffset, nextOffset + text.length() - 1, null);
		result.accept(leadingToken);
		nextOffset += text.length();
	}

	private void splitIntoBeginToken(Token_FIX token, int indentation, ITokenAcceptor result) {
		result.accept(token);
		if (shouldEmitPendingEndTokens()) {
			Token_FIX nextToken = getDelegate().nextToken();
			if (shouldSplitToken(nextToken)) {
				nextOffset = ((CommonToken_FIX) token).getStopIndex() + 1;
				doSplitToken(nextToken, result);
			} else {
				indentationStack.push(indentation);
				currentIndentation = indentation;
				result.accept(createBeginToken(((CommonToken_FIX) token).getStopIndex() + 1));
				result.accept(nextToken);
			}	
		} else {
			indentationStack.push(indentation);
			currentIndentation = indentation;
			result.accept(createBeginToken(((CommonToken_FIX) token).getStopIndex() + 1));
		}
	}

	protected Token_FIX createEndToken(int offset) {
		CommonToken_FIX result = new CommonToken_FIX(getEndTokenType());
		result.setText("");
		result.setChannel(Token_FIX.DEFAULT_CHANNEL);
		result.setStartIndex(offset);
		result.setStopIndex(offset-1);
		return result;
	}
	
	protected abstract int getEndTokenType();
	protected abstract int getBeginTokenType();

	protected Token_FIX createBeginToken(int offset) {
		CommonToken_FIX result = new CommonToken_FIX(getBeginTokenType());
		result.setText("");
		result.setChannel(Token_FIX.DEFAULT_CHANNEL);
		result.setStartIndex(offset);
		result.setStopIndex(offset-1);
		return result;
	}
	
	protected int computeIndentationRelevantCharCount(String text) {
		int result = 0;
		while(result < text.length()) {
			char c = text.charAt(result);
			if (c == '\n') {
				result++;
				if (result < text.length()) {
					c = text.charAt(result);
					if (c == '\r') {
						result++;
					}
				}
				return result;
			}
			result++;
		}
		return -1;
	}
	
	protected int computeIndentation(String text) {
		int result = 0;
		for(int i = text.length() - 1; i>=0; i--) {
			char c = text.charAt(i);
			if (c == '\n' || c == '\r') {
				return result;
			}
			if (c == '\t') {
				result+=getTabWidth();
			} else {
				result++;
			}
		}
		return -1;
	}

	protected char getTabWidth() {
		return 8;
	}
	
}
