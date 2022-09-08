package fixerror.antlr;

public class MismatchedNotSetException_FIX extends MismatchedSetException_FIX {
	/** Used for remote debugger deserialization */
	public MismatchedNotSetException_FIX() {;}

	public MismatchedNotSetException_FIX(BitSet_FIX expecting, IntStream_FIX input) {
		super(expecting, input);
	}

	public String toString() {
		return "MismatchedNotSetException("+getUnexpectedType()+"!="+expecting+")";
	}
}

