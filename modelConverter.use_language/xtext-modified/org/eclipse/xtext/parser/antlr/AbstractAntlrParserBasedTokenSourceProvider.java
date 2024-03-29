/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import fixerror.antlr.CharStream_FIX;
import fixerror.antlr.TokenSource_FIX;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.AbstractTokenSourceProvider;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
@Singleton
@SuppressWarnings("all")
public class AbstractAntlrParserBasedTokenSourceProvider extends AbstractTokenSourceProvider {
  @Inject
  private IParser parser;
  
  @Override
  public TokenSource_FIX createTokenSource(final CharStream_FIX stream) {
    if ((this.parser instanceof AbstractAntlrParser)) {
      return ((AbstractAntlrParser)this.parser).createLexer(stream);
    }
    StringConcatenation _builder = new StringConcatenation();
    String _name = this.parser.getClass().getName();
    _builder.append(_name);
    _builder.append(" should be a subclass of ");
    String _name_1 = AbstractAntlrParser.class.getName();
    _builder.append(_name_1);
    throw new IllegalStateException(_builder.toString());
  }
}
