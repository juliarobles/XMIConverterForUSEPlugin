/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.LetExpCS#getOwnedVariables <em>Owned Variables</em>}</li>
 *   <li>{@link modelConverter.use_language.use.LetExpCS#getOwnedInExpression <em>Owned In Expression</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getLetExpCS()
 * @model
 * @generated
 */
public interface LetExpCS extends ExpCS
{
  /**
   * Returns the value of the '<em><b>Owned Variables</b></em>' containment reference list.
   * The list contents are of type {@link modelConverter.use_language.use.LetVariableCS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Variables</em>' containment reference list.
   * @see modelConverter.use_language.use.UsePackage#getLetExpCS_OwnedVariables()
   * @model containment="true"
   * @generated
   */
  EList<LetVariableCS> getOwnedVariables();

  /**
   * Returns the value of the '<em><b>Owned In Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned In Expression</em>' containment reference.
   * @see #setOwnedInExpression(ExpCS)
   * @see modelConverter.use_language.use.UsePackage#getLetExpCS_OwnedInExpression()
   * @model containment="true"
   * @generated
   */
  ExpCS getOwnedInExpression();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.LetExpCS#getOwnedInExpression <em>Owned In Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned In Expression</em>' containment reference.
   * @see #getOwnedInExpression()
   * @generated
   */
  void setOwnedInExpression(ExpCS value);

} // LetExpCS