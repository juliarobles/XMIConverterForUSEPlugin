package fixerror.antlr.tree;

import java.util.ArrayList;
import java.util.List;

/** A generic tree implementation with no payload.  You must subclass to
*  actually have any user data.  ANTLR v3 uses a list of children approach
*  instead of the child-sibling approach in v2.  A flat tree (a list) is
*  an empty node whose children represent the list.  An empty, but
*  non-null node is called "nil".
*/
public abstract class BaseTree_FIX implements Tree_FIX {
	protected List children;

	public BaseTree_FIX() {
	}

	/** Create a new node from an existing node does nothing for BaseTree
	 *  as there are no fields other than the children list, which cannot
	 *  be copied as the children are not considered part of this node. 
	 */
	public BaseTree_FIX(Tree_FIX node) {
	}

	public Tree_FIX getChild(int i) {
		if ( children==null || i>=children.size() ) {
			return null;
		}
		return (Tree_FIX)children.get(i);
	}

	/** Get the children internal List; note that if you directly mess with
	 *  the list, do so at your own risk.
	 */
	public List getChildren() {
		return children;
	}

	public Tree_FIX getFirstChildWithType(int type) {
		for (int i = 0; children!=null && i < children.size(); i++) {
			Tree_FIX t = (Tree_FIX) children.get(i);
			if ( t.getType()==type ) {
				return t;
			}
		}	
		return null;
	}

	public int getChildCount() {
		if ( children==null ) {
			return 0;
		}
		return children.size();
	}

	/** Add t as child of this node.
	 *
	 *  Warning: if t has no children, but child does
	 *  and child isNil then this routine moves children to t via
	 *  t.children = child.children; i.e., without copying the array.
	 */
	public void addChild(Tree_FIX t) {
		//System.out.println("add child "+t.toStringTree()+" "+this.toStringTree());
		//System.out.println("existing children: "+children);
		if ( t==null ) {
			return; // do nothing upon addChild(null)
		}
		BaseTree_FIX childTree = (BaseTree_FIX)t;
		if ( childTree.isNil() ) { // t is an empty node possibly with children
			if ( this.children!=null && this.children == childTree.children ) {
				throw new RuntimeException("attempt to add child list to itself");
			}
			// just add all of childTree's children to this
			if ( childTree.children!=null ) {
				if ( this.children!=null ) { // must copy, this has children already
					int n = childTree.children.size();
					for (int i = 0; i < n; i++) {
						Tree_FIX c = (Tree_FIX)childTree.children.get(i);
						this.children.add(c);
						// handle double-link stuff for each child of nil root
						c.setParent(this);
						c.setChildIndex(children.size()-1);
					}
				}
				else {
					// no children for this but t has children; just set pointer
					// call general freshener routine
					this.children = childTree.children;
					this.freshenParentAndChildIndexes();
				}
			}
		}
		else { // child is not nil (don't care about children)
			if ( children==null ) {
				children = createChildrenList(); // create children list on demand
			}
			children.add(t);
			childTree.setParent(this);
			childTree.setChildIndex(children.size()-1);
		}
		// System.out.println("now children are: "+children);
	}

	/** Add all elements of kids list as children of this node */
	public void addChildren(List kids) {
		for (int i = 0; i < kids.size(); i++) {
			Tree_FIX t = (Tree_FIX) kids.get(i);
			addChild(t);
		}
	}

	public void setChild(int i, Tree_FIX t) {
		if ( t==null ) {
			return;
		}
		if ( t.isNil() ) {
			throw new IllegalArgumentException("Can't set single child to a list");
		}
		if ( children==null ) {
			children = createChildrenList();
		}
		children.set(i, t);
		t.setParent(this);
		t.setChildIndex(i);
	}
	
	public Object deleteChild(int i) {
		if ( children==null ) {
			return null;
		}
		Tree_FIX killed = (Tree_FIX)children.remove(i);
		// walk rest and decrement their child indexes
		this.freshenParentAndChildIndexes(i);
		return killed;
	}

