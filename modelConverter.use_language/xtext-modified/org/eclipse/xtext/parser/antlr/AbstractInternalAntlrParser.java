/*******************************************************************************
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fixerror.antlr.BitSet_FIX;
import fixerror.antlr.CommonToken_FIX;
import fixerror.antlr.DFA_FIX;
import fixerror.antlr.FailedPredicateException_FIX;
import fixerror.antlr.IntStream_FIX;
import fixerror.antlr.MismatchedTokenException_FIX;
import fixerror.antlr.MissingTokenException_FIX;
import fixerror.antlr.Parser_FIX;
import fixerror.antlr.RecognitionException_FIX;
import fixerror.antlr.RecognizerSharedState_FIX;
import fixerror.antlr.Token_FIX;
import fixerror.antlr.TokenStream_FIX;
import fixerror.antlr.UnwantedTokenException_FIX;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider.IParserErrorContext;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider.IUnorderedGroupErrorContext;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider.IValueConverterErrorContext;
import org.eclipse.xtext.service.AllRulesCache;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Base class for Xtext's generated parsers. It is reasonable customizable by means of 
 * object composition, e.g. error messages can be tailored to specific needs with an
 * {@link ISyntaxErrorMessageProvider}, objects construction is subject to an {@link IAstFactory}.
 */
public abstract class AbstractInternalAntlrParser extends Parser_FIX {

	protected class ErrorContext {
		public EObject getCurrentContext() {
			if (currentNode != null)
				return currentNode.getSemanticElement();
			return null;
		}
		
		public INode getCurrentNode() {
			return currentNode;
		}	
	}
	
	protected class ParserErrorContext extends ErrorContext implements IParserErrorContext {

		private final RecognitionException_FIX recognitionException;

		protected ParserErrorContext(RecognitionException_FIX recognitionException) {
			this.recognitionException = recognitionException;
		}
		
		@Override
		public String getDefaultMessage() {
			return superGetErrorMessage(getRecognitionException(), getTokenNames());
		}

		@Override
		public RecognitionException_FIX getRecognitionException() {
			return recognitionException;
		}

		@Override
		public String[] getTokenNames() {
			return readableTokenNames;
		}
	}
	
	protected class LexerErrorContext extends ErrorContext implements IParserErrorContext {

		private String message;

		public LexerErrorContext(String message) {
			this.message = message;
		}
		
		@Override
		public String getDefaultMessage() {
			return message;
		}

		@Override
		public RecognitionException_FIX getRecognitionException() {
			return null;
		}

		@Override
		public String[] getTokenNames() {
			return readableTokenNames;
		}
		
	}
	
	private static final Class<?>[] emptyClassArray = new Class[0];
	private static final Object[] emptyObjectArray = new Object[0];
	
	protected class UnorderedGroupErrorContext extends ParserErrorContext implements IUnorderedGroupErrorContext {
		
		private List<AbstractElement> missingMandatoryElements;
		
		protected UnorderedGroupErrorContext(FailedPredicateException_FIX exception) {
			super(exception);
		}
		
		@Override
		public FailedPredicateException_FIX getRecognitionException() {
			return (FailedPredicateException_FIX) super.getRecognitionException();
		}
		
		@Override
		public List<AbstractElement> getMissingMandatoryElements() {
			List<AbstractElement> result = missingMandatoryElements;
			if (result == null) {
				String predicate = getRecognitionException().toString();
				int idx = predicate.indexOf("grammarAccess");
				int lastIdx = predicate.lastIndexOf('(');
				predicate = predicate.substring(idx + "grammarAccess.".length(), lastIdx);
				String ruleMethodGetter = predicate.substring(0, predicate.indexOf('('));
				String elementGetter = predicate.substring(predicate.indexOf('.') + 1);
				IGrammarAccess grammarAccess = getGrammarAccess();
				Object ruleAccess = invokeNoArgMethod(ruleMethodGetter, grammarAccess);
				UnorderedGroup group = (UnorderedGroup) invokeNoArgMethod(elementGetter, ruleAccess);
				List<AbstractElement> missingElements = Lists.newArrayList();
				for(int i = 0; i < group.getElements().size(); i++) {
					AbstractElement element = group.getElements().get(i);
					if (!GrammarUtil.isOptionalCardinality(element) && unorderedGroupHelper.canSelect(group, i)) {
						missingElements.add(element);
					}
				}
				result = ImmutableList.copyOf(missingElements);
				missingMandatoryElements = result;
			}
			return result;
		}
		
