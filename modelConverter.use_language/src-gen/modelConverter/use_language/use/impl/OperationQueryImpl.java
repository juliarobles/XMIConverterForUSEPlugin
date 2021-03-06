/**
 * generated by Xtext 2.25.0
 */
package modelConverter.use_language.use.impl;

import modelConverter.use_language.use.ExpCS;
import modelConverter.use_language.use.OperationQuery;
import modelConverter.use_language.use.UsePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelConverter.use_language.use.impl.OperationQueryImpl#getOperationbody <em>Operationbody</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationQueryImpl extends OperationTypeImpl implements OperationQuery
{
  /**
   * The cached value of the '{@link #getOperationbody() <em>Operationbody</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationbody()
   * @generated
   * @ordered
   */
  protected ExpCS operationbody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationQueryImpl()
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
    return UsePackage.Literals.OPERATION_QUERY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpCS getOperationbody()
  {
    return operationbody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperationbody(ExpCS newOperationbody, NotificationChain msgs)
  {
    ExpCS oldOperationbody = operationbody;
    operationbody = newOperationbody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsePackage.OPERATION_QUERY__OPERATIONBODY, oldOperationbody, newOperationbody);
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
  public void setOperationbody(ExpCS newOperationbody)
  {
    if (newOperationbody != operationbody)
    {
      NotificationChain msgs = null;
      if (operationbody != null)
        msgs = ((InternalEObject)operationbody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsePackage.OPERATION_QUERY__OPERATIONBODY, null, msgs);
      if (newOperationbody != null)
        msgs = ((InternalEObject)newOperationbody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsePackage.OPERATION_QUERY__OPERATIONBODY, null, msgs);
      msgs = basicSetOperationbody(newOperationbody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.OPERATION_QUERY__OPERATIONBODY, newOperationbody, newOperationbody));
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
      case UsePackage.OPERATION_QUERY__OPERATIONBODY:
        return basicSetOperationbody(null, msgs);
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
      case UsePackage.OPERATION_QUERY__OPERATIONBODY:
        return getOperationbody();
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
      case UsePackage.OPERATION_QUERY__OPERATIONBODY:
        setOperationbody((ExpCS)newValue);
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
      case UsePackage.OPERATION_QUERY__OPERATIONBODY:
        setOperationbody((ExpCS)null);
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
      case UsePackage.OPERATION_QUERY__OPERATIONBODY:
        return operationbody != null;
    }
    return super.eIsSet(featureID);
  }

} //OperationQueryImpl
