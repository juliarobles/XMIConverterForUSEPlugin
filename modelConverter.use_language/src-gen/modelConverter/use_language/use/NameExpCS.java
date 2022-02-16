/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.NameExpCS#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link modelConverter.use_language.use.NameExpCS#getOwnedSquareBracketedClauses <em>Owned Square Bracketed Clauses</em>}</li>
 *   <li>{@link modelConverter.use_language.use.NameExpCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}</li>
 *   <li>{@link modelConverter.use_language.use.NameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}</li>
 *   <li>{@link modelConverter.use_language.use.NameExpCS#isIsPre <em>Is Pre</em>}</li>
 *   <li>{@link modelConverter.use_language.use.NameExpCS#isPre <em>Pre</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getNameExpCS()
 * @model
 * @generated
 */
public interface NameExpCS extends ExpCS
{
  /**
   * Returns the value of the '<em><b>Owned Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Path Name</em>' containment reference.
   * @see #setOwnedPathName(PathNameCS)
   * @see modelConverter.use_language.use.UsePackage#getNameExpCS_OwnedPathName()
   * @model containment="true"
   * @generated
   */
  PathNameCS getOwnedPathName();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.NameExpCS#getOwnedPathName <em>Owned Path Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Path Name</em>' containment reference.
   * @see #getOwnedPathName()
   * @generated
   */
  void setOwnedPathName(PathNameCS value);

  /**
   * Returns the value of the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
   * The list contents are of type {@link modelConverter.use_language.use.SquareBracketedClauseCS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Square Bracketed Clauses</em>' containment reference list.
   * @see modelConverter.use_language.use.UsePackage#getNameExpCS_OwnedSquareBracketedClauses()
   * @model containment="true"
   * @generated
   */
  EList<SquareBracketedClauseCS> getOwnedSquareBracketedClauses();

  /**
   * Returns the value of the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Round Bracketed Clause</em>' containment reference.
   * @see #setOwnedRoundBracketedClause(RoundBracketedClauseCS)
   * @see modelConverter.use_language.use.UsePackage#getNameExpCS_OwnedRoundBracketedClause()
   * @model containment="true"
   * @generated
   */
  RoundBracketedClauseCS getOwnedRoundBracketedClause();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.NameExpCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Round Bracketed Clause</em>' containment reference.
   * @see #getOwnedRoundBracketedClause()
   * @generated
   */
  void setOwnedRoundBracketedClause(RoundBracketedClauseCS value);

  /**
   * Returns the value of the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Curly Bracketed Clause</em>' containment reference.
   * @see #setOwnedCurlyBracketedClause(CurlyBracketedClauseCS)
   * @see modelConverter.use_language.use.UsePackage#getNameExpCS_OwnedCurlyBracketedClause()
   * @model containment="true"
   * @generated
   */
  CurlyBracketedClauseCS getOwnedCurlyBracketedClause();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.NameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Curly Bracketed Clause</em>' containment reference.
   * @see #getOwnedCurlyBracketedClause()
   * @generated
   */
  void setOwnedCurlyBracketedClause(CurlyBracketedClauseCS value);

  /**
   * Returns the value of the '<em><b>Is Pre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Pre</em>' attribute.
   * @see #setIsPre(boolean)
   * @see modelConverter.use_language.use.UsePackage#getNameExpCS_IsPre()
   * @model
   * @generated
   */
  boolean isIsPre();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.NameExpCS#isIsPre <em>Is Pre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Pre</em>' attribute.
   * @see #isIsPre()
   * @generated
   */
  void setIsPre(boolean value);

  /**
   * Returns the value of the '<em><b>Pre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pre</em>' attribute.
   * @see #setPre(boolean)
   * @see modelConverter.use_language.use.UsePackage#getNameExpCS_Pre()
   * @model
   * @generated
   */
  boolean isPre();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.NameExpCS#isPre <em>Pre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pre</em>' attribute.
   * @see #isPre()
   * @generated
   */
  void setPre(boolean value);

} // NameExpCS
