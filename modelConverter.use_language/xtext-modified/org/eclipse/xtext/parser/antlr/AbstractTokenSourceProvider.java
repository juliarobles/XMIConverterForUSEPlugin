/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.antlr;

import java.io.Reader;
import java.io.StringReader;
import fixerror.antlr.ANTLRReaderStream_FIX;
import fixerror.antlr.CharStream_FIX;
import fixerror.antlr.TokenSource_FIX;
import org.eclipse.xtext.parser.antlr.TokenSourceProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
@SuppressWarnings("all")
public abstract class AbstractTokenSourceProvider implements TokenSourceProvider {
  protected CharStream_FIX getCharStream(final Reader reader) {
    try {
      return new ANTLRReaderStream_FIX(reader);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected StringReader getReader(final CharSequence text) {
    String _string = text.toString();
    return new StringReader(_string);
  }
  
  @Override
  public TokenSource_FIX createTokenSource(final CharSequence text) {
    return this.createTokenSource(this.getReader(text));
  }
  
  @Override
  public TokenSource_FIX createTokenSource(final Reader reader) {
    return this.createTokenSource(this.getCharStream(reader));
  }
}
