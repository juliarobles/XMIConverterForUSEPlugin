package fixerror.antlr;

import fixerror.antlr.tree.*;

/** The root of the ANTLR exception hierarchy.
*
*  To avoid English-only error messages and to generally make things
*  as flexible as possible, these exceptions are not created with strings,
*  but rather the information necessary to generate an error.  Then
*  the various reporting methods in Parser and Lexer can be overridden
*  to generate a localized error message.  For example, MismatchedToken
*  exceptions are built with the expected token type.
*  So, don't expect getMessage() to return anything.
*
*  Note that as of Java 1.4, you can access the stack trace, which means
*  that you can compute the complete trace of rules from the start symbol.
*  This gives you considerable context information with which to generate
*  useful error messages.
*
*  ANTLR generates code that throws exceptions upon recognition error and
*  also generates code to catch these exceptions in each rule.  If you
*  want to quit upon first error, you can turn off the automatic error
*  handling mechanism using rulecatch action, but you still need to
*  override methods mismatch and recoverFromMismatchSet.
*
*  In general, the recognition exceptions can track where in a grammar a
*  problem occurred and/or what was the expected input.  While the parser
*  knows its state (such as current input symbol and line info) that
*  state can change before the exception is reported so current token index
*  is computed and stored at exception time.  From this info, you can
*  perhaps print an entire line of input not just a single token, for example.
*  Better to just say the recognizer had a problem and then let the parser
*  figure out a fancy report.
*/
public class RecognitionException_FIX extends Exception {
	/** What input stream did the error occur in? */
	public transient IntStream_FIX input;

	/** What is index of token/char were we looking at when the error occurred? */
	public int index;

	/** The current Token when an error occurred.  Since not all streams
	 *  can retrieve the ith Token, we have to track the Token object.
	 *  For parsers.  Even when it's a tree parser, token might be set.
	 */
	public Token_FIX token;

	/** If this is a tree parser exception, node is set to the node with
	 *  the problem.
	 */
	public Object node;

	/** The current char when an error occurred. For lexers. */
	public int c;

	/** Track the line at which the error occurred in case this is
	 *  generated from a lexer.  We need to track this since the
	 *  unexpected char doesn't carry the line info.
	 */
	public int line;

	public int charPositionInLine;

	/** If you are parsing a tree node stream, you will encounter som
	 *  imaginary nodes w/o line/col info.  We now search backwards looking
	 *  for most recent token with line/col info, but notify getErrorHeader()
	 *  that info is approximate.
	 */
	public boolean approximateLineInfo;

	/** Used for remote debugger deserialization */
	public RecognitionException_FIX() {
	}

	public RecognitionException_FIX(IntStream_FIX input) {
		this.input = input;
		this.index = input.index();
		if ( input instanceof TokenStream_FIX ) {
			this.token = ((TokenStream_FIX)input).LT(1);
			this.line = token.getLine();
			this.charPositionInLine = token.getCharPositionInLine();
		}
		if ( input instanceof TreeNodeStream_FIX ) {
			extractInformationFromTreeNodeStream(input);
		}
		else if ( input instanceof CharStream_FIX ) {
			this.c = input.LA(1);
			this.line = ((CharStream_FIX)input).getLine();
			this.charPositionInLine = ((CharStream_FIX)input).getCharPositionInLine();
		}
		else {
			this.c = input.LA(1);
		}
	}

	protected void extractInformationFromTreeNodeStream(IntStream_FIX input) {
		TreeNodeStream_FIX nodes = (TreeNodeStream_FIX)input;
		this.node = nodes.LT(1);
		TreeAdaptor_FIX adaptor = nodes.getTreeAdaptor();
		Token_FIX payload = adaptor.getToken(node);
		if ( payload!=null ) {
			this.token = payload;
			if ( payload.getLine()<= 0 ) {
				// imaginary node; no line/pos info; scan backwards
				int i = -1;
				Object priorNode = nodes.LT(i);
				while ( priorNode!=null ) {
					Token_FIX priorPayload = adaptor.getToken(priorNode);
					if ( priorPayload!=null && priorPayload.getLine()>0 ) {
						// we found the most recent real line / pos info
						this.line = priorPayload.getLine();
						this.charPositionInLine = priorPayload.getCharPositionInLine();
						this.approximateLineInfo = true;
						break;
					}
					--i;
					priorNode = nodes.LT(i);
				}
			}
			else { // node created from real token
				this.line = payload.getLine();
				this.charPositionInLine = payload.getCharPositionInLine();
			}
		}
		else if ( this.node instanceof Tree_FIX) {
			this.line = ((Tree_FIX)this.node).getLine();
			this.charPositionInLine = ((Tree_FIX)this.node).getCharPositionInLine();
			if ( this.node instanceof CommonTree_FIX) {
				this.token = ((CommonTree_FIX)this.node).token;
			}
		}
		else {
			int type = adaptor.getType(this.node);
			String text = adaptor.getText(this.node);
			this.token = new CommonToken_FIX(type, text);
		}
	}

	/** Return the token type or char of the unexpected input element */
	public int getUnexpectedType() {
		if ( input instanceof TokenStream_FIX ) {
			return token.getType();
		}
		else if ( input instanceof TreeNodeStream_FIX ) {
			TreeNodeStream_FIX nodes = (TreeNodeStream_FIX)input;
			TreeAdaptor_FIX adaptor = nodes.getTreeAdaptor();
			return adaptor.getType(node);
		}
		else {
			return c;
		}
	}
}

