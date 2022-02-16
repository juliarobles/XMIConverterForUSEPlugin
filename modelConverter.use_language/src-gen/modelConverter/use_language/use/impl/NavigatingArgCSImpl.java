/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use.impl;

import modelConverter.use_language.use.ExpCS;
import modelConverter.use_language.use.NavigatingArgCS;
import modelConverter.use_language.use.TypedRefCS;
import modelConverter.use_language.use.UsePackage;
import modelConverter.use_language.use.VariableCS;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigating Arg CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.impl.NavigatingArgCSImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.NavigatingArgCSImpl#getOwnedNameExpression <em>Owned Name Expression</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.NavigatingArgCSImpl#getSymbolT <em>Symbol T</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.NavigatingArgCSImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.NavigatingArgCSImpl#getSymbolIE <em>Symbol IE</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.NavigatingArgCSImpl#getOwnedInitExpression <em>Owned Init Expression</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.NavigatingArgCSImpl#getSymbolCI <em>Symbol CI</em>}</li>
 *   <li>{@link modelConverter.use_language.use.impl.NavigatingArgCSImpl#getOwnedCoIterator <em>Owned Co Iterator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NavigatingArgCSImpl extends MinimalEObjectImpl.Container implements NavigatingArgCS
{
  /**
   * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefix()
   * @generated
   * @ordered
   */
  protected static final String PREFIX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefix()
   * @generated
   * @ordered
   */
  protected String prefix = PREFIX_EDEFAULT;

  /**
   * The cached value of the '{@link #getOwnedNameExpression() <em>Owned Name Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedNameExpression()
   * @generated
   * @ordered
   */
  protected ExpCS ownedNameExpression;

  /**
   * The default value of the '{@link #getSymbolT() <em>Symbol T</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbolT()
   * @generated
   * @ordered
   */
  protected static final String SYMBOL_T_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSymbolT() <em>Symbol T</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbolT()
   * @generated
   * @ordered
   */
  protected String symbolT = SYMBOL_T_EDEFAULT;

  /**
   * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedType()
   * @generated
   * @ordered
   */
  protected TypedRefCS ownedType;

  /**
   * The default value of the '{@link #getSymbolIE() <em>Symbol IE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbolIE()
   * @generated
   * @ordered
   */
  protected static final String SYMBOL_IE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSymbolIE() <em>Symbol IE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbolIE()
   * @generated
   * @ordered
   */
  protected String symbolIE = SYMBOL_IE_EDEFAULT;

  /**
   * The cached value of the '{@link #getOwnedInitExpression() <em>Owned Init Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedInitExpression()
   * @generated
   * @ordered
   */
  protected ExpCS ownedInitExpression;

  /**
   * The default value of the '{@link #getSymbolCI() <em>Symbol CI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbolCI()
   * @generated
   * @ordered
   */
  protected static final String SYMBOL_CI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSymbolCI() <em>Symbol CI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbolCI()
   * @generated
   * @ordered
   */
  protected String symbolCI = SYMBOL_CI_EDEFAULT;

  /**
   * The cached value of the '{@link #getOwnedCoIterator() <em>Owned Co Iterator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedCoIterator()
   * @generated
   * @ordered
   */
  protected VariableCS ownedCoIterator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NavigatingArgCSImpl()
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
    return UsePackage.Literals.NAVIGATING_ARG_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getPrefix()
  {
    return prefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPrefix(String newPrefix)
  {
    String oldPrefix = prefix;
    prefix = newPrefix;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__PREFIX, oldPrefix, prefix));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpCS getOwnedNameExpression()
  {
    return ownedNameExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedNameExpression(ExpCS newOwnedNameExpression, NotificationChain msgs)
  {
    ExpCS oldOwnedNameExpression = ownedNameExpression;
    ownedNameExpression = newOwnedNameExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, oldOwnedNameExpression, newOwnedNameExpression);
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
  public void setOwnedNameExpression(ExpCS newOwnedNameExpression)
  {
    if (newOwnedNameExpression != ownedNameExpression)
    {
      NotificationChain msgs = null;
      if (ownedNameExpression != null)
        msgs = ((InternalEObject)ownedNameExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsePackage.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, null, msgs);
      if (newOwnedNameExpression != null)
        msgs = ((InternalEObject)newOwnedNameExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsePackage.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, null, msgs);
      msgs = basicSetOwnedNameExpression(newOwnedNameExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, newOwnedNameExpression, newOwnedNameExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getSymbolT()
  {
    return symbolT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSymbolT(String newSymbolT)
  {
    String oldSymbolT = symbolT;
    symbolT = newSymbolT;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__SYMBOL_T, oldSymbolT, symbolT));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TypedRefCS getOwnedType()
  {
    return ownedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedType(TypedRefCS newOwnedType, NotificationChain msgs)
  {
    TypedRefCS oldOwnedType = ownedType;
    ownedType = newOwnedType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__OWNED_TYPE, oldOwnedType, newOwnedType);
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
  public void setOwnedType(TypedRefCS newOwnedType)
  {
    if (newOwnedType != ownedType)
    {
      NotificationChain msgs = null;
      if (ownedType != null)
        msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsePackage.NAVIGATING_ARG_CS__OWNED_TYPE, null, msgs);
      if (newOwnedType != null)
        msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsePackage.NAVIGATING_ARG_CS__OWNED_TYPE, null, msgs);
      msgs = basicSetOwnedType(newOwnedType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__OWNED_TYPE, newOwnedType, newOwnedType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getSymbolIE()
  {
    return symbolIE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSymbolIE(String newSymbolIE)
  {
    String oldSymbolIE = symbolIE;
    symbolIE = newSymbolIE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__SYMBOL_IE, oldSymbolIE, symbolIE));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpCS getOwnedInitExpression()
  {
    return ownedInitExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedInitExpression(ExpCS newOwnedInitExpression, NotificationChain msgs)
  {
    ExpCS oldOwnedInitExpression = ownedInitExpression;
    ownedInitExpression = newOwnedInitExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, oldOwnedInitExpression, newOwnedInitExpression);
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
  public void setOwnedInitExpression(ExpCS newOwnedInitExpression)
  {
    if (newOwnedInitExpression != ownedInitExpression)
    {
      NotificationChain msgs = null;
      if (ownedInitExpression != null)
        msgs = ((InternalEObject)ownedInitExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsePackage.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, null, msgs);
      if (newOwnedInitExpression != null)
        msgs = ((InternalEObject)newOwnedInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsePackage.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, null, msgs);
      msgs = basicSetOwnedInitExpression(newOwnedInitExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, newOwnedInitExpression, newOwnedInitExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getSymbolCI()
  {
    return symbolCI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSymbolCI(String newSymbolCI)
  {
    String oldSymbolCI = symbolCI;
    symbolCI = newSymbolCI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__SYMBOL_CI, oldSymbolCI, symbolCI));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariableCS getOwnedCoIterator()
  {
    return ownedCoIterator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedCoIterator(VariableCS newOwnedCoIterator, NotificationChain msgs)
  {
    VariableCS oldOwnedCoIterator = ownedCoIterator;
    ownedCoIterator = newOwnedCoIterator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, oldOwnedCoIterator, newOwnedCoIterator);
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
  public void setOwnedCoIterator(VariableCS newOwnedCoIterator)
  {
    if (newOwnedCoIterator != ownedCoIterator)
    {
      NotificationChain msgs = null;
      if (ownedCoIterator != null)
        msgs = ((InternalEObject)ownedCoIterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsePackage.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, null, msgs);
      if (newOwnedCoIterator != null)
        msgs = ((InternalEObject)newOwnedCoIterator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsePackage.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, null, msgs);
      msgs = basicSetOwnedCoIterator(newOwnedCoIterator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, newOwnedCoIterator, newOwnedCoIterator));
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
      case UsePackage.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION:
        return basicSetOwnedNameExpression(null, msgs);
      case UsePackage.NAVIGATING_ARG_CS__OWNED_TYPE:
        return basicSetOwnedType(null, msgs);
      case UsePackage.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION:
        return basicSetOwnedInitExpression(null, msgs);
      case UsePackage.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR:
        return basicSetOwnedCoIterator(null, msgs);
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
      case UsePackage.NAVIGATING_ARG_CS__PREFIX:
        return getPrefix();
      case UsePackage.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION:
        return getOwnedNameExpression();
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_T:
        return getSymbolT();
      case UsePackage.NAVIGATING_ARG_CS__OWNED_TYPE:
        return getOwnedType();
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_IE:
        return getSymbolIE();
      case UsePackage.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION:
        return getOwnedInitExpression();
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_CI:
        return getSymbolCI();
      case UsePackage.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR:
        return getOwnedCoIterator();
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
      case UsePackage.NAVIGATING_ARG_CS__PREFIX:
        setPrefix((String)newValue);
        return;
      case UsePackage.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION:
        setOwnedNameExpression((ExpCS)newValue);
        return;
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_T:
        setSymbolT((String)newValue);
        return;
      case UsePackage.NAVIGATING_ARG_CS__OWNED_TYPE:
        setOwnedType((TypedRefCS)newValue);
        return;
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_IE:
        setSymbolIE((String)newValue);
        return;
      case UsePackage.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION:
        setOwnedInitExpression((ExpCS)newValue);
        return;
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_CI:
        setSymbolCI((String)newValue);
        return;
      case UsePackage.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR:
        setOwnedCoIterator((VariableCS)newValue);
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
      case UsePackage.NAVIGATING_ARG_CS__PREFIX:
        setPrefix(PREFIX_EDEFAULT);
        return;
      case UsePackage.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION:
        setOwnedNameExpression((ExpCS)null);
        return;
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_T:
        setSymbolT(SYMBOL_T_EDEFAULT);
        return;
      case UsePackage.NAVIGATING_ARG_CS__OWNED_TYPE:
        setOwnedType((TypedRefCS)null);
        return;
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_IE:
        setSymbolIE(SYMBOL_IE_EDEFAULT);
        return;
      case UsePackage.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION:
        setOwnedInitExpression((ExpCS)null);
        return;
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_CI:
        setSymbolCI(SYMBOL_CI_EDEFAULT);
        return;
      case UsePackage.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR:
        setOwnedCoIterator((VariableCS)null);
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
      case UsePackage.NAVIGATING_ARG_CS__PREFIX:
        return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
      case UsePackage.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION:
        return ownedNameExpression != null;
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_T:
        return SYMBOL_T_EDEFAULT == null ? symbolT != null : !SYMBOL_T_EDEFAULT.equals(symbolT);
      case UsePackage.NAVIGATING_ARG_CS__OWNED_TYPE:
        return ownedType != null;
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_IE:
        return SYMBOL_IE_EDEFAULT == null ? symbolIE != null : !SYMBOL_IE_EDEFAULT.equals(symbolIE);
      case UsePackage.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION:
        return ownedInitExpression != null;
      case UsePackage.NAVIGATING_ARG_CS__SYMBOL_CI:
        return SYMBOL_CI_EDEFAULT == null ? symbolCI != null : !SYMBOL_CI_EDEFAULT.equals(symbolCI);
      case UsePackage.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR:
        return ownedCoIterator != null;
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
    result.append(" (prefix: ");
    result.append(prefix);
    result.append(", symbolT: ");
    result.append(symbolT);
    result.append(", symbolIE: ");
    result.append(symbolIE);
    result.append(", symbolCI: ");
    result.append(symbolCI);
    result.append(')');
    return result.toString();
  }

} //NavigatingArgCSImpl
