/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.CollectionTypeCS#getName <em>Name</em>}</li>
 *   <li>{@link modelConverter.use_language.use.CollectionTypeCS#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link modelConverter.use_language.use.CollectionTypeCS#getOwnedCollectionMultiplicity <em>Owned Collection Multiplicity</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getCollectionTypeCS()
 * @model
 * @generated
 */
public interface CollectionTypeCS extends TypedRefCS
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see modelConverter.use_language.use.UsePackage#getCollectionTypeCS_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.CollectionTypeCS#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Type</em>' containment reference.
   * @see #setOwnedType(TypedRefCS)
   * @see modelConverter.use_language.use.UsePackage#getCollectionTypeCS_OwnedType()
   * @model containment="true"
   * @generated
   */
  TypedRefCS getOwnedType();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.CollectionTypeCS#getOwnedType <em>Owned Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Type</em>' containment reference.
   * @see #getOwnedType()
   * @generated
   */
  void setOwnedType(TypedRefCS value);

  /**
   * Returns the value of the '<em><b>Owned Collection Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Collection Multiplicity</em>' containment reference.
   * @see #setOwnedCollectionMultiplicity(MultiplicityCS)
   * @see modelConverter.use_language.use.UsePackage#getCollectionTypeCS_OwnedCollectionMultiplicity()
   * @model containment="true"
   * @generated
   */
  MultiplicityCS getOwnedCollectionMultiplicity();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.CollectionTypeCS#getOwnedCollectionMultiplicity <em>Owned Collection Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Collection Multiplicity</em>' containment reference.
   * @see #getOwnedCollectionMultiplicity()
   * @generated
   */
  void setOwnedCollectionMultiplicity(MultiplicityCS value);

} // CollectionTypeCS