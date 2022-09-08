package fixerror.antlr.tree;

import fixerror.antlr.Token_FIX;

/** A tree node that is wrapper for a Token object.  After 3.0 release
*  while building tree rewrite stuff, it became clear that computing
*  parent and child index is very difficult and cumbersome.  Better to
*  spend the space in every tree node.  If you don't want these extra
*  fields, it's easy to cut them out in your own BaseTree subclass.
*/
public class CommonTree_FIX extends BaseTree_FIX {
	/** A single token is the payload */
	public Token_FIX token;

	/** What token indexes bracket all tokens associated with this node
	 *  and below?
	 */
	protected int startIndex=-1, stopIndex=-1;

	/** Who is the parent node of this node; if null, implies node is root */
	public CommonTree_FIX parent;

	/** What index is this node in the child list? Range: 0..n-1 */
	public int childIndex = -1;

	public CommonTree_FIX() { }
	
	public CommonTree_FIX(CommonTree_FIX node) {
		super(node);
		this.token = node.token;
		this.startIndex = node.startIndex;
		this.stopIndex = node.stopIndex;
	}

	public CommonTree_FIX(Token_FIX t) {
		this.token = t;
	}

	public Token_FIX getToken() {
		return token;
	}

	public Tree_FIX dupNode() {
		return new CommonTree_FIX(this);
	}

	public boolean isNil() {
		return token==null;
	}

	public int getType() {
		if ( token==null ) {
			return Token_FIX.INVALID_TOKEN_TYPE;
		}
		return token.getType();
	}

	public String getText() {
		if ( token==null ) {
			return null;
		}
		return token.getText();
	}

	public int getLine() {
		if ( token==null || token.getLine()==0 ) {
			if ( getChildCount()>0 ) {
				return getChild(0).getLine();
			}
			return 0;
		}
		return token.getLine();
	}

	public int getCharPositionInLine() {
		if ( token==null || token.getCharPositionInLine()==-1 ) {
			if ( getChildCount()>0 ) {
				return getChild(0).getCharPositionInLine();
			}
			return 0;
		}
		return token.getCharPositionInLine();
	}

	public int getTokenStartIndex() {
		if ( startIndex==-1 && token!=null ) {
			return token.getTokenIndex();
		}
		return startIndex;
	}

	public void setTokenStartIndex(int index) {
		startIndex = index;
	}

	public int getTokenStopIndex() {
		if ( stopIndex==-1 && token!=null ) {
			return token.getTokenIndex();
		}
		return stopIndex;
	}

	public void setTokenStopIndex(int index) {
		stopIndex = index;
	}

   /** For every node in this subtree, make sure it's start/stop token's
    *  are set.  Walk depth first, visit bottom up.  Only updates nodes
    *  with at least one token index < 0.
    */
   public void setUnknownTokenBoundaries() {
       if ( children==null ) {
           if ( startIndex<0 || stopIndex<0 ) {
               startIndex = stopIndex = token.getTokenIndex();
           }
           return;
       }
       for (int i=0; i<children.size(); i++) {
           ((CommonTree_FIX)children.get(i)).setUnknownTokenBoundaries();
       }
       if ( startIndex>=0 && stopIndex>=0 ) return; // already set
       if ( children.size() > 0 ) {
           CommonTree_FIX firstChild = (CommonTree_FIX)children.get(0);
           CommonTree_FIX lastChild = (CommonTree_FIX)children.get(children.size()-1);
           startIndex = firstChild.getTokenStartIndex();
           stopIndex = lastChild.getTokenStopIndex();
       }
   }

	public int getChildIndex() {
		return childIndex;
	}

	public Tree_FIX getParent() {
		return parent;
	}

	public void setParent(Tree_FIX t) {
		this.parent = (CommonTree_FIX)t;
	}

	public void setChildIndex(int index) {
		this.childIndex = index;
	}

	public String toString() {
		if ( isNil() ) {
			return "nil";
		}
		if ( getType()==Token_FIX.INVALID_TOKEN_TYPE ) {
			return "<errornode>";
		}
		if ( token==null ) {
			return null;
		}
		return token.getText();
	}
}

