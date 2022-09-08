package fixerror.antlr;

/**  The recognizer did not match anything for a (..)+ loop. */
public class EarlyExitException_FIX extends RecognitionException_FIX {
	public int decisionNumber;

	/** Used for remote debugger deserialization */
	public EarlyExitException_FIX() {;}
	
	public EarlyExitException_FIX(int decisionNumber, IntStream_FIX input) {
		super(input);
		this.decisionNumber = decisionNumber;
	}
}

