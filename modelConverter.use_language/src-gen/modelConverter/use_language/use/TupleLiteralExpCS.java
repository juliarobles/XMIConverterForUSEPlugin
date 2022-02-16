/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.TupleLiteralExpCS#getOwnedParts <em>Owned Parts</em>}</li>
 * </ul>
 *
 * @see modelConverter.use_language.use.UsePackage#getTupleLiteralExpCS()
 * @model
 * @generated
 */
public interface TupleLiteralExpCS extends ExpCS
{
  /**
   * Returns the value of the '<em><b>Owned Parts</b></em>' containment reference list.
   * The list contents are of type {@link modelConverter.use_language.use.TupleLiteralPartCS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Parts</em>' containment reference list.
   * @see modelConverter.use_language.use.UsePackage#getTupleLiteralExpCS_OwnedParts()
   * @model containment="true"
   * @generated
   */
  EList<TupleLiteralPartCS> getOwnedParts();

} // TupleLiteralExpCS
