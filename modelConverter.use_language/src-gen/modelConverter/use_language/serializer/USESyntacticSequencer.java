/*
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.serializer;

import com.google.inject.Inject;
import java.util.List;
import modelConverter.use_language.services.USEGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class USESyntacticSequencer extends AbstractSyntacticSequencer {

	protected USEGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Attribute_DeriveKeyword_4_0_0_or_DerivedKeyword_4_0_1;
	protected AbstractElementAlias match_Generalization_CommaKeyword_1_q;
	protected AbstractElementAlias match_OperationComplex___BeginKeyword_1_0_EndKeyword_1_2__q;
	protected AbstractElementAlias match_OperationQuery_SemicolonKeyword_3_q;
	protected AbstractElementAlias match_Parameter_CommaKeyword_3_q;
	protected AbstractElementAlias match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (USEGrammarAccess) access;
		match_Attribute_DeriveKeyword_4_0_0_or_DerivedKeyword_4_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAttributeAccess().getDeriveKeyword_4_0_0()), new TokenAlias(false, false, grammarAccess.getAttributeAccess().getDerivedKeyword_4_0_1()));
		match_Generalization_CommaKeyword_1_q = new TokenAlias(false, true, grammarAccess.getGeneralizationAccess().getCommaKeyword_1());
		match_OperationComplex___BeginKeyword_1_0_EndKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getOperationComplexAccess().getBeginKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getOperationComplexAccess().getEndKeyword_1_2()));
		match_OperationQuery_SemicolonKeyword_3_q = new TokenAlias(false, true, grammarAccess.getOperationQueryAccess().getSemicolonKeyword_3());
		match_Parameter_CommaKeyword_3_q = new TokenAlias(false, true, grammarAccess.getParameterAccess().getCommaKeyword_3());
		match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Attribute_DeriveKeyword_4_0_0_or_DerivedKeyword_4_0_1.equals(syntax))
				emit_Attribute_DeriveKeyword_4_0_0_or_DerivedKeyword_4_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Generalization_CommaKeyword_1_q.equals(syntax))
				emit_Generalization_CommaKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_OperationComplex___BeginKeyword_1_0_EndKeyword_1_2__q.equals(syntax))
				emit_OperationComplex___BeginKeyword_1_0_EndKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_OperationQuery_SemicolonKeyword_3_q.equals(syntax))
				emit_OperationQuery_SemicolonKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Parameter_CommaKeyword_3_q.equals(syntax))
				emit_Parameter_CommaKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'derive' | 'derived'
	 *
	 * This ambiguous syntax occurs at:
	 *     initOCL=ExpCS (ambiguity) ':' deriveOCL=ExpCS
	 *     type=AllTypes (ambiguity) ':' deriveOCL=ExpCS
	 */
	protected void emit_Attribute_DeriveKeyword_4_0_0_or_DerivedKeyword_4_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     general=[AllClass|ID] (ambiguity) (rule end)
	 */
	protected void emit_Generalization_CommaKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('begin' 'end')?
	 *
	 * This ambiguous syntax occurs at:
	 *     operationDeclaration=OperationDeclaration (ambiguity) (rule end)
	 *     operationDeclaration=OperationDeclaration (ambiguity) conditions+=ConditionType
	 */
	protected void emit_OperationComplex___BeginKeyword_1_0_EndKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     operationbody=ExpCS (ambiguity) (rule end)
	 *     operationbody=ExpCS (ambiguity) conditions+=ConditionType
	 */
	protected void emit_OperationQuery_SemicolonKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     type=AllTypes (ambiguity) (rule end)
	 */
	protected void emit_Parameter_CommaKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name='Tuple' (ambiguity) (rule end)
	 *     name='Tuple' (ambiguity) ownedMultiplicity=MultiplicityCS
	 */
	protected void emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
