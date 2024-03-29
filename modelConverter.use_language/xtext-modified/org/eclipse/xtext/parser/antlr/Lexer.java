/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.HashMap;
import java.util.Map;

import fixerror.antlr.CharStream_FIX;
import fixerror.antlr.CommonToken_FIX;
import fixerror.antlr.FailedPredicateException_FIX;
import fixerror.antlr.NoViableAltException_FIX;
import fixerror.antlr.RecognitionException_FIX;
import fixerror.antlr.RecognizerSharedState_FIX;
import fixerror.antlr.Token_FIX;
import org.apache.log4j.Logger;

/**
 * Hack: As AntLR does not allow to define the superclass of the generated
 * lexer, we call this class Lexer and import it to be used instead of the
 * original lexer class.
 * 
 * @author Jan K�hnlein - Initial contribution and API
 * 
 */
public abstract class Lexer extends fixerror.antlr.Lexer_FIX {

	private static final Logger logger = Logger.getLogger(Lexer.class);
	
	public Lexer() {
		super();
	}

	public Lexer(CharStream_FIX input) {
		super(input);
	}
	
	public Lexer(CharStream_FIX input, RecognizerSharedState_FIX state) {
        super(input,state);
    }

	private final Map<Token_FIX, String> tokenErrorMap = new HashMap<Token_FIX, String>();

	@Override
	public Token_FIX nextToken() {
		while (true) {
			this.state.token = null;
			this.state.channel = Token_FIX.DEFAULT_CHANNEL;
			this.state.tokenStartCharIndex = input.index();
			this.state.tokenStartCharPositionInLine = input.getCharPositionInLine();
			this.state.tokenStartLine = input.getLine();
			this.state.text = null;
			if (input.LA(1) == CharStream_FIX.EOF) {
				return Token_FIX.EOF_TOKEN;
			}
			try {
				mTokens();
				if (this.state.token == null) {
					emit();
				}
				else if (this.state.token == Token_FIX.SKIP_TOKEN) {
					continue;
				}
				return this.state.token;
			}
			catch (RecognitionException_FIX re) {
				reportError(re);
				if (re instanceof NoViableAltException_FIX ||
					re instanceof FailedPredicateException_FIX) {
					recover(re);
				}
				// create token that holds mismatched char
				Token_FIX t = new CommonToken_FIX(input, Token_FIX.INVALID_TOKEN_TYPE, Token_FIX.HIDDEN_CHANNEL,
						this.state.tokenStartCharIndex, getCharIndex() - 1);
				t.setLine(this.state.tokenStartLine);
				t.setCharPositionInLine(this.state.tokenStartCharPositionInLine);
				tokenErrorMap.put(t, getErrorMessage(re, this.getTokenNames()));
				emit(t);
				return this.state.token;
			}
		}
	}

	public String getErrorMessage(Token_FIX t) {
		return tokenErrorMap.get(t);
	}
	
	@Override
	public void emitErrorMessage(String msg) {
		// don't call super, since it would do a plain vanilla
		// System.err.println(msg);
		if (logger.isTraceEnabled())
			logger.trace(msg);
	}
	
}
