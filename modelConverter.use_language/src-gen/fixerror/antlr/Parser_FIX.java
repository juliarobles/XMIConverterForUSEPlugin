package fixerror.antlr;

/** A parser for TokenStreams.  "parser grammars" result in a subclass
*  of this.
*/
public class Parser_FIX extends BaseRecognizer_FIX {
	public TokenStream_FIX input;

	public Parser_FIX(TokenStream_FIX input) {
		super(); // highlight that we go to super to set state object
		setTokenStream(input);
   }

	public Parser_FIX(TokenStream_FIX input, RecognizerSharedState_FIX state) {
		super(state); // share the state object with another parser
		setTokenStream(input);
   }

	public void reset() {
		super.reset(); // reset all recognizer state variables
		if ( input!=null ) {
			input.seek(0); // rewind the input
		}
	}

	protected Object getCurrentInputSymbol(IntStream_FIX input) {
		return ((TokenStream_FIX)input).LT(1);
	}

	protected Object getMissingSymbol(IntStream_FIX input,
									  RecognitionException_FIX e,
									  int expectedTokenType,
									  BitSet_FIX follow)
	{
		String tokenText = null;
		if ( expectedTokenType==Token_FIX.EOF ) tokenText = "<missing EOF>";
		else tokenText = "<missing "+getTokenNames()[expectedTokenType]+">";
		CommonToken_FIX t = new CommonToken_FIX(expectedTokenType, tokenText);
		Token_FIX current = ((TokenStream_FIX)input).LT(1);
		if ( current.getType() == Token_FIX.EOF ) {
			current = ((TokenStream_FIX)input).LT(-1);
		}
		t.line = current.getLine();
		t.charPositionInLine = current.getCharPositionInLine();
		t.channel = DEFAULT_TOKEN_CHANNEL;
		return t;
	}

	/** Set the token stream and reset the parser */
	public void setTokenStream(TokenStream_FIX input) {
		this.input = null;
		reset();
		this.input = input;
	}

   public TokenStream_FIX getTokenStream() {
		return input;
	}

	public String getSourceName() {
		return input.getSourceName();
	}

	public void traceIn(String ruleName, int ruleIndex)  {
		super.traceIn(ruleName, ruleIndex, input.LT(1));
	}

	public void traceOut(String ruleName, int ruleIndex)  {
		super.traceOut(ruleName, ruleIndex, input.LT(1));
	}
}

