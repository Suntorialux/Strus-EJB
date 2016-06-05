/**
 * 
 */
package com.epam.by.entity;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.epam.by.entity.Reservation.Customer;
import com.epam.by.entity.Reservation.Customer.Email;
import com.epam.by.entity.Reservation.Customer.Phone;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author Andrei Yahorau
 *
 */
public class Runner {

	public static void main(String[] args) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		/*
		 * Get list of customers
		 */
		GenericType<List<Customer>> genericType = new GenericType<List<Customer>>() {
		};
		List<Customer> customers = service.path("rest").path("Customers").accept(MediaType.APPLICATION_XML).get(genericType);

		for (Customer cust : customers) {
			System.out.println(cust);
		}

		/*
		 * Get customer by ID
		 */
		int id = 2;
		Customer customer = service.path("rest").path("Customers").path(String.valueOf(id)).accept(MediaType.APPLICATION_XML).get(Customer.class);
		System.out.println("Customer with ID = " + id);
		System.out.println(customer);

		/*
		 * Update customer
		 */

		Email mail = new Email();
		mail.setEmailAddress("qweerrty@mail.ru");
		customer.setEmail(mail);
		customer.setFirstName("Mike");
		customer.setId(2);
		customer.setLastName("Jordan");
		Phone phone = new Phone();
		phone.setPhoneNumber("1326754654");
		customer.setPhone(phone);
		System.out.println("update customer with ID = " + id);
		service.path("rest").path("Customers").post(customer);
		customer = service.path("rest").path("Customers").path(String.valueOf(id)).accept(MediaType.APPLICATION_XML).get(Customer.class);
		System.out.println("Customer with ID = " + id);
		System.out.println(customer);

		/*
		 * Delete customer
		 */
		System.out.println("delete customer with ID = " + id);
		service.path("rest").path("Customers").path(String.valueOf(id)).delete();
		customers = service.path("rest").path("Customers").accept(MediaType.APPLICATION_XML).get(genericType);

		for (Customer cust : customers) {
			System.out.println(cust);
		}

		/*
		 * Put customer
		 */

		System.out.println("putting customer");
		customer = new Customer();
		mail = new Email();
		mail.setEmailAddress("mnnvxcv@mail.ru");
		customer.setEmail(mail);
		customer.setFirstName("Bin");
		customer.setId(4);
		customer.setLastName("Oliver");
		phone = new Phone();
		phone.setPhoneNumber("09988766");
		customer.setPhone(phone);
		service.path("rest").path("Customers").accept(MediaType.APPLICATION_XHTML_XML).put(customer);

		customers = service.path("rest").path("Customers").accept(MediaType.APPLICATION_XML).get(genericType);

		for (Customer cust : customers) {
			System.out.println(cust);
		}

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:9090/REST").build();
	}

}
