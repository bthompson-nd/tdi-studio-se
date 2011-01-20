/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.designer.xmlmap.model.emf.xmlmap.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.talend.designer.xmlmap.model.emf.xmlmap.AbstractNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.Connection;
import org.talend.designer.xmlmap.model.emf.xmlmap.XmlmapPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.designer.xmlmap.model.emf.xmlmap.impl.AbstractNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.designer.xmlmap.model.emf.xmlmap.impl.AbstractNodeImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.talend.designer.xmlmap.model.emf.xmlmap.impl.AbstractNodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.talend.designer.xmlmap.model.emf.xmlmap.impl.AbstractNodeImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link org.talend.designer.xmlmap.model.emf.xmlmap.impl.AbstractNodeImpl#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 *   <li>{@link org.talend.designer.xmlmap.model.emf.xmlmap.impl.AbstractNodeImpl#getIncomingConnections <em>Incoming Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractNodeImpl extends EObjectImpl implements AbstractNode {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
    protected static final String EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
    protected String expression = EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final String TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected String type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNullable()
     * @generated
     * @ordered
     */
    protected static final boolean NULLABLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNullable()
     * @generated
     * @ordered
     */
    protected boolean nullable = NULLABLE_EDEFAULT;

    /**
     * The cached value of the '{@link #getOutgoingConnections() <em>Outgoing Connections</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutgoingConnections()
     * @generated
     * @ordered
     */
    protected EList<Connection> outgoingConnections;

    /**
     * The cached value of the '{@link #getIncomingConnections() <em>Incoming Connections</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncomingConnections()
     * @generated
     * @ordered
     */
    protected EList<Connection> incomingConnections;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractNodeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XmlmapPackage.Literals.ABSTRACT_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmlmapPackage.ABSTRACT_NODE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExpression() {
        return expression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpression(String newExpression) {
        String oldExpression = expression;
        expression = newExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmlmapPackage.ABSTRACT_NODE__EXPRESSION, oldExpression, expression));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(String newType) {
        String oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmlmapPackage.ABSTRACT_NODE__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isNullable() {
        return nullable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNullable(boolean newNullable) {
        boolean oldNullable = nullable;
        nullable = newNullable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmlmapPackage.ABSTRACT_NODE__NULLABLE, oldNullable, nullable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connection> getOutgoingConnections() {
        if (outgoingConnections == null) {
            outgoingConnections = new EObjectWithInverseResolvingEList<Connection>(Connection.class, this, XmlmapPackage.ABSTRACT_NODE__OUTGOING_CONNECTIONS, XmlmapPackage.CONNECTION__SOURCE);
        }
        return outgoingConnections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connection> getIncomingConnections() {
        if (incomingConnections == null) {
            incomingConnections = new EObjectWithInverseResolvingEList<Connection>(Connection.class, this, XmlmapPackage.ABSTRACT_NODE__INCOMING_CONNECTIONS, XmlmapPackage.CONNECTION__TARGET);
        }
        return incomingConnections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case XmlmapPackage.ABSTRACT_NODE__OUTGOING_CONNECTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingConnections()).basicAdd(otherEnd, msgs);
            case XmlmapPackage.ABSTRACT_NODE__INCOMING_CONNECTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingConnections()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case XmlmapPackage.ABSTRACT_NODE__OUTGOING_CONNECTIONS:
                return ((InternalEList<?>)getOutgoingConnections()).basicRemove(otherEnd, msgs);
            case XmlmapPackage.ABSTRACT_NODE__INCOMING_CONNECTIONS:
                return ((InternalEList<?>)getIncomingConnections()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XmlmapPackage.ABSTRACT_NODE__NAME:
                return getName();
            case XmlmapPackage.ABSTRACT_NODE__EXPRESSION:
                return getExpression();
            case XmlmapPackage.ABSTRACT_NODE__TYPE:
                return getType();
            case XmlmapPackage.ABSTRACT_NODE__NULLABLE:
                return isNullable();
            case XmlmapPackage.ABSTRACT_NODE__OUTGOING_CONNECTIONS:
                return getOutgoingConnections();
            case XmlmapPackage.ABSTRACT_NODE__INCOMING_CONNECTIONS:
                return getIncomingConnections();
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
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case XmlmapPackage.ABSTRACT_NODE__NAME:
                setName((String)newValue);
                return;
            case XmlmapPackage.ABSTRACT_NODE__EXPRESSION:
                setExpression((String)newValue);
                return;
            case XmlmapPackage.ABSTRACT_NODE__TYPE:
                setType((String)newValue);
                return;
            case XmlmapPackage.ABSTRACT_NODE__NULLABLE:
                setNullable((Boolean)newValue);
                return;
            case XmlmapPackage.ABSTRACT_NODE__OUTGOING_CONNECTIONS:
                getOutgoingConnections().clear();
                getOutgoingConnections().addAll((Collection<? extends Connection>)newValue);
                return;
            case XmlmapPackage.ABSTRACT_NODE__INCOMING_CONNECTIONS:
                getIncomingConnections().clear();
                getIncomingConnections().addAll((Collection<? extends Connection>)newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
            case XmlmapPackage.ABSTRACT_NODE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case XmlmapPackage.ABSTRACT_NODE__EXPRESSION:
                setExpression(EXPRESSION_EDEFAULT);
                return;
            case XmlmapPackage.ABSTRACT_NODE__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case XmlmapPackage.ABSTRACT_NODE__NULLABLE:
                setNullable(NULLABLE_EDEFAULT);
                return;
            case XmlmapPackage.ABSTRACT_NODE__OUTGOING_CONNECTIONS:
                getOutgoingConnections().clear();
                return;
            case XmlmapPackage.ABSTRACT_NODE__INCOMING_CONNECTIONS:
                getIncomingConnections().clear();
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case XmlmapPackage.ABSTRACT_NODE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case XmlmapPackage.ABSTRACT_NODE__EXPRESSION:
                return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
            case XmlmapPackage.ABSTRACT_NODE__TYPE:
                return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
            case XmlmapPackage.ABSTRACT_NODE__NULLABLE:
                return nullable != NULLABLE_EDEFAULT;
            case XmlmapPackage.ABSTRACT_NODE__OUTGOING_CONNECTIONS:
                return outgoingConnections != null && !outgoingConnections.isEmpty();
            case XmlmapPackage.ABSTRACT_NODE__INCOMING_CONNECTIONS:
                return incomingConnections != null && !incomingConnections.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", expression: ");
        result.append(expression);
        result.append(", type: ");
        result.append(type);
        result.append(", nullable: ");
        result.append(nullable);
        result.append(')');
        return result.toString();
    }

} //AbstractNodeImpl
