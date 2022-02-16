/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.State#getName <em>Name</em>}</li>
 *   <li>{@link modelConverter.use_language.use.State#isIsInitial <em>Is Initial</em>}</li>
 *   <li>{@link modelConverter.use_language.use.State#isIsFinal <em>Is Final</em>}</li>
 *   <li>{@link modelConverter.use_language.use.State#getInvariant <em>Invariant</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see modelConverter.use_language.use.UsePackage#getState_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.State#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Is Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Initial</em>' attribute.
   * @see #setIsInitial(boolean)
   * @see modelConverter.use_language.use.UsePackage#getState_IsInitial()
   * @model
   * @generated
   */
  boolean isIsInitial();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.State#isIsInitial <em>Is Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Initial</em>' attribute.
   * @see #isIsInitial()
   * @generated
   */
  void setIsInitial(boolean value);

  /**
   * Returns the value of the '<em><b>Is Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Final</em>' attribute.
   * @see #setIsFinal(boolean)
   * @see modelConverter.use_language.use.UsePackage#getState_IsFinal()
   * @model
   * @generated
   */
  boolean isIsFinal();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.State#isIsFinal <em>Is Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Final</em>' attribute.
   * @see #isIsFinal()
   * @generated
   */
  void setIsFinal(boolean value);

  /**
   * Returns the value of the '<em><b>Invariant</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invariant</em>' containment reference.
   * @see #setInvariant(ExpCS)
   * @see modelConverter.use_language.use.UsePackage#getState_Invariant()
   * @model containment="true"
   * @generated
   */
  ExpCS getInvariant();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.State#getInvariant <em>Invariant</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invariant</em>' containment reference.
   * @see #getInvariant()
   * @generated
   */
  void setInvariant(ExpCS value);

} // State