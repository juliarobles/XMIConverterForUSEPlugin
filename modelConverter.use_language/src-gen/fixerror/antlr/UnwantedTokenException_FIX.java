package fixerror.antlr;

/** An extra token while parsing a TokenStream */
public class UnwantedTokenException_FIX extends MismatchedTokenException_FIX {
	/** Used for remote debugger deserialization */
	public UnwantedTokenException_FIX() {;}

	public UnwantedTokenException_FIX(int expecting, IntStream_FIX input) {
		super(expecting, input);
	}

	public Token_FIX getUnexpectedToken() {
		return token;
	}

	public String toString() {
		String exp = ", expected "+expecting;
		if ( expecting==Token_FIX.INVALID_TOKEN_TYPE ) {
			exp = "";
		}
		if ( token==null ) {
			return "UnwantedTokenException(found="+null+exp+")";
		}
		return "UnwantedTokenException(found="+token.getText()+exp+")";
	}
}

