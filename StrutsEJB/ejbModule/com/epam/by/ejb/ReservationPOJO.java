/**
 * 
 */
package com.epam.by.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class ReservationPOJO implements Serializable {

	@XmlAttribute(name = "Code")
	private String code;

	@XmlAttribute(name = "Description")
	private String description;

	@XmlElement(name = "ResComponent")
	private List<ResComponents> resComponents = new ArrayList<>();

	@XmlElement(name = "Customer")
	private List<Customer> customers = new ArrayList<>();

	@XmlElement(name = "FareFamily")
	private List<FareFamily> fareFamilies = new ArrayList<>();

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the resComponents
	 */
	public List<ResComponents> getResComponents() {
		return resComponents;
	}

	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @return the fareFamilies
	 */
	public List<FareFamily> getFareFamilies() {
		return fareFamilies;
	}

	public ReservationPOJO() {
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "ResComponent")
	public static class ResComponents implements Serializable {

		private static final long serialVersionUID = 1L;

		@XmlAttribute(name = "ComponentTypeCode")
		private String componentTypeCode;

		@XmlAttribute(name = "CreateDateTime")
		private String createDateTime;

		@XmlAttribute(name = "InternalStatus")
		private InternalStatus internalStatus;

		/**
		 * 
		 */
		public ResComponents() {

		}

		/**
		 * @return the componentTypeCode
		 */
		public String getComponentTypeCode() {
			return componentTypeCode;
		}

		/**
		 * @return the createDateTime
		 */
		public String getCreateDateTime() {
			return createDateTime;
		}

		/**
		 * @return the internalStatus
		 */
		public InternalStatus getInternalStatus() {
			return internalStatus;
		}

		@Override
		public String toString() {
			return "ResComponent [componentTypeCode=" + componentTypeCode + ", createDateTime=" + createDateTime + ", internalStatus=" + internalStatus + "]\n";
		}

	}

	@XmlRootElement(name = "Customer")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Customer implements Serializable {

		private static final long serialVersionUID = 1L;

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

		/**
		 * 
		 */
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @return the email
		 */
		public Email getEmail() {
			return email;
		}

		/**
		 * @return the phone
		 */
		public Phone getPhone() {
			return phone;
		}

		/**
		 * @return the payments
		 */
		public List<Payment> getPayments() {
			return payments;
		}

		@XmlRootElement(name = "Email")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class Email implements Serializable {

			private static final long serialVersionUID = 1L;

			@XmlAttribute(name = "EmailAddress")
			private String emailAddress;

			/**
			 * 
			 */
			public Email() {
				super();
				// TODO Auto-generated constructor stub
			}

			/**
			 * @return the emailAddress
			 */
			public String getEmailAddress() {
				return emailAddress;
			}

			@Override
			public String toString() {
				return emailAddress;
			}

		}

		@XmlRootElement(name = "Phone")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class Phone implements Serializable {

			private static final long serialVersionUID = 1L;

			@XmlAttribute(name = "PhoneNumber")
			private String phoneNumber;

			/**
			 * 
			 */
			public Phone() {
				super();
				// TODO Auto-generated constructor stub
			}

			/**
			 * @return the phoneNumber
			 */
			public String getPhoneNumber() {
				return phoneNumber;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return phoneNumber;
			}

		}

		@XmlRootElement(name = "Payment")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class Payment implements Serializable {

			private static final long serialVersionUID = 1L;

			/** The amount of paid */
			@XmlAttribute(name = "AmountPaid")
			private double amountPaid;

			/** The form of payment type code */
			@XmlAttribute(name = "FormOfPaymentTypeCode")
			private String typeCode;

			/** The currency code */
			@XmlAttribute(name = "CurrencyCode")
			private String currencyCode;

			/**
			 * 
			 */
			public Payment() {
				super();
				// TODO Auto-generated constructor stub
			}

			/**
			 * @return the amountPaid
			 */
			public double getAmountPaid() {
				return amountPaid;
			}

			/**
			 * @return the typeCode
			 */
			public String getTypeCode() {
				return typeCode;
			}

			/**
			 * @return the currencyCode
			 */
			public String getCurrencyCode() {
				return currencyCode;
			}

			@Override
			public String toString() {
				return "Payment [amountPaid=" + amountPaid + ", typeCode=" + typeCode + ", currencyCode=" + currencyCode + "]";
			}

		}
	}

	@XmlRootElement(name = "FareFamily")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class FareFamily implements Serializable {

		private static final long serialVersionUID = 1L;

		@XmlAttribute(name = "FareFamilyCode")
		private String fareFamilyCode;

		@XmlElement(name = "AncillaryAirComponent")
		private List<AncillaryAirComponent> components = new ArrayList<>();

		/**
		 * 
		 */
		public FareFamily() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @return the fareFamilyCode
		 */
		public String getFareFamilyCode() {
			return fareFamilyCode;
		}

		/**
		 * @return the components
		 */
		public List<AncillaryAirComponent> getComponents() {
			return components;

		}

		@Override
		public String toString() {
			return "FareFamily [fareFamilyCode=" + fareFamilyCode + ", components=" + components + "]";
		}

		@XmlRootElement(name = "AncillaryAirComponent")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class AncillaryAirComponent implements Serializable {

			private static final long serialVersionUID = 1L;

			@XmlAttribute(name = "AncillaryAirComponentCode")
			private String ancillaryAirComponentCode;

			/**
			 * 
			 */
			public AncillaryAirComponent() {
				super();
				// TODO Auto-generated constructor stub
			}

			/**
			 * @return the ancillaryAirComponentCode
			 */
			public String getAncillaryAirComponentCode() {
				return ancillaryAirComponentCode;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "AncillaryAirComponent [ancillaryAirComponentCode=" + ancillaryAirComponentCode + "]";
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReservationPOJO [code=" + code + ", description=" + description + ", resComponents=" + resComponents + ", customers=" + customers + ", fareFamilies=" + fareFamilies + "]";
	}

}
