/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fixerror.antlr.CommonToken_FIX;
import fixerror.antlr.Token_FIX;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TokenTool {
	/**
	 * @param t the token
	 * @return the parsed text or <code>null</code> if the {@link Token_FIX} t was <code>null</code> or the token's text was <code>null</code>.
	 */
	public static String getText(Token_FIX t) {
		return t!=null ? t.getText() : null;
	}
	
	/**
	 * @param t the token
	 * @return the line of the token or <code>-1</code> if the {@link Token_FIX} t was <code>null</code> or the token did not provide line information.
	 */
	public static int getLine(Token_FIX t) {
		return  t!=null ? t.getLine() : -1;
	}
	
	/**
	 * @param t the token
	 * @return the offset of the token or <code>-1</code> if the {@link Token_FIX} t was <code>null</code> or the token did not provide offset information.
	 */
	public static int getOffset(Token_FIX t) {
		if (t instanceof CommonToken_FIX) {
			return ((CommonToken_FIX)t).getStartIndex();
		}
		return -1;
	}
	
	/**
	 * @param t the token
	 * @return the length of the token or <code>0</code> if the {@link Token_FIX} t was <code>null</code> or the token did not provide line information.
	 */
	public static int getLength(Token_FIX t) {
		String text = getText(t);
		return text!=null ? text.length() : 0;
	}
	
	public static final String LEXER_RULE_PREFIX = "RULE_";
	
	private static final Pattern superRulePattern = Pattern.compile("^(SUPER_(\\d+_)?).*$");
	
	public static boolean isLexerRule(String antlrTokenDef) {
		return antlrTokenDef.startsWith(LEXER_RULE_PREFIX);
	}
	
	public static String getLexerRuleName(String antlrTokenDef) {
		if (antlrTokenDef.startsWith(LEXER_RULE_PREFIX))
			return antlrTokenDef.substring(LEXER_RULE_PREFIX.length());
		Matcher matcher = superRulePattern.matcher(antlrTokenDef);
		if (matcher.matches()) {
			return antlrTokenDef.substring(matcher.group(1).length());
		}
		return antlrTokenDef;
	}

}
