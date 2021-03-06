/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link modelConverter.use_language.use.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link modelConverter.use_language.use.Transition#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link modelConverter.use_language.use.Transition#getOperation <em>Operation</em>}</li>
 *   <li>{@link modelConverter.use_language.use.Transition#getPostcondition <em>Postcondition</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' attribute.
   * @see #setSource(String)
   * @see modelConverter.use_language.use.UsePackage#getTransition_Source()
   * @model
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Transition#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' attribute.
   * @see #setTarget(String)
   * @see modelConverter.use_language.use.UsePackage#getTransition_Target()
   * @model
   * @generated
   */
  String getTarget();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Transition#getTarget <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' attribute.
   * @see #getTarget()
   * @generated
   */
  void setTarget(String value);

  /**
   * Returns the value of the '<em><b>Precondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precondition</em>' containment reference.
   * @see #setPrecondition(ExpCS)
   * @see modelConverter.use_language.use.UsePackage#getTransition_Precondition()
   * @model containment="true"
   * @generated
   */
  ExpCS getPrecondition();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Transition#getPrecondition <em>Precondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Precondition</em>' containment reference.
   * @see #getPrecondition()
   * @generated
   */
  void setPrecondition(ExpCS value);

  /**
   * Returns the value of the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' reference.
   * @see #setOperation(OperationDeclaration)
   * @see modelConverter.use_language.use.UsePackage#getTransition_Operation()
   * @model
   * @generated
   */
  OperationDeclaration getOperation();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Transition#getOperation <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' reference.
   * @see #getOperation()
   * @generated
   */
  void setOperation(OperationDeclaration value);

  /**
   * Returns the value of the '<em><b>Postcondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postcondition</em>' containment reference.
   * @see #setPostcondition(ExpCS)
   * @see modelConverter.use_language.use.UsePackage#getTransition_Postcondition()
   * @model containment="true"
   * @generated
   */
  ExpCS getPostcondition();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Transition#getPostcondition <em>Postcondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postcondition</em>' containment reference.
   * @see #getPostcondition()
   * @generated
   */
  void setPostcondition(ExpCS value);

} // Transition
