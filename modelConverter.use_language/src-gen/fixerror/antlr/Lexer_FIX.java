package fixerror.antlr;

/** A lexer is recognizer that draws input symbols from a character stream.
*  lexer grammars result in a subclass of this object. A Lexer object
*  uses simplified match() and error recovery mechanisms in the interest
*  of speed.
*/
public abstract class Lexer_FIX extends BaseRecognizer_FIX implements TokenSource_FIX {
	/** Where is the lexer drawing characters from? */
	protected CharStream_FIX input;

	public Lexer_FIX() {
	}

	public Lexer_FIX(CharStream_FIX input) {
		this.input = input;
	}

	public Lexer_FIX(CharStream_FIX input, RecognizerSharedState_FIX state) {
		super(state);
		this.input = input;
	}

	public void reset() {
		super.reset(); // reset all recognizer state variables
		// wack Lexer state variables
		if ( input!=null ) {
			input.seek(0); // rewind the input
		}
		if ( state==null ) {
			return; // no shared state work to do
		}
		state.token = null;
		state.type = Token_FIX.INVALID_TOKEN_TYPE;
		state.channel = Token_FIX.DEFAULT_CHANNEL;
		state.tokenStartCharIndex = -1;
		state.tokenStartCharPositionInLine = -1;
		state.tokenStartLine = -1;
		state.text = null;
	}

	/** Return a token from this source; i.e., match a token on the char
	 *  stream.
	 */
	public Token_FIX nextToken() {
		while (true) {
			state.token = null;
			state.channel = Token_FIX.DEFAULT_CHANNEL;
			state.tokenStartCharIndex = input.index();
			state.tokenStartCharPositionInLine = input.getCharPositionInLine();
			state.tokenStartLine = input.getLine();
			state.text = null;
			if ( input.LA(1)==CharStream_FIX.EOF ) {
				return Token_FIX.EOF_TOKEN;
			}
			try {
				mTokens();
				if ( state.token==null ) {
					emit();
				}
				else if ( state.token==Token_FIX.SKIP_TOKEN ) {
					continue;
				}
				return state.token;
			}
			catch (NoViableAltException_FIX nva) {
				reportError(nva);
				recover(nva); // throw out current char and try again
			}
			catch (RecognitionException_FIX re) {
				reportError(re);
				// match() routine has already called recover()
			}
		}
	}

	/** Instruct the lexer to skip creating a token for current lexer rule
	 *  and look for another token.  nextToken() knows to keep looking when
	 *  a lexer rule finishes with token set to SKIP_TOKEN.  Recall that
	 *  if token==null at end of any token rule, it creates one for you
	 *  and emits it.
	 */
	public void skip() {
		state.token = Token_FIX.SKIP_TOKEN;
	}

	/** This is the lexer entry point that sets instance var 'token' */
	public abstract void mTokens() throws RecognitionException_FIX;

	/** Set the char stream and reset the lexer */
	public void setCharStream(CharStream_FIX input) {
		this.input = null;
		reset();
		this.input = input;
	}

	public CharStream_FIX getCharStream() {
		return this.input;
	}

	public String getSourceName() {
		return input.getSourceName();
	}

	/** Currently does not support multiple emits per nextToken invocation
	 *  for efficiency reasons.  Subclass and override this method and
	 *  nextToken (to push tokens into a list and pull from that list rather
	 *  than a single variable as this implementation does).
	 */
	public void emit(Token_FIX token) {
		state.token = token;
	}

	/** The standard method called to automatically emit a token at the
	 *  outermost lexical rule.  The token object should point into the
	 *  char buffer start..stop.  If there is a text override in 'text',
	 *  use that to set the token's text.  Override this method to emit
	 *  custom Token objects.
	 *
	 *  If you are building trees, then you should also override
	 *  Parser or TreeParser.getMissingSymbol().
	 */
	public Token_FIX emit() {
		Token_FIX t = new CommonToken_FIX(input, state.type, state.channel, state.tokenStartCharIndex, getCharIndex()-1);
		t.setLine(state.tokenStartLine);
		t.setText(state.text);
		t.setCharPositionInLine(state.tokenStartCharPositionInLine);
		emit(t);
		return t;
	}

	public void match(String s) throws MismatchedTokenException_FIX {
		int i = 0;
		while ( i<s.length() ) {
			if ( input.LA(1)!=s.charAt(i) ) {
				if ( state.backtracking>0 ) {
					state.failed = true;
					return;
				}
				MismatchedTokenException_FIX mte =
					new MismatchedTokenException_FIX(s.charAt(i), input);
				recover(mte);
				throw mte;
			}
			i++;
			input.consume();
			state.failed = false;
		}
	}

	public void matchAny() {
		input.consume();
	}

	public void match(int c) throws MismatchedTokenException_FIX {
		if ( input.LA(1)!=c ) {
			if ( state.backtracking>0 ) {
				state.failed = true;
				return;
			}
			MismatchedTokenException_FIX mte =
				new MismatchedTokenException_FIX(c, input);
			recover(mte);  // don't really recover; just consume in lexer
			throw mte;
		}
		input.consume();
		state.failed = false;
	}

