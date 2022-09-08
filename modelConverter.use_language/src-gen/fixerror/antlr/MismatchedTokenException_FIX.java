package fixerror.antlr;

/** A mismatched char or Token or tree node */
public class MismatchedTokenException_FIX extends RecognitionException_FIX {
	public int expecting = Token_FIX.INVALID_TOKEN_TYPE;

	/** Used for remote debugger deserialization */
	public MismatchedTokenException_FIX() {;}

	public MismatchedTokenException_FIX(int expecting, IntStream_FIX input) {
		super(input);
		this.expecting = expecting;
	}

	public String toString() {
		return "MismatchedTokenException("+getUnexpectedType()+"!="+expecting+")";
	}
}

