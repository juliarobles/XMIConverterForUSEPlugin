/*
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.parser.antlr;

import com.google.inject.Inject;
import modelConverter.use_language.parser.antlr.internal.InternalUSEParser;
import modelConverter.use_language.services.USEGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class USEParser extends AbstractAntlrParser {

	@Inject
	private USEGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalUSEParser createParser(XtextTokenStream stream) {
		return new InternalUSEParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "ModelUSE";
	}

	public USEGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(USEGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
