/**
 * GetCustomerByIdResponseReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.by.service;

public class GetCustomerByIdResponseReturn implements java.io.Serializable {
	private com.epam.by.service.GetCustomerByIdResponseReturnEmail email;

	private com.epam.by.service.GetCustomerByIdResponseReturnPhone phone;

	private byte id; // attribute

	private java.lang.String firstName; // attribute

	private java.lang.String lastName; // attribute

	public GetCustomerByIdResponseReturn() {
	}

	public GetCustomerByIdResponseReturn(com.epam.by.service.GetCustomerByIdResponseReturnEmail email, com.epam.by.service.GetCustomerByIdResponseReturnPhone phone, byte id, java.lang.String firstName, java.lang.String lastName) {
		this.email = email;
		this.phone = phone;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gets the email value for this GetCustomerByIdResponseReturn.
	 * 
	 * @return email
	 */
	public com.epam.by.service.GetCustomerByIdResponseReturnEmail getEmail() {
		return email;
	}

	/**
	 * Sets the email value for this GetCustomerByIdResponseReturn.
	 * 
	 * @param email
	 */
	public void setEmail(com.epam.by.service.GetCustomerByIdResponseReturnEmail email) {
		this.email = email;
	}

	/**
	 * Gets the phone value for this GetCustomerByIdResponseReturn.
	 * 
	 * @return phone
	 */
	public com.epam.by.service.GetCustomerByIdResponseReturnPhone getPhone() {
		return phone;
	}

	/**
	 * Sets the phone value for this GetCustomerByIdResponseReturn.
	 * 
	 * @param phone
	 */
	public void setPhone(com.epam.by.service.GetCustomerByIdResponseReturnPhone phone) {
		this.phone = phone;
	}

	/**
	 * Gets the id value for this GetCustomerByIdResponseReturn.
	 * 
	 * @return id
	 */
	public byte getId() {
		return id;
	}

	/**
	 * Sets the id value for this GetCustomerByIdResponseReturn.
	 * 
	 * @param id
	 */
	public void setId(byte id) {
		this.id = id;
	}

	/**
	 * Gets the firstName value for this GetCustomerByIdResponseReturn.
	 * 
	 * @return firstName
	 */
	public java.lang.String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the firstName value for this GetCustomerByIdResponseReturn.
	 * 
	 * @param firstName
	 */
	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the lastName value for this GetCustomerByIdResponseReturn.
	 * 
	 * @return lastName
	 */
	public java.lang.String getLastName() {
		return lastName;
	}

	/**
	 * Sets the lastName value for this GetCustomerByIdResponseReturn.
	 * 
	 * @param lastName
	 */
	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof GetCustomerByIdResponseReturn))
			return false;
		GetCustomerByIdResponseReturn other = (GetCustomerByIdResponseReturn) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true && ((this.email == null && other.getEmail() == null) || (this.email != null && this.email.equals(other.getEmail())))
				&& ((this.phone == null && other.getPhone() == null) || (this.phone != null && this.phone.equals(other.getPhone()))) && this.id == other.getId()
				&& ((this.firstName == null && other.getFirstName() == null) || (this.firstName != null && this.firstName.equals(other.getFirstName())))
				&& ((this.lastName == null && other.getLastName() == null) || (this.lastName != null && this.lastName.equals(other.getLastName())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getEmail() != null) {
			_hashCode += getEmail().hashCode();
		}
		if (getPhone() != null) {
			_hashCode += getPhone().hashCode();
		}
		_hashCode += getId();
		if (getFirstName() != null) {
			_hashCode += getFirstName().hashCode();
		}
		if (getLastName() != null) {
			_hashCode += getLastName().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(GetCustomerByIdResponseReturn.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.by.epam.com/", ">getCustomerByIdResponse>return"));
		org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
		attrField.setFieldName("id");
		attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
		attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
		typeDesc.addFieldDesc(attrField);
		attrField = new org.apache.axis.description.AttributeDesc();
		attrField.setFieldName("firstName");
		attrField.setXmlName(new javax.xml.namespace.QName("", "FirstName"));
		attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		typeDesc.addFieldDesc(attrField);
		attrField = new org.apache.axis.description.AttributeDesc();
		attrField.setFieldName("lastName");
		attrField.setXmlName(new javax.xml.namespace.QName("", "LastName"));
		attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		typeDesc.addFieldDesc(attrField);
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("email");
		elemField.setXmlName(new javax.xml.namespace.QName("", "Email"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://service.by.epam.com/", ">>getCustomerByIdResponse>return>Email"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("phone");
		elemField.setXmlName(new javax.xml.namespace.QName("", "Phone"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://service.by.epam.com/", ">>getCustomerByIdResponse>return>Phone"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType, java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType, java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [email=" + email + ", phone=" + phone + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
