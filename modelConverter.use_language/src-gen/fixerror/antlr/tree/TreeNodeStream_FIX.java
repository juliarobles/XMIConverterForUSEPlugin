package fixerror.antlr.tree;

import fixerror.antlr.IntStream_FIX;
import fixerror.antlr.TokenStream_FIX;

/** A stream of tree nodes, accessing nodes from a tree of some kind */
public interface TreeNodeStream_FIX extends IntStream_FIX {
	/** Get a tree node at an absolute index i; 0..n-1.
	 *  If you don't want to buffer up nodes, then this method makes no
	 *  sense for you.
	 */
	public Object get(int i);

	/** Get tree node at current input pointer + i ahead where i=1 is next node.
	 *  i<0 indicates nodes in the past.  So LT(-1) is previous node, but
	 *  implementations are not required to provide results for k < -1.
	 *  LT(0) is undefined.  For i>=n, return null.
	 *  Return null for LT(0) and any index that results in an absolute address
	 *  that is negative.
	 *
	 *  This is analogus to the LT() method of the TokenStream, but this
	 *  returns a tree node instead of a token.  Makes code gen identical
	 *  for both parser and tree grammars. :)
	 */
	public Object LT(int k);

	/** Where is this stream pulling nodes from?  This is not the name, but
	 *  the object that provides node objects.
	 */
	public Object getTreeSource();

	/** If the tree associated with this stream was created from a TokenStream,
	 *  you can specify it here.  Used to do rule $text attribute in tree
	 *  parser.  Optional unless you use tree parser rule text attribute
	 *  or output=template and rewrite=true options.
	 */
	public TokenStream_FIX getTokenStream();

	/** What adaptor can tell me how to interpret/navigate nodes and
	 *  trees.  E.g., get text of a node.
	 */
	public TreeAdaptor_FIX getTreeAdaptor();

	/** As we flatten the tree, we use UP, DOWN nodes to represent
	 *  the tree structure.  When debugging we need unique nodes
	 *  so we have to instantiate new ones.  When doing normal tree
	 *  parsing, it's slow and a waste of memory to create unique
	 *  navigation nodes.  Default should be false;
	 */
	public void setUniqueNavigationNodes(boolean uniqueNavigationNodes);

    /** Reset the tree node stream in such a way that it acts like
     *  a freshly constructed stream.
     */
    public void reset();

	/** Return the text of all nodes from start to stop, inclusive.
	 *  If the stream does not buffer all the nodes then it can still
	 *  walk recursively from start until stop.  You can always return
	 *  null or "" too, but users should not access $ruleLabel.text in
	 *  an action of course in that case.
	 */
	public String toString(Object start, Object stop);


	// REWRITING TREES (used by tree parser)

	/** Replace from start to stop child index of parent with t, which might
	 *  be a list.  Number of children may be different
	 *  after this call.  The stream is notified because it is walking the
	 *  tree and might need to know you are monkeying with the underlying
	 *  tree.  Also, it might be able to modify the node stream to avoid
	 *  restreaming for future phases.
	 *
	 *  If parent is null, don't do anything; must be at root of overall tree.
	 *  Can't replace whatever points to the parent externally.  Do nothing.
	 */
	public void replaceChildren(Object parent, int startChildIndex, int stopChildIndex, Object t);
}

