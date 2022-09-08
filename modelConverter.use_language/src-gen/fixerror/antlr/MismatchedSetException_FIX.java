package fixerror.antlr;

public class MismatchedSetException_FIX extends RecognitionException_FIX {
	public BitSet_FIX expecting;

	/** Used for remote debugger deserialization */
	public MismatchedSetException_FIX() {;}

	public MismatchedSetException_FIX(BitSet_FIX expecting, IntStream_FIX input) {
		super(input);
		this.expecting = expecting;
	}

	public String toString() {
		return "MismatchedSetException("+getUnexpectedType()+"!="+expecting+")";
	}
}

