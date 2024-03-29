package fixerror.antlr;

/** A stream of tokens accessing tokens from a TokenSource */
public interface TokenStream_FIX extends IntStream_FIX {
   /** Get Token at current input pointer + i ahead where i=1 is next Token.
	 *  i<0 indicates tokens in the past.  So -1 is previous token and -2 is
	 *  two tokens ago. LT(0) is undefined.  For i>=n, return Token.EOFToken.
	 *  Return null for LT(0) and any index that results in an absolute address
	 *  that is negative.
	 */
   public Token_FIX LT(int k);

	/** Get a token at an absolute index i; 0..n-1.  This is really only
	 *  needed for profiling and debugging and token stream rewriting.
	 *  If you don't want to buffer up tokens, then this method makes no
	 *  sense for you.  Naturally you can't use the rewrite stream feature.
	 *  I believe DebugTokenStream can easily be altered to not use
	 *  this method, removing the dependency.
	 */
	public Token_FIX get(int i);

	/** Where is this stream pulling tokens from?  This is not the name, but
	 *  the object that provides Token objects.
	 */
	public TokenSource_FIX getTokenSource();

	/** Return the text of all tokens from start to stop, inclusive.
	 *  If the stream does not buffer all the tokens then it can just
	 *  return "" or null;  Users should not access $ruleLabel.text in
	 *  an action of course in that case.
	 */
	public String toString(int start, int stop);

	/** Because the user is not required to use a token with an index stored
	 *  in it, we must provide a means for two token objects themselves to
	 *  indicate the start/end location.  Most often this will just delegate
	 *  to the other toString(int,int).  This is also parallel with
	 *  the TreeNodeStream.toString(Object,Object).
	 */
	public String toString(Token_FIX start, Token_FIX stop);
}

