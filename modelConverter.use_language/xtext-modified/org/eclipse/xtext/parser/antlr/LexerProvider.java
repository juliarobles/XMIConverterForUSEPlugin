/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import fixerror.antlr.CharStream_FIX;
import fixerror.antlr.Lexer_FIX;

import com.google.inject.Provider;

/**
 * A Guice provider implementation, that does not use the default constructor of 
 * the lexer class, but call the other available constructor that takes a CharStream_FIX as argument.
 * This provider is a workaround for a bug in ANTLR that leads to partially initialized
 * Lexer_FIX instances. They may cause NullPointerExceptions in some rare situations, when
 * backtracking is involved.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerProvider<T extends Lexer_FIX> implements Provider<T> {

	private final Class<T> clazz;

	public static <T extends Lexer_FIX> LexerProvider<T> create(Class<T> clazz) {
		return new LexerProvider<T>(clazz);
	}
	
	public LexerProvider(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * Creates a lexer instance via reflection. The object is not created with the default
	 * constructor because it will not initialize the backtracking state of the lexer.
	 * Instead, we pass <code>null</code> as CharStream_FIX argument.
	 */
	@Override
	public T get() {
		try {
			return clazz.getConstructor(CharStream_FIX.class).newInstance(new Object[] { null });
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
