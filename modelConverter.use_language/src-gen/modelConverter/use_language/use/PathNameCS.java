/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Name CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.PathNameCS#getOwnedPathElements <em>Owned Path Elements</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getPathNameCS()
 * @model
 * @generated
 */
public interface PathNameCS extends EObject
{
  /**
   * Returns the value of the '<em><b>Owned Path Elements</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Path Elements</em>' attribute list.
   * @see modelConverter.use_language.use.UsePackage#getPathNameCS_OwnedPathElements()
   * @model unique="false"
   * @generated
   */
  EList<String> getOwnedPathElements();

} // PathNameCS
