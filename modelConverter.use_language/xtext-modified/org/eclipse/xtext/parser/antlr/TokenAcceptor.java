package org.eclipse.xtext.parser.antlr;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import fixerror.antlr.Token_FIX;

/**
 * Simple implementation of an ITokenAcceptor based on the assumption 
 * that the calls to accept and next will be alternating with only a few
 * exceptions.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TokenAcceptor implements ITokenAcceptor, Iterator<Token_FIX> {

	private Queue<Token_FIX> queue = new LinkedList<Token_FIX>();
	
	@Override
	public void accept(Token_FIX token) {
		queue.offer(token);
	}
	
	@Override
	public boolean hasNext() {
		return queue.peek() != null;
	}
	
	@Override
	public Token_FIX next() {
		return queue.remove();
	}
	
	// array based implementation:
	// passes the tests and is nearly 2 times faster then the 
	// queue based implementation. However it introduces a lot 
	// more complexity. In case the token acceptor is to slow
	// the more complex impl could be activated.
	
//	private Token_FIX[] tokens = new Token_FIX[2];
//	private int insertHere = 0;
//	private int next = 0;
//	
//	public void accept(Token_FIX token) {
//		tokens[insertHere] = token;
//		if (insertHere == tokens.length - 1) 
//			insertHere = 0;
//		else
//			insertHere++;
//		if (insertHere == next) {
//			Token_FIX[] oldTokens = tokens;
//			tokens = new Token_FIX[oldTokens.length * 2];
//			System.arraycopy(oldTokens, next, tokens, next + oldTokens.length, oldTokens.length - next);
//			if (next != 0) {
//				System.arraycopy(oldTokens, 0, tokens, 0, next);
//			}
//			next = next + oldTokens.length;
//		}
//	}
//
//	public boolean hasNext() {
//		return insertHere != next;
//	}
//
//	public Token_FIX next() {
//		if (!hasNext())
//			throw new NoSuchElementException("call hasNext before next");
//		Token_FIX result = tokens[next];
//		if (next == tokens.length - 1) 
//			next = 0;
//		else
//			next++;
//		return result;
//	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}