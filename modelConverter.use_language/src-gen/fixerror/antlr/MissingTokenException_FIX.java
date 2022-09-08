package fixerror.antlr;

/** We were expecting a token but it's not found.  The current token
*  is actually what we wanted next.  Used for tree node errors too.
*/
public class MissingTokenException_FIX extends MismatchedTokenException_FIX {
	public Object inserted;
	/** Used for remote debugger deserialization */
	public MissingTokenException_FIX() {;}

	public MissingTokenException_FIX(int expecting, IntStream_FIX input, Object inserted) {
		super(expecting, input);
		this.inserted = inserted;
	}

	public int getMissingType() {
		return expecting;
	}

	public String toString() {
		if ( inserted!=null && token!=null ) {
			return "MissingTokenException(inserted "+inserted+" at "+token.getText()+")";
		}
		if ( token!=null ) {
			return "MissingTokenException(at "+token.getText()+")";
		}
		return "MissingTokenException";
	}
}

