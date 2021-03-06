/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.StringLiteralExpCS#getSegments <em>Segments</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getStringLiteralExpCS()
 * @model
 * @generated
 */
public interface StringLiteralExpCS extends PrimitiveLiteralExpCS
{
  /**
   * Returns the value of the '<em><b>Segments</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Segments</em>' attribute list.
   * @see modelConverter.use_language.use.UsePackage#getStringLiteralExpCS_Segments()
   * @model unique="false"
   * @generated
   */
  EList<String> getSegments();

} // StringLiteralExpCS
