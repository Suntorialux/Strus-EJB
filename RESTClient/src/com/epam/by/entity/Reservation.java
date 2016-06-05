/**
 * 
 */
package com.epam.by.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "Reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation implements Serializable {

	/** The list of customers */
	@XmlElement(name = "Customer")
	private List<Customer> customers = new ArrayList<>();

	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	public Reservation() {
	}

	@XmlRootElement(name = "Customer")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Customer implements Serializable {

		private static final long serialVersionUID = 1L;

		/** The id of customer */
		@XmlAttribute(name = "id")
		private int id;

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

		public Customer() {

		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @param firstName
		 *            the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @param lastName
		 *            the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @param email
		 *            the email to set
		 */
		public void setEmail(Email email) {
			this.email = email;
		}

		/**
		 * @param phone
		 *            the phone to set
		 */
		public void setPhone(Phone phone) {
			this.phone = phone;
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

		@XmlRootElement(name = "Email")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class Email implements Serializable {

			private static final long serialVersionUID = 1L;

			/** The email of customer */
			@XmlAttribute(name = "EmailAddress")
			private String emailAddress;

			public Email() {

			}

			/**
			 * @param emailAddress
			 *            the emailAddress to set
			 */
			public void setEmailAddress(String emailAddress) {
				this.emailAddress = emailAddress;
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

			/** The phone of customer */
			@XmlAttribute(name = "PhoneNumber")
			private String phoneNumber;

			public Phone() {

			}

			/**
			 * @param phoneNumber
			 *            the phoneNumber to set
			 */
			public void setPhoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
			}

			/**
			 * @return the phoneNumber
			 */
			public String getPhoneNumber() {
				return phoneNumber;
			}

			@Override
			public String toString() {
				return phoneNumber;
			}

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + "]";
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reservation [" + customers + "]";
	}

}
