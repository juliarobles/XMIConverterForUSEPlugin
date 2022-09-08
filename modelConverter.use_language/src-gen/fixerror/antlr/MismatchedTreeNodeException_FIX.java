package fixerror.antlr;

import fixerror.antlr.tree.TreeNodeStream_FIX;

/**
*/
public class MismatchedTreeNodeException_FIX extends RecognitionException_FIX {
	public int expecting;

	public MismatchedTreeNodeException_FIX() {
	}

	public MismatchedTreeNodeException_FIX(int expecting, TreeNodeStream_FIX input) {
		super(input);
		this.expecting = expecting;
	}

	public String toString() {
		return "MismatchedTreeNodeException("+getUnexpectedType()+"!="+expecting+")";
	}
}