	/** Delete children from start to stop and replace with t even if t is
	 *  a list (nil-root tree).  num of children can increase or decrease.
	 *  For huge child lists, inserting children can force walking rest of
	 *  children to set their childindex; could be slow.
	 */
	public void replaceChildren(int startChildIndex, int stopChildIndex, Object t) {
		/*
		System.out.println("replaceChildren "+startChildIndex+", "+stopChildIndex+
						   " with "+((BaseTree)t).toStringTree());
		System.out.println("in="+toStringTree());
		*/
		if ( children==null ) {
			throw new IllegalArgumentException("indexes invalid; no children in list");
		}
		int replacingHowMany = stopChildIndex - startChildIndex + 1;
		int replacingWithHowMany;
		BaseTree_FIX newTree = (BaseTree_FIX)t;
		List newChildren = null;
		// normalize to a list of children to add: newChildren
		if ( newTree.isNil() ) {
			newChildren = newTree.children;
		}
		else {
			newChildren = new ArrayList(1);
			newChildren.add(newTree);
		}
		replacingWithHowMany = newChildren.size();
		int numNewChildren = newChildren.size();
		int delta = replacingHowMany - replacingWithHowMany;
		// if same number of nodes, do direct replace
		if ( delta == 0 ) {
			int j = 0; // index into new children
			for (int i=startChildIndex; i<=stopChildIndex; i++) {
				BaseTree_FIX child = (BaseTree_FIX)newChildren.get(j);
				children.set(i, child);
				child.setParent(this);
				child.setChildIndex(i);
               j++;
           }
		}
		else if ( delta > 0 ) { // fewer new nodes than there were
			// set children and then delete extra
			for (int j=0; j<numNewChildren; j++) {
				children.set(startChildIndex+j, newChildren.get(j));
			}
			int indexToDelete = startChildIndex+numNewChildren;
			for (int c=indexToDelete; c<=stopChildIndex; c++) {
				// delete same index, shifting everybody down each time
				children.remove(indexToDelete);
			}
			freshenParentAndChildIndexes(startChildIndex);
		}
		else { // more new nodes than were there before
			// fill in as many children as we can (replacingHowMany) w/o moving data
			for (int j=0; j<replacingHowMany; j++) {
				children.set(startChildIndex+j, newChildren.get(j));
			}
			int numToInsert = replacingWithHowMany-replacingHowMany;
			for (int j=replacingHowMany; j<replacingWithHowMany; j++) {
				children.add(startChildIndex+j, newChildren.get(j));
			}
			freshenParentAndChildIndexes(startChildIndex);
		}
		//System.out.println("out="+toStringTree());
	}

	/** Override in a subclass to change the impl of children list */
	protected List createChildrenList() {
		return new ArrayList();
	}

	public boolean isNil() {
		return false;
	}

	/** Set the parent and child index values for all child of t */
	public void freshenParentAndChildIndexes() {
		freshenParentAndChildIndexes(0);
	}

	public void freshenParentAndChildIndexes(int offset) {
		int n = getChildCount();
		for (int c = offset; c < n; c++) {
			Tree_FIX child = (Tree_FIX)getChild(c);
			child.setChildIndex(c);
			child.setParent(this);
		}
	}

	public void sanityCheckParentAndChildIndexes() {
		sanityCheckParentAndChildIndexes(null, -1);
	}

	public void sanityCheckParentAndChildIndexes(Tree_FIX parent, int i) {
		if ( parent!=this.getParent() ) {
			throw new IllegalStateException("parents don't match; expected "+parent+" found "+this.getParent());
		}
		if ( i!=this.getChildIndex() ) {
			throw new IllegalStateException("child indexes don't match; expected "+i+" found "+this.getChildIndex());
		}
		int n = this.getChildCount();
		for (int c = 0; c < n; c++) {
			CommonTree_FIX child = (CommonTree_FIX)this.getChild(c);
			child.sanityCheckParentAndChildIndexes(this, c);
		}
	}

	/** BaseTree doesn't track child indexes. */
	public int getChildIndex() {
		return 0;
	}
	public void setChildIndex(int index) {
	}

	/** BaseTree doesn't track parent pointers. */
	public Tree_FIX getParent() {
		return null;
	}

   public void setParent(Tree_FIX t) {
	}

   /** Walk upwards looking for ancestor with this token type. */
   public boolean hasAncestor(int ttype) { return getAncestor(ttype)!=null; }

   /** Walk upwards and get first ancestor with this token type. */
   public Tree_FIX getAncestor(int ttype) {
       Tree_FIX t = this;
       t = t.getParent();
       while ( t!=null ) {
           if ( t.getType()==ttype ) return t;
           t = t.getParent();
       }
       return null;
   }

   /** Return a list of all ancestors of this node.  The first node of
    *  list is the root and the last is the parent of this node.
    */
   public List getAncestors() {
       if ( getParent()==null ) return null;
       List ancestors = new ArrayList();
       Tree_FIX t = this;
       t = t.getParent();
       while ( t!=null ) {
           ancestors.add(0, t); // insert at start
           t = t.getParent();
       }
       return ancestors;
   }

   /** Print out a whole tree not just a node */
   public String toStringTree() {
		if ( children==null || children.size()==0 ) {
			return this.toString();
		}
		StringBuffer buf = new StringBuffer();
		if ( !isNil() ) {
			buf.append("(");
			buf.append(this.toString());
			buf.append(' ');
		}
		for (int i = 0; children!=null && i < children.size(); i++) {
			Tree_FIX t = (Tree_FIX)children.get(i);
			if ( i>0 ) {
				buf.append(' ');
			}
			buf.append(t.toStringTree());
		}
		if ( !isNil() ) {
			buf.append(")");
		}
		return buf.toString();
	}

   public int getLine() {
		return 0;
	}

	public int getCharPositionInLine() {
		return 0;
	}

	/** Override to say how a node (not a tree) should look as text */
	public abstract String toString();
}

