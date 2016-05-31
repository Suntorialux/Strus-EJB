/**
 * 
 */
package com.epam.by.ejb;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "Reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationBean implements SessionBean {

	@XmlAttribute(name = "Code")
	private String code;

	@XmlAttribute(name = "Description")
	private String description;

	@XmlElement(name = "ResComponent")
	private List<ResComponents> resComponents = new ArrayList<>();

	@XmlElement(name = "Customer")
	private Customer customer;

	@XmlElement(name = "FareFamily")
	private FareFamily fareFamily;

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the fareFamily
	 */
	public FareFamily getFareFamily() {
		return fareFamily;
	}

	public void ejbCreate() {

	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {

	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "ResComponent")
	public static class ResComponents {

		@XmlAttribute(name = "ComponentTypeCode")
		private String componentTypeCode;

		@XmlAttribute(name = "CreateDateTime")
		private String createDateTime;

		@XmlAttribute(name = "InternalStatus")
		private InternalStatus internalStatus;

	}

	@XmlRootElement(name = "Customer")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Customer implements Serializable {

		/** The first name of customer */
		@XmlAttribute(name = "FirstName")
		private String firstName;

		/** The last name of customer */
		@XmlAttribute(name = "LastName")
		private String lastName;

		/** The email of customer */
		@XmlElement(name = "Email")
		private Email email;

		/** The phone of customer */
		@XmlElement(name = "Phone")
		private Phone phone;

		/** The customer's list of payments */
		@XmlElement(name = "Payment")
		private List<Payment> payments = new ArrayList<>();

		@XmlRootElement(name = "Email")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class Email {

			@XmlAttribute(name = "EmailAddress")
			private String emailAddress;

		}

		@XmlRootElement(name = "Phone")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class Phone {

			@XmlAttribute(name = "PhoneNumber")
			private String phoneNumber;

		}

		@XmlRootElement(name = "Payment")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class Payment {

			/** The amount of paid */
			@XmlAttribute(name = "AmountPaid")
			private double amountPaid;

			/** The form of payment type code */
			@XmlAttribute(name = "FormOfPaymentTypeCode")
			private String typeCode;

			/** The currency code */
			@XmlAttribute(name = "CurrencyCode")
			private String currencyCode;
		}
	}

	@XmlRootElement(name = "FareFamily")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class FareFamily implements Serializable {

		@XmlAttribute(name = "FareFamilyCode")
		private String fareFamilyCode;

		@XmlElement(name = "AncillaryAirComponent")
		private List<AncillaryAirComponent> components = new ArrayList<>();

		@XmlRootElement(name = "AncillaryAirComponent")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class AncillaryAirComponent {

			@XmlAttribute(name = "AncillaryAirComponentCode")
			private String ancillaryAirComponentCode;
		}

	}

}
