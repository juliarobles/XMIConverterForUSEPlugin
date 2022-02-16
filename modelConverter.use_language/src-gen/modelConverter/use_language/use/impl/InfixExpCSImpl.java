/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use.impl;

import modelConverter.use_language.use.ExpCS;
import modelConverter.use_language.use.InfixExpCS;
import modelConverter.use_language.use.UsePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infix Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.impl.InfixExpCSImpl#getOwnedLeft <em>Owned Left</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.InfixExpCSImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.InfixExpCSImpl#getOwnedRight <em>Owned Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InfixExpCSImpl extends ExpCSImpl implements InfixExpCS
{
  /**
   * The cached value of the '{@link #getOwnedLeft() <em>Owned Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedLeft()
   * @generated
   * @ordered
   */
  protected ExpCS ownedLeft;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final String OPERATOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected String operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getOwnedRight() <em>Owned Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedRight()
   * @generated
   * @ordered
   */
  protected ExpCS ownedRight;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InfixExpCSImpl()
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
    return UsePackage.Literals.INFIX_EXP_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpCS getOwnedLeft()
  {
    return ownedLeft;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedLeft(ExpCS newOwnedLeft, NotificationChain msgs)
  {
    ExpCS oldOwnedLeft = ownedLeft;
    ownedLeft = newOwnedLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsePackage.INFIX_EXP_CS__OWNED_LEFT, oldOwnedLeft, newOwnedLeft);
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
  public void setOwnedLeft(ExpCS newOwnedLeft)
  {
    if (newOwnedLeft != ownedLeft)
    {
      NotificationChain msgs = null;
      if (ownedLeft != null)
        msgs = ((InternalEObject)ownedLeft).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsePackage.INFIX_EXP_CS__OWNED_LEFT, null, msgs);
      if (newOwnedLeft != null)
        msgs = ((InternalEObject)newOwnedLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsePackage.INFIX_EXP_CS__OWNED_LEFT, null, msgs);
      msgs = basicSetOwnedLeft(newOwnedLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.INFIX_EXP_CS__OWNED_LEFT, newOwnedLeft, newOwnedLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOperator(String newOperator)
  {
    String oldOperator = operator;
    operator = newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.INFIX_EXP_CS__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpCS getOwnedRight()
  {
    return ownedRight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedRight(ExpCS newOwnedRight, NotificationChain msgs)
  {
    ExpCS oldOwnedRight = ownedRight;
    ownedRight = newOwnedRight;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsePackage.INFIX_EXP_CS__OWNED_RIGHT, oldOwnedRight, newOwnedRight);
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
  public void setOwnedRight(ExpCS newOwnedRight)
  {
    if (newOwnedRight != ownedRight)
    {
      NotificationChain msgs = null;
      if (ownedRight != null)
        msgs = ((InternalEObject)ownedRight).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsePackage.INFIX_EXP_CS__OWNED_RIGHT, null, msgs);
      if (newOwnedRight != null)
        msgs = ((InternalEObject)newOwnedRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsePackage.INFIX_EXP_CS__OWNED_RIGHT, null, msgs);
      msgs = basicSetOwnedRight(newOwnedRight, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.INFIX_EXP_CS__OWNED_RIGHT, newOwnedRight, newOwnedRight));
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
      case UsePackage.INFIX_EXP_CS__OWNED_LEFT:
        return basicSetOwnedLeft(null, msgs);
      case UsePackage.INFIX_EXP_CS__OWNED_RIGHT:
        return basicSetOwnedRight(null, msgs);
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
      case UsePackage.INFIX_EXP_CS__OWNED_LEFT:
        return getOwnedLeft();
      case UsePackage.INFIX_EXP_CS__OPERATOR:
        return getOperator();
      case UsePackage.INFIX_EXP_CS__OWNED_RIGHT:
        return getOwnedRight();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UsePackage.INFIX_EXP_CS__OWNED_LEFT:
        setOwnedLeft((ExpCS)newValue);
        return;
      case UsePackage.INFIX_EXP_CS__OPERATOR:
        setOperator((String)newValue);
        return;
      case UsePackage.INFIX_EXP_CS__OWNED_RIGHT:
        setOwnedRight((ExpCS)newValue);
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
      case UsePackage.INFIX_EXP_CS__OWNED_LEFT:
        setOwnedLeft((ExpCS)null);
        return;
      case UsePackage.INFIX_EXP_CS__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case UsePackage.INFIX_EXP_CS__OWNED_RIGHT:
        setOwnedRight((ExpCS)null);
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
      case UsePackage.INFIX_EXP_CS__OWNED_LEFT:
        return ownedLeft != null;
      case UsePackage.INFIX_EXP_CS__OPERATOR:
        return OPERATOR_EDEFAULT == null ? operator != null : !OPERATOR_EDEFAULT.equals(operator);
      case UsePackage.INFIX_EXP_CS__OWNED_RIGHT:
        return ownedRight != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //InfixExpCSImpl