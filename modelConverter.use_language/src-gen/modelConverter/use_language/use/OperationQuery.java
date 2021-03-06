/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.OperationQuery#getOperationbody <em>Operationbody</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getOperationQuery()
 * @model
 * @generated
 */
public interface OperationQuery extends OperationType
{
  /**
   * Returns the value of the '<em><b>Operationbody</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operationbody</em>' containment reference.
   * @see #setOperationbody(ExpCS)
   * @see modelConverter.use_language.use.UsePackage#getOperationQuery_Operationbody()
   * @model containment="true"
   * @generated
   */
  ExpCS getOperationbody();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.OperationQuery#getOperationbody <em>Operationbody</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operationbody</em>' containment reference.
   * @see #getOperationbody()
   * @generated
   */
  void setOperationbody(ExpCS value);

} // OperationQuery
