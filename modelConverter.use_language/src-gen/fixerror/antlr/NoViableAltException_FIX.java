package fixerror.antlr;

public class NoViableAltException_FIX extends RecognitionException_FIX {
	public String grammarDecisionDescription;
	public int decisionNumber;
	public int stateNumber;

	/** Used for remote debugger deserialization */
	public NoViableAltException_FIX() {;}
	
	public NoViableAltException_FIX(String grammarDecisionDescription,
								int decisionNumber,
								int stateNumber,
								IntStream_FIX input)
	{
		super(input);
		this.grammarDecisionDescription = grammarDecisionDescription;
		this.decisionNumber = decisionNumber;
		this.stateNumber = stateNumber;
	}

	public String toString() {
		if ( input instanceof CharStream_FIX ) {
			return "NoViableAltException('"+(char)getUnexpectedType()+"'@["+grammarDecisionDescription+"])";
		}
		else {
			return "NoViableAltException("+getUnexpectedType()+"@["+grammarDecisionDescription+"])";
		}
	}
}

