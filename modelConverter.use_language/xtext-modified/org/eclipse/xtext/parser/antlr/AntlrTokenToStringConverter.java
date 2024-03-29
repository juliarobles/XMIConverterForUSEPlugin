/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import fixerror.antlr.Token_FIX;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.impl.DatatypeRuleToken;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrTokenToStringConverter implements ITokenToStringConverter {

	@Override
	public Object getTokenAsStringIfPossible(Object tokenOrValue) {
		Object value = tokenOrValue;
		if (value instanceof DatatypeRuleToken) {
			value = ((DatatypeRuleToken) value).getText();
		} else if (value instanceof Token_FIX) {
			value = ((Token_FIX) value).getText();
		}
		return value;
	}

}
