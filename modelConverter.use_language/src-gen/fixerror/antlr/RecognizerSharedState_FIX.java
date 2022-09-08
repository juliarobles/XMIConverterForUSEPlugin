package fixerror.antlr;

import java.util.Map;

/** The set of fields needed by an abstract recognizer to recognize input
 *  and recover from errors etc...  As a separate state object, it can be
 *  shared among multiple grammars; e.g., when one grammar imports another.
 *
 *  These fields are publically visible but the actual state pointer per
 *  parser is protected.
 */
public class RecognizerSharedState_FIX{
	/** Track the set of token types that can follow any rule invocation.
	 *  Stack grows upwards.  When it hits the max, it grows 2x in size
	 *  and keeps going.
	 */
	public BitSet_FIX[] following = new BitSet_FIX[BaseRecognizer_FIX.INITIAL_FOLLOW_STACK_SIZE];
	public int _fsp = -1;

	/** This is true when we see an error and before having successfully
	 *  matched a token.  Prevents generation of more than one error message
	 *  per error.
	 */
	public boolean errorRecovery = false;

	/** The index into the input stream where the last error occurred.
	 * 	This is used to prevent infinite loops where an error is found
	 *  but no token is consumed during recovery...another error is found,
	 *  ad naseum.  This is a failsafe mechanism to guarantee that at least
	 *  one token/tree node is consumed for two errors.
	 */
	public int lastErrorIndex = -1;

	/** In lieu of a return value, this indicates that a rule or token
	 *  has failed to match.  Reset to false upon valid token match.
	 */
	public boolean failed = false;

	/** Did the recognizer encounter a syntax error?  Track how many. */
	public int syntaxErrors = 0;

	/** If 0, no backtracking is going on.  Safe to exec actions etc...
	 *  If >0 then it's the level of backtracking.
	 */
	public int backtracking = 0;

	/** An array[size num rules] of Map<Integer,Integer> that tracks
	 *  the stop token index for each rule.  ruleMemo[ruleIndex] is
	 *  the memoization table for ruleIndex.  For key ruleStartIndex, you
	 *  get back the stop token for associated rule or MEMO_RULE_FAILED.
	 *
	 *  This is only used if rule memoization is on (which it is by default).
	 */
	public Map[] ruleMemo;


	// LEXER FIELDS (must be in same state object to avoid casting
	//               constantly in generated code and Lexer object) :(


	/** The goal of all lexer rules/methods is to create a token object.
	 *  This is an instance variable as multiple rules may collaborate to
	 *  create a single token.  nextToken will return this object after
	 *  matching lexer rule(s).  If you subclass to allow multiple token
	 *  emissions, then set this to the last token to be matched or
	 *  something nonnull so that the auto token emit mechanism will not
	 *  emit another token.
	 */
    public Token_FIX token;

	/** What character index in the stream did the current token start at?
	 *  Needed, for example, to get the text for current token.  Set at
	 *  the start of nextToken.
 	 */
	public int tokenStartCharIndex = -1;

	/** The line on which the first character of the token resides */
	public int tokenStartLine;

	/** The character position of first character within the line */
	public int tokenStartCharPositionInLine;

	/** The channel number for the current token */
	public int channel;

	/** The token type for the current token */
	public int type;

	/** You can set the text for the current token to override what is in
	 *  the input char buffer.  Use setText() or can set this instance var.
 	 */
	public String text;

    public RecognizerSharedState_FIX() {;}
    
    public RecognizerSharedState_FIX(RecognizerSharedState_FIX state) {
        if ( this.following.length < state.following.length ) {
            this.following = new BitSet_FIX[state.following.length];
        }
        System.arraycopy(state.following, 0, this.following, 0, state.following.length);
        this._fsp = state._fsp;
        this.errorRecovery = state.errorRecovery;
        this.lastErrorIndex = state.lastErrorIndex;
        this.failed = state.failed;
        this.syntaxErrors = state.syntaxErrors;
        this.backtracking = state.backtracking;
        if ( state.ruleMemo!=null ) {
            this.ruleMemo = new Map[state.ruleMemo.length];
            System.arraycopy(state.ruleMemo, 0, this.ruleMemo, 0, state.ruleMemo.length);
        }
        this.token = state.token;
        this.tokenStartCharIndex = state.tokenStartCharIndex;
        this.tokenStartCharPositionInLine = state.tokenStartCharPositionInLine;
        this.channel = state.channel;
        this.type = state.type;
        this.text = state.text;
    }
}

