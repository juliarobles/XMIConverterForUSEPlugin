/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.impl;

import fixerror.antlr.ANTLRStringStream_FIX;
import fixerror.antlr.CommonToken_FIX;
import fixerror.antlr.Token_FIX;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * Expands a region such that it contains only complete lexer tokens.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public class TokenRegionProvider {

	@Inject
	@Named(LexerBindings.RUNTIME)
	private Provider<Lexer> lexerProvider;

	public ITextRegion getTokenRegion(String text, ITextRegion region) {
		Lexer lexer = lexerProvider.get();
		lexer.setCharStream(new ANTLRStringStream_FIX(text));
		int currentStart = 0;
		int currentEnd = 0;
		CommonToken_FIX nextToken = (CommonToken_FIX) lexer.nextToken();
		int regionStart = region.getOffset();
		int regionEnd = regionStart + region.getLength();
		while (nextToken != Token_FIX.EOF_TOKEN && currentEnd <= regionStart) {
			currentStart = nextToken.getStartIndex();
			currentEnd = nextToken.getStopIndex() + 1;
			nextToken = (CommonToken_FIX) lexer.nextToken();
		}
		// nextToken is either EOF or the first token that follows the start of the given region
		while (nextToken != Token_FIX.EOF_TOKEN && currentEnd < regionEnd) {
			currentEnd = nextToken.getStopIndex() + 1;
			nextToken = (CommonToken_FIX) lexer.nextToken();
		}
		if (currentStart != regionStart || currentEnd != regionEnd) 
			return new TextRegion(currentStart, currentEnd - currentStart);
		else 
			return region;
	}

	public ReplaceRegion getTokenReplaceRegion(String changedText, ReplaceRegion replaceRegion) {
		int lengthDelta = replaceRegion.getText().length() - replaceRegion.getLength();
		ITextRegion tokenRegion = getTokenRegion(changedText, new TextRegion(replaceRegion.getOffset(), replaceRegion
				.getText().length()));
		if (tokenRegion.getOffset() == replaceRegion.getOffset()
				&& tokenRegion.getLength() == replaceRegion.getText().length())
			return replaceRegion;
		else 
			return new ReplaceRegion(tokenRegion.getOffset(), tokenRegion.getLength() - lengthDelta,
					changedText.substring(tokenRegion.getOffset(), tokenRegion.getOffset() + tokenRegion.getLength()));
	}

}