		private Object invokeNoArgMethod(String name, Object target) {
			try {
				Method method = target.getClass().getMethod(name, emptyClassArray);
				return method.invoke(target, emptyObjectArray);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	protected class ValueConverterErrorContext extends ErrorContext implements IValueConverterErrorContext {

		private final ValueConverterException valueConverterException;

		protected ValueConverterErrorContext(ValueConverterException valueConverterException) {
			this.valueConverterException = valueConverterException;
		}

		@Override
		public String getDefaultMessage() {
			return getValueConverterExceptionMessage(getValueConverterException());
		}

		@Override
		public ValueConverterException getValueConverterException() {
			return valueConverterException;
		}

	}
	
	private static final Logger logger = Logger.getLogger(AbstractInternalAntlrParser.class);
	
	private ICompositeNode currentNode;

	private INode lastConsumedNode;
	
	private boolean hadErrors;
	
	private IAstFactory semanticModelBuilder;
	
	private int lastConsumedIndex = -1;

	private Map<String, AbstractRule> allRules;
	
	private ISyntaxErrorMessageProvider syntaxErrorProvider;
	
	private IUnorderedGroupHelper unorderedGroupHelper;
	
	private NodeModelBuilder nodeBuilder = new NodeModelBuilder();
	
	protected AbstractInternalAntlrParser(TokenStream_FIX input) {
		super(input);
	}
	
	protected AbstractInternalAntlrParser(TokenStream_FIX input, RecognizerSharedState_FIX state) {
		super(input, state);
	}

	protected void registerRules(Grammar grammar) {
		allRules = createAllRules(grammar);
	}
	
	/**
	 * @since 2.11
	 */
	protected Map<String, AbstractRule> createAllRules(Grammar grammar) {
		AllRulesCache cache = AllRulesCache.findInEmfObject(grammar);
		if (cache != null) {
			return cache.getAllRules();
		}
		Map<String, AbstractRule> allRules = Maps.newHashMap();
		for (AbstractRule rule: GrammarUtil.allRules(grammar)) {
			if(rule instanceof TerminalRule)
				allRules.put(rule.getName().toUpperCase(), rule);
			else
				allRules.put(rule.getName(), rule);
		}
		return allRules;
	}

	public TokenStream_FIX getInput() {
		return input;
	}

	/**
	 * @since 2.10
	 */
	protected ICompositeNode getCurrentNode() {
		return currentNode;
	}

	protected abstract IGrammarAccess getGrammarAccess();
	
	protected void associateNodeWithAstElement(ICompositeNode node, EObject astElement) {
		if (astElement == null)
			throw new NullPointerException("passed astElement was null");
		if (node == null)
			throw new NullPointerException("passed node was null");
		nodeBuilder.associateWithSemanticElement(node, astElement);
	}

	private ILeafNode createLeafNode(Token_FIX token, EObject grammarElement) {
		boolean isHidden = token.getChannel() == HIDDEN;
		SyntaxErrorMessage error = null;
		if (!isHidden) {
			if (currentError != null) {
				error = currentError;
				currentError = null;
			}
		}
		if (token.getType() == Token_FIX.INVALID_TOKEN_TYPE) {
			if (error == null) {
				String lexerErrorMessage = ((XtextTokenStream) input).getLexerErrorMessage(token);
				LexerErrorContext errorContext = new LexerErrorContext(lexerErrorMessage);
				error = syntaxErrorProvider.getSyntaxErrorMessage(errorContext);
			}
		}
		if (grammarElement == null) {
			String ruleName = antlrTypeToLexerName.get(token.getType());
			grammarElement = allRules.get(ruleName);
		}
		CommonToken_FIX commonToken = (CommonToken_FIX) token;
		if (error != null)
			hadErrors = true;
		return nodeBuilder.newLeafNode(
				commonToken.getStartIndex(), 
				commonToken.getStopIndex() - commonToken.getStartIndex() + 1, 
				grammarElement, 
				isHidden, 
				error, 
				currentNode);
	}
	
	private Map<Integer, String> antlrTypeToLexerName = null;
	
	private String[] readableTokenNames = null;

	public void setTokenTypeMap(Map<Integer, String> tokenTypeMap) {
		antlrTypeToLexerName = Maps.newHashMap();
		for(Entry<Integer, String> mapEntry: tokenTypeMap.entrySet()) {
			String value = mapEntry.getValue();
			if(TokenTool.isLexerRule(value)) {
				antlrTypeToLexerName.put(mapEntry.getKey(), TokenTool.getLexerRuleName(value));
			}
		}
		String[] tokenNames = getTokenNames();
		readableTokenNames = new String[tokenNames.length];
		for(int i = 0; i < tokenNames.length; i++) {
			if (tokenTypeMap.containsKey(i)) {
				readableTokenNames[i] = tokenTypeMap.get(i);
			} else {
				readableTokenNames[i] = tokenNames[i];
			}
		}
	}
	
	public void setSyntaxErrorProvider(ISyntaxErrorMessageProvider syntaxErrorProvider) {
		this.syntaxErrorProvider = syntaxErrorProvider;
	}
	
	public ISyntaxErrorMessageProvider getSyntaxErrorProvider() {
		return syntaxErrorProvider;
	}

	protected void set(EObject _this, String feature, Object value, String lexerRule, INode node) {
		try {
			semanticModelBuilder.set(_this, feature, value, lexerRule, node);
		} catch(ValueConverterException vce) {
			handleValueConverterException(vce);
		}
	}
	
	protected void set(EObject _this, String feature, Object value, String lexerRule) {
		set(_this, feature, value, lexerRule, currentNode);
	}
	
	protected void setWithLastConsumed(EObject _this, String feature, Object value, String lexerRule) {
		set(_this, feature, value, lexerRule, lastConsumedNode);
	}

	protected void add(EObject _this, String feature, Object value, String lexerRule, INode node) {
		try {
			semanticModelBuilder.add(_this, feature, value, lexerRule, node);
		} catch(ValueConverterException vce) {
			handleValueConverterException(vce);
		}
	}
	
	protected void add(EObject _this, String feature, Object value, String lexerRule) {
		add(_this, feature, value, lexerRule, currentNode);
	}
	
	protected void addWithLastConsumed(EObject _this, String feature, Object value, String lexerRule) {
		add(_this, feature, value, lexerRule, lastConsumedNode);
	}
	
	protected void appendError(INode node) {
		if (currentError != null) {
			if (node.getSyntaxErrorMessage() == null) {
				INode newNode = nodeBuilder.setSyntaxError(node, currentError);
				if (node == currentNode) {
					currentNode = (ICompositeNode) newNode;
				}
				currentError = null;
			}
		}
	}

	protected void appendAllTokens() {
		for (int x = lastConsumedIndex + 1; input.size() > x; input.consume(), x++) {
			Token_FIX hidden = input.get(x);
			createLeafNode(hidden, null);
			lastConsumedIndex = hidden.getTokenIndex();
		}
		if (currentError != null) {
			appendError(getLastLeafNode());
		}
	}
	
	protected INode getLastLeafNode() {
		BidiTreeIterator<INode> iter = currentNode.getAsTreeIterable().iterator();
		while(iter.hasPrevious()) {
			INode previous = iter.previous();
			if (previous instanceof ILeafNode)
				return previous;
		}
		return currentNode;
	}
	
	protected List<ILeafNode> appendSkippedTokens() {
		List<ILeafNode> skipped = new ArrayList<ILeafNode>();
		Token_FIX currentToken = input.LT(-1);
		int currentTokenIndex = (currentToken == null) ? -1 : currentToken.getTokenIndex();
		Token_FIX tokenBefore = (lastConsumedIndex == -1) ? null : input.get(lastConsumedIndex);
		int indexOfTokenBefore = tokenBefore != null ? tokenBefore.getTokenIndex() : -1;
		if (indexOfTokenBefore + 1 < currentTokenIndex) {
			for (int x = indexOfTokenBefore + 1; x < currentTokenIndex; x++) {
				Token_FIX hidden = input.get(x);
				ILeafNode leaf = createLeafNode(hidden, null);
				skipped.add(leaf);
				lastConsumedIndex = x;
			}
		}
		if (lastConsumedIndex < currentTokenIndex && currentToken != null) {
			ILeafNode leaf = createLeafNode(currentToken, null);
			skipped.add(leaf);
			lastConsumedIndex = currentToken.getTokenIndex();
		}
		return skipped;
	}

	protected void appendTrailingHiddenTokens() {
		Token_FIX tokenBefore = input.LT(-1);
		int size = input.size();
		if (tokenBefore != null && tokenBefore.getTokenIndex() < size) {
			for (int x = tokenBefore.getTokenIndex() + 1; x < size; x++) {
				Token_FIX hidden = input.get(x);
				createLeafNode(hidden, null);
				lastConsumedIndex = hidden.getTokenIndex();
			}
		}
	}
	
	private SyntaxErrorMessage currentError = null;

	@Override
	public void recover(IntStream_FIX input, RecognitionException_FIX re) {
		if (currentError == null)
			currentError = getSyntaxErrorMessage(re, getTokenNames());
		super.recover(input, re);
	}
	
	protected String getValueConverterExceptionMessage(ValueConverterException vce) {
		Exception cause = (Exception) vce.getCause();
		String result = cause != null ? cause.getMessage() : vce.getMessage();
		if (result == null)
			result = vce.getMessage();
		if (result == null)
			result = cause != null ? cause.getClass().getSimpleName() : vce.getClass().getSimpleName();
		return result;
	}
	
	protected void handleValueConverterException(ValueConverterException vce) {
		hadErrors = true;
		Exception cause = (Exception) vce.getCause();
		if (vce != cause) {
			IValueConverterErrorContext errorContext = createValueConverterErrorContext(vce);
			currentError = syntaxErrorProvider.getSyntaxErrorMessage(errorContext);
			if (vce.getNode() == null) {
				appendError(currentNode.getLastChild());
			} else {
				appendError(vce.getNode());
			}
		} else {
			throw new RuntimeException(vce);
		}
	}

	protected IValueConverterErrorContext createValueConverterErrorContext(ValueConverterException vce) {
		return new ValueConverterErrorContext(vce);
	}

	@Override
	public String getErrorMessage(RecognitionException_FIX e, String[] tokenNames) {
		throw new UnsupportedOperationException("getErrorMessage");
	}
	
	@Override
	public void displayRecognitionError(String[] tokenNames, RecognitionException_FIX e) {
		throw new UnsupportedOperationException("displayRecognitionError");
	}
	
	@Override
	public void reportError(RecognitionException_FIX e) {
		if ( state.errorRecovery ) {
			return;
		}
		state.syntaxErrors++; // don't count spurious
		state.errorRecovery = true;
		if (currentError == null)
			currentError = getSyntaxErrorMessage(e, getTokenNames());
	}

	@Override
	protected Object recoverFromMismatchedToken(IntStream_FIX input, int ttype, BitSet_FIX follow) throws RecognitionException_FIX {
		RecognitionException_FIX e = null;
		// if next token is what we are looking for then "delete" this token
		if ( mismatchIsUnwantedToken(input, ttype) ) {
			e = new UnwantedTokenException_FIX(ttype, input);
			/*
			System.err.println("recoverFromMismatchedToken deleting "+
							   ((TokenStream_FIX)input).LT(1)+
							   " since "+((TokenStream_FIX)input).LT(2)+" is what we want");
			 */
			beginResync();
			input.consume(); // simply delete extra token
			endResync();
			reportError(e);  // report after consuming so AW sees the token in the exception
			// we want to return the token we're actually matching
			Object matchedSymbol = getCurrentInputSymbol(input);
			input.consume(); // move past ttype token as if all were ok
			return matchedSymbol;
		}
		// can't recover with single token deletion, try insertion
		if ( mismatchIsMissingToken(input, follow) ) {
			Object inserted = getMissingSymbol(input, e, ttype, follow);
			e = new MissingTokenException_FIX(ttype, input, inserted);
			reportError(e);  // report after inserting so AW sees the token in the exception
			return null;
			// throw e;
		}
		// even that didn't work; must throw the exception
		e = new MismatchedTokenException_FIX(ttype, input);
		throw e;
	}
	
	public SyntaxErrorMessage getSyntaxErrorMessage(RecognitionException_FIX e, String[] tokenNames) {
		hadErrors = true;
		IParserErrorContext parseErrorContext = createErrorContext(e);
		return syntaxErrorProvider.getSyntaxErrorMessage(parseErrorContext);
	}
	
	protected String superGetErrorMessage(RecognitionException_FIX e, String[] tokenNames) {
		return super.getErrorMessage(e, tokenNames);
	}
	
	protected IParserErrorContext createErrorContext(RecognitionException_FIX e) {
		if (e instanceof FailedPredicateException_FIX)
			return new UnorderedGroupErrorContext((FailedPredicateException_FIX) e);
		return new ParserErrorContext(e);
	}

	public final IParseResult parse() throws RecognitionException_FIX {
		return parse(getFirstRuleName());
	}

	public final IParseResult parse(String entryRuleName) throws RecognitionException_FIX {
		long time = System.currentTimeMillis();
		IParseResult result = null;
		EObject current = null;
		String completeContent = input.toString();
		if (completeContent == null) // who had the crazy idea to return null from toString() ...
			completeContent = "";
		currentNode = nodeBuilder.newRootNode(completeContent);
		String antlrEntryRuleName = normalizeEntryRuleName(entryRuleName);
		try {
			Method method = this.getClass().getMethod(antlrEntryRuleName);
			method.setAccessible(true);
			Object parseResult = method.invoke(this);
			if (parseResult instanceof EObject)
				current = (EObject) parseResult;
			appendSkippedTokens();
			appendTrailingHiddenTokens();
			try {
				appendAllTokens();
			} finally {
				ICompositeNode root = nodeBuilder.compressAndReturnParent(currentNode);
				result = new ParseResult(current, root, hadErrors);
			}
		} catch (InvocationTargetException ite) {
			Throwable targetException = ite.getTargetException();
			if (targetException instanceof RecognitionException_FIX) {
				try {
					appendAllTokens();
				} finally {
					ICompositeNode root = nodeBuilder.compressAndReturnParent(currentNode);
					result = new ParseResult(current, root, hadErrors);
				}
				throw (RecognitionException_FIX) targetException;
			}
			if (targetException instanceof Exception) {
				throw new WrappedException((Exception) targetException);
			}
			throw new RuntimeException(targetException);
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("Parsing took: " + (System.currentTimeMillis() - time) + " ms");
			}
		}
		return result;
	}

	private String normalizeEntryRuleName(String entryRuleName) {
		String antlrEntryRuleName;
		if (!entryRuleName.startsWith("entryRule") && !entryRuleName.startsWith("entryNorm")) {
			if (!entryRuleName.startsWith("rule")) {
				antlrEntryRuleName = "entryRule" + entryRuleName;
			} else {
				antlrEntryRuleName = "entry" + Strings.toFirstUpper(entryRuleName);
			}
		} else {
			antlrEntryRuleName = entryRuleName;
		}
		return antlrEntryRuleName;
	}

	@Override
	public void emitErrorMessage(String msg) {
		// don't call super, since it would do a plain vanilla
		// System.err.println(msg);
		if (logger.isTraceEnabled())
			logger.trace(msg);
	}

	/**
	 * @return the name of the entry rule.
	 */
	protected abstract String getFirstRuleName();

	public void setUnorderedGroupHelper(IUnorderedGroupHelper unorderedGroupHelper) {
		this.unorderedGroupHelper = unorderedGroupHelper;
	}

	public IUnorderedGroupHelper getUnorderedGroupHelper() {
		return unorderedGroupHelper;
	}

	// externalized usage patterns from generated sources
	
	// currentNode = currentNode.getParent();
    protected void afterParserOrEnumRuleCall() {
	ICompositeNode newCurrent = nodeBuilder.compressAndReturnParent(currentNode);
	if(currentNode == lastConsumedNode){
		lastConsumedNode = newCurrent;
	}
		currentNode = newCurrent;
    }
	
    // if (current==null) {
    //========
	//    current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
	//    associateNodeWithAstElement(currentNode.getParent(), current);
    //========
	//}
    protected EObject createModelElementForParent(AbstractRule rule) {
    	return createModelElement(rule.getType().getClassifier(), currentNode.getParent());
    }

    protected EObject createModelElement(AbstractRule rule) {
    	return createModelElement(rule.getType().getClassifier(), currentNode);
    }
    
    protected EObject createModelElementForParent(EClassifier classifier) {
    	return createModelElement(classifier, currentNode.getParent());
    }

    protected EObject createModelElement(EClassifier classifier) {
    	return createModelElement(classifier, currentNode);
    }
    
    protected EObject createModelElement(EClassifier classifier, ICompositeNode compositeNode) {
    	EObject result = semanticModelBuilder.create(classifier);
    	associateNodeWithAstElement(compositeNode, result);
    	return result;
    }
    
    // Assigned action code
    protected EObject forceCreateModelElementAndSet(Action action, EObject value) {
    	EObject result = semanticModelBuilder.create(action.getType().getClassifier());
    	semanticModelBuilder.set(result, action.getFeature(), value, null /* ParserRule */, currentNode);
    	insertCompositeNode(action);
    	associateNodeWithAstElement(currentNode, result);
    	return result;
    }
    
    protected EObject forceCreateModelElementAndAdd(Action action, EObject value) {
    	EObject result = semanticModelBuilder.create(action.getType().getClassifier());
    	semanticModelBuilder.add(result, action.getFeature(), value, null /* ParserRule */, currentNode);
    	insertCompositeNode(action);
    	associateNodeWithAstElement(currentNode, result);
    	return result;
    }
    
    protected EObject forceCreateModelElement(Action action, EObject value) {
    	EObject result = semanticModelBuilder.create(action.getType().getClassifier());
    	insertCompositeNode(action);
    	associateNodeWithAstElement(currentNode, result);
    	return result;
    }

	protected void insertCompositeNode(Action action) {
    	ICompositeNode newCurrentNode = nodeBuilder.newCompositeNodeAsParentOf(action, currentNode.getLookAhead(), currentNode);
    	currentNode = newCurrentNode;
	}
	
	protected void enterRule() {
	}
	
	protected void leaveRule() {
    	lastConsumedNode = currentNode;
	}
    
	// currentNode = createCompositeNode()
	protected void newCompositeNode(EObject grammarElement) {
		XtextTokenStream input = (XtextTokenStream) this.input;
		int lookAhead = input.getCurrentLookAhead();
		currentNode = nodeBuilder.newCompositeNode(grammarElement, lookAhead, currentNode);
	}
	
	protected void newLeafNode(Token_FIX token, EObject grammarElement) {
		if (token == null)
			return;

		final int tokenIndex = token.getTokenIndex();
		if (tokenIndex > lastConsumedIndex) {
			for (int x = lastConsumedIndex + 1; x < tokenIndex; x++) {
				Token_FIX hidden = input.get(x);
				createLeafNode(hidden, null);
			}
			lastConsumedIndex = tokenIndex;
			lastConsumedNode = createLeafNode(token, grammarElement);
		}
	}

	public void setNodeModelBuilder(NodeModelBuilder nodeModelBuilder) {
		this.nodeBuilder = nodeModelBuilder;
	}

	public NodeModelBuilder getNodeModelBuilder() {
		return nodeBuilder;
	}
	
	public void setSemanticModelBuilder(IAstFactory semanticModelBuilder) {
		this.semanticModelBuilder = semanticModelBuilder;
	}
	
	public IAstFactory getSemanticModelBuilder() {
		return semanticModelBuilder;
	}
	
	/**
	 * @since 2.9
	 */
	protected static short[][] unpackEncodedStringArray(String[] arr) {
		int numStates = arr.length;
		short[][] result = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			result[i] = DFA_FIX.unpackEncodedString(arr[i]);
		}
		return result;
	}
}
