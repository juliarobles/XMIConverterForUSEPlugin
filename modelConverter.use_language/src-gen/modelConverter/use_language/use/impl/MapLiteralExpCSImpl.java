/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use.impl;

import java.util.Collection;

import modelConverter.use_language.use.MapLiteralExpCS;
import modelConverter.use_language.use.MapLiteralPartCS;
import modelConverter.use_language.use.MapTypeCS;
import modelConverter.use_language.use.UsePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.impl.MapLiteralExpCSImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.MapLiteralExpCSImpl#getOwnedParts <em>Owned Parts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MapLiteralExpCSImpl extends ExpCSImpl implements MapLiteralExpCS
{
  /**
   * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedType()
   * @generated
   * @ordered
   */
  protected MapTypeCS ownedType;

  /**
   * The cached value of the '{@link #getOwnedParts() <em>Owned Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedParts()
   * @generated
   * @ordered
   */
  protected EList<MapLiteralPartCS> ownedParts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MapLiteralExpCSImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return UsePackage.Literals.MAP_LITERAL_EXP_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MapTypeCS getOwnedType()
  {
    return ownedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedType(MapTypeCS newOwnedType, NotificationChain msgs)
  {
    MapTypeCS oldOwnedType = ownedType;
    ownedType = newOwnedType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsePackage.MAP_LITERAL_EXP_CS__OWNED_TYPE, oldOwnedType, newOwnedType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOwnedType(MapTypeCS newOwnedType)
  {
    if (newOwnedType != ownedType)
    {
      NotificationChain msgs = null;
      if (ownedType != null)
        msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsePackage.MAP_LITERAL_EXP_CS__OWNED_TYPE, null, msgs);
      if (newOwnedType != null)
        msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsePackage.MAP_LITERAL_EXP_CS__OWNED_TYPE, null, msgs);
      msgs = basicSetOwnedType(newOwnedType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.MAP_LITERAL_EXP_CS__OWNED_TYPE, newOwnedType, newOwnedType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MapLiteralPartCS> getOwnedParts()
  {
    if (ownedParts == null)
    {
      ownedParts = new EObjectContainmentEList<MapLiteralPartCS>(MapLiteralPartCS.class, this, UsePackage.MAP_LITERAL_EXP_CS__OWNED_PARTS);
    }
    return ownedParts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_TYPE:
        return basicSetOwnedType(null, msgs);
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_PARTS:
        return ((InternalEList<?>)getOwnedParts()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_TYPE:
        return getOwnedType();
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_PARTS:
        return getOwnedParts();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_TYPE:
        setOwnedType((MapTypeCS)newValue);
        return;
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_PARTS:
        getOwnedParts().clear();
        getOwnedParts().addAll((Collection<? extends MapLiteralPartCS>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_TYPE:
        setOwnedType((MapTypeCS)null);
        return;
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_PARTS:
        getOwnedParts().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_TYPE:
        return ownedType != null;
      case UsePackage.MAP_LITERAL_EXP_CS__OWNED_PARTS:
        return ownedParts != null && !ownedParts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MapLiteralExpCSImpl
