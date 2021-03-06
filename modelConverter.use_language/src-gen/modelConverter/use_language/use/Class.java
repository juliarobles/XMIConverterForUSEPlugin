/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.Class#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link modelConverter.use_language.use.Class#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link modelConverter.use_language.use.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link modelConverter.use_language.use.Class#getOperations <em>Operations</em>}</li>
 *   <li>{@link modelConverter.use_language.use.Class#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link modelConverter.use_language.use.Class#getStatemachines <em>Statemachines</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Type, AllClass
{
  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see modelConverter.use_language.use.UsePackage#getClass_Abstract()
   * @model
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Class#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Generalization</b></em>' containment reference list.
   * The list contents are of type {@link modelConverter.use_language.use.Generalization}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generalization</em>' containment reference list.
   * @see modelConverter.use_language.use.UsePackage#getClass_Generalization()
   * @model containment="true"
   * @generated
   */
  EList<Generalization> getGeneralization();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference.
   * @see #setAttributes(AttributesBase)
   * @see modelConverter.use_language.use.UsePackage#getClass_Attributes()
   * @model containment="true"
   * @generated
   */
  AttributesBase getAttributes();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Class#getAttributes <em>Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attributes</em>' containment reference.
   * @see #getAttributes()
   * @generated
   */
  void setAttributes(AttributesBase value);

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference.
   * @see #setOperations(OperationsBase)
   * @see modelConverter.use_language.use.UsePackage#getClass_Operations()
   * @model containment="true"
   * @generated
   */
  OperationsBase getOperations();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Class#getOperations <em>Operations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operations</em>' containment reference.
   * @see #getOperations()
   * @generated
   */
  void setOperations(OperationsBase value);

  /**
   * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' containment reference.
   * @see #setConstraints(ConstraintsBase)
   * @see modelConverter.use_language.use.UsePackage#getClass_Constraints()
   * @model containment="true"
   * @generated
   */
  ConstraintsBase getConstraints();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Class#getConstraints <em>Constraints</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraints</em>' containment reference.
   * @see #getConstraints()
   * @generated
   */
  void setConstraints(ConstraintsBase value);

  /**
   * Returns the value of the '<em><b>Statemachines</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statemachines</em>' containment reference.
   * @see #setStatemachines(StateMachinesBase)
   * @see modelConverter.use_language.use.UsePackage#getClass_Statemachines()
   * @model containment="true"
   * @generated
   */
  StateMachinesBase getStatemachines();

  /**
   * Sets the value of the '{@link modelConverter.use_language.use.Class#getStatemachines <em>Statemachines</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statemachines</em>' containment reference.
   * @see #getStatemachines()
   * @generated
   */
  void setStatemachines(StateMachinesBase value);

} // Class
