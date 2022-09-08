package fixerror.antlr;

public class MismatchedRangeException_FIX extends RecognitionException_FIX {
	public int a,b;

	/** Used for remote debugger deserialization */
	public MismatchedRangeException_FIX() {;}

	public MismatchedRangeException_FIX(int a, int b, IntStream_FIX input) {
		super(input);
		this.a = a;
		this.b = b;
	}

	public String toString() {
		return "MismatchedNotSetException("+getUnexpectedType()+" not in ["+a+","+b+"])";
	}
}

