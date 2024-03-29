package fixerror.antlr;

import java.io.Serializable;

public class CommonToken_FIX implements Token_FIX, Serializable {
	protected int type;
	protected int line;
	protected int charPositionInLine = -1; // set to invalid position
	protected int channel=DEFAULT_CHANNEL;
	protected transient CharStream_FIX input;

	/** We need to be able to change the text once in a while.  If
	 *  this is non-null, then getText should return this.  Note that
	 *  start/stop are not affected by changing this.
	  */
	protected String text;

	/** What token number is this from 0..n-1 tokens; < 0 implies invalid index */
	protected int index = -1;

	/** The char position into the input buffer where this token starts */
	protected int start;

	/** The char position into the input buffer where this token stops */
	protected int stop;

	public CommonToken_FIX(int type) {
		this.type = type;
	}

	public CommonToken_FIX(CharStream_FIX input, int type, int channel, int start, int stop) {
		this.input = input;
		this.type = type;
		this.channel = channel;
		this.start = start;
		this.stop = stop;
	}

	public CommonToken_FIX(int type, String text) {
		this.type = type;
		this.channel = DEFAULT_CHANNEL;
		this.text = text;
	}

	public CommonToken_FIX(Token_FIX oldToken) {
		text = oldToken.getText();
		type = oldToken.getType();
		line = oldToken.getLine();
		index = oldToken.getTokenIndex();
		charPositionInLine = oldToken.getCharPositionInLine();
		channel = oldToken.getChannel();
		if ( oldToken instanceof CommonToken_FIX ) {
			start = ((CommonToken_FIX)oldToken).start;
			stop = ((CommonToken_FIX)oldToken).stop;
		}
	}

	public int getType() {
		return type;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getText() {
		if ( text!=null ) {
			return text;
		}
		if ( input==null ) {
			return null;
		}
		text = input.substring(start,stop);
		return text;
	}

	/** Override the text for this token.  getText() will return this text
	 *  rather than pulling from the buffer.  Note that this does not mean
	 *  that start/stop indexes are not valid.  It means that that input
	 *  was converted to a new string in the token object.
	 */
	public void setText(String text) {
		this.text = text;
	}

	public int getLine() {
		return line;
	}

	public int getCharPositionInLine() {
		return charPositionInLine;
	}

	public void setCharPositionInLine(int charPositionInLine) {
		this.charPositionInLine = charPositionInLine;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStartIndex() {
		return start;
	}

	public void setStartIndex(int start) {
		this.start = start;
	}

	public int getStopIndex() {
		return stop;
	}

	public void setStopIndex(int stop) {
		this.stop = stop;
	}

	public int getTokenIndex() {
		return index;
	}

	public void setTokenIndex(int index) {
		this.index = index;
	}

	public CharStream_FIX getInputStream() {
		return input;
	}

	public void setInputStream(CharStream_FIX input) {
		this.input = input;
	}

	public String toString() {
		String channelStr = "";
		if ( channel>0 ) {
			channelStr=",channel="+channel;
		}
		String txt = getText();
		if ( txt!=null ) {
			txt = txt.replaceAll("\n","\\\\n");
			txt = txt.replaceAll("\r","\\\\r");
			txt = txt.replaceAll("\t","\\\\t");
		}
		else {
			txt = "<no text>";
		}
		return "[@"+getTokenIndex()+","+start+":"+stop+"='"+txt+"',<"+type+">"+channelStr+","+line+":"+getCharPositionInLine()+"]";
	}
}

