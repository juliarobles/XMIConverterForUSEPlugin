/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shadow Part CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.ShadowPartCS#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link modelConverter.use_language.use.ShadowPartCS#getOwnedInitExpression <em>Owned Init Expression</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getShadowPartCS()
 * @model
 * @generated
 */
public interface ShadowPartCS extends EObject
{
  /**
   * Returns the value of the '<em><b>Referred Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referred Property</em>' attribute.
   * @see #setReferredProperty(String)
   * @see modelConverter.use_language.use.UsePackage#getShadowPartCS_ReferredProperty()
   * @model
   * @generated
   */
  String getReferredProperty();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.ShadowPartCS#getReferredProperty <em>Referred Property</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referred Property</em>' attribute.
   * @see #getReferredProperty()
   * @generated
   */
  void setReferredProperty(String value);

  /**
   * Returns the value of the '<em><b>Owned Init Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Init Expression</em>' containment reference.
   * @see #setOwnedInitExpression(EObject)
   * @see modelConverter.use_language.use.UsePackage#getShadowPartCS_OwnedInitExpression()
   * @model containment="true"
   * @generated
   */
  EObject getOwnedInitExpression();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.ShadowPartCS#getOwnedInitExpression <em>Owned Init Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Init Expression</em>' containment reference.
   * @see #getOwnedInitExpression()
   * @generated
   */
  void setOwnedInitExpression(EObject value);

} // ShadowPartCS