	public void matchRange(int a, int b)
		throws MismatchedRangeException_FIX
	{
		if ( input.LA(1)<a || input.LA(1)>b ) {
			if ( state.backtracking>0 ) {
				state.failed = true;
				return;
			}
			MismatchedRangeException_FIX mre =
				new MismatchedRangeException_FIX(a,b,input);
			recover(mre);
			throw mre;
		}
		input.consume();
		state.failed = false;
	}

	public int getLine() {
		return input.getLine();
	}

	public int getCharPositionInLine() {
		return input.getCharPositionInLine();
	}

	/** What is the index of the current character of lookahead? */
	public int getCharIndex() {
		return input.index();
	}

	/** Return the text matched so far for the current token or any
	 *  text override.
	 */
	public String getText() {
		if ( state.text!=null ) {
			return state.text;
		}
		return input.substring(state.tokenStartCharIndex,getCharIndex()-1);
	}

	/** Set the complete text of this token; it wipes any previous
	 *  changes to the text.
	 */
	public void setText(String text) {
		state.text = text;
	}

	public void reportError(RecognitionException_FIX e) {
		/** TODO: not thought about recovery in lexer yet.
		 *
		// if we've already reported an error and have not matched a token
		// yet successfully, don't report any errors.
		if ( errorRecovery ) {
			//System.err.print("[SPURIOUS] ");
			return;
		}
		errorRecovery = true;
		 */

		displayRecognitionError(this.getTokenNames(), e);
	}

	public String getErrorMessage(RecognitionException_FIX e, String[] tokenNames) {
		String msg = null;
		if ( e instanceof MismatchedTokenException_FIX ) {
			MismatchedTokenException_FIX mte = (MismatchedTokenException_FIX)e;
			msg = "mismatched character "+getCharErrorDisplay(e.c)+" expecting "+getCharErrorDisplay(mte.expecting);
		}
		else if ( e instanceof NoViableAltException_FIX ) {
			NoViableAltException_FIX nvae = (NoViableAltException_FIX)e;
			// for development, can add "decision=<<"+nvae.grammarDecisionDescription+">>"
			// and "(decision="+nvae.decisionNumber+") and
			// "state "+nvae.stateNumber
			msg = "no viable alternative at character "+getCharErrorDisplay(e.c);
		}
		else if ( e instanceof EarlyExitException_FIX ) {
			EarlyExitException_FIX eee = (EarlyExitException_FIX)e;
			// for development, can add "(decision="+eee.decisionNumber+")"
			msg = "required (...)+ loop did not match anything at character "+getCharErrorDisplay(e.c);
		}
		else if ( e instanceof MismatchedNotSetException_FIX ) {
			MismatchedNotSetException_FIX mse = (MismatchedNotSetException_FIX)e;
			msg = "mismatched character "+getCharErrorDisplay(e.c)+" expecting set "+mse.expecting;
		}
		else if ( e instanceof MismatchedSetException_FIX ) {
			MismatchedSetException_FIX mse = (MismatchedSetException_FIX)e;
			msg = "mismatched character "+getCharErrorDisplay(e.c)+" expecting set "+mse.expecting;
		}
		else if ( e instanceof MismatchedRangeException_FIX ) {
			MismatchedRangeException_FIX mre = (MismatchedRangeException_FIX)e;
			msg = "mismatched character "+getCharErrorDisplay(e.c)+" expecting set "+
				  getCharErrorDisplay(mre.a)+".."+getCharErrorDisplay(mre.b);
		}
		else {
			msg = super.getErrorMessage(e, tokenNames);
		}
		return msg;
	}

	public String getCharErrorDisplay(int c) {
		String s = String.valueOf((char)c);
		switch ( c ) {
			case Token_FIX.EOF :
				s = "<EOF>";
				break;
			case '\n' :
				s = "\\n";
				break;
			case '\t' :
				s = "\\t";
				break;
			case '\r' :
				s = "\\r";
				break;
		}
		return "'"+s+"'";
	}

	/** Lexers can normally match any char in it's vocabulary after matching
	 *  a token, so do the easy thing and just kill a character and hope
	 *  it all works out.  You can instead use the rule invocation stack
	 *  to do sophisticated error recovery if you are in a fragment rule.
	 */
	public void recover(RecognitionException_FIX re) {
		//System.out.println("consuming char "+(char)input.LA(1)+" during recovery");
		//re.printStackTrace();
		input.consume();
	}

	public void traceIn(String ruleName, int ruleIndex)  {
		String inputSymbol = ((char)input.LT(1))+" line="+getLine()+":"+getCharPositionInLine();
		super.traceIn(ruleName, ruleIndex, inputSymbol);
	}

	public void traceOut(String ruleName, int ruleIndex)  {
		String inputSymbol = ((char)input.LT(1))+" line="+getLine()+":"+getCharPositionInLine();
		super.traceOut(ruleName, ruleIndex, inputSymbol);
	}
}

