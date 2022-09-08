package fixerror.antlr;
/** A semantic predicate failed during validation.  Validation of predicates
*  occurs when normally parsing the alternative just like matching a token.
*  Disambiguating predicate evaluation occurs when we hoist a predicate into
*  a prediction decision.
*/
public class FailedPredicateException_FIX extends RecognitionException_FIX {
	public String ruleName;
	public String predicateText;

	/** Used for remote debugger deserialization */
	public FailedPredicateException_FIX() {;}

	public FailedPredicateException_FIX(IntStream_FIX input,
									String ruleName,
									String predicateText)
	{
		super(input);
		this.ruleName = ruleName;
		this.predicateText = predicateText;
	}

	public String toString() {
		return "FailedPredicateException("+ruleName+",{"+predicateText+"}?)";
	}
}
