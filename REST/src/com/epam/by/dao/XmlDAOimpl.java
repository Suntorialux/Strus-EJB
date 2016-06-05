/**
 * 
 */
package com.epam.by.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.epam.by.entity.Reservation;
import com.epam.by.entity.Reservation.Customer;

/**
 * @author Andrei Yahorau
 *
 */
public class XmlDAOimpl implements IDAO {

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = getReservation().getCustomers();
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		List<Customer> customers = getReservation().getCustomers();
		for (Customer cust : customers) {
			if (cust.getId() == id) {
				customer = cust;
			}
		}
		return customer;
	}

	@Override
	public void addCustomer(Customer customer) {
		List<Customer> customers = getReservation().getCustomers();
		customers.add(customer);
		Reservation reservation = new Reservation();
		reservation.setCustomers(customers);
		setReservation(reservation);
	}

	@Override
	public void updateCustomer(Customer customer) {
		List<Customer> customers = getReservation().getCustomers();
		for (Customer cust : customers) {
			if (cust.getId() == customer.getId()) {
				cust.setFirstName(customer.getFirstName());
				cust.setLastName(customer.getLastName());
				cust.setEmail(customer.getEmail());
				cust.setPhone(customer.getPhone());
			}
		}
		Reservation reservation = new Reservation();
		reservation.setCustomers(customers);
		setReservation(reservation);
	}

	@Override
	public void deleteCustomer(int id) {
		List<Customer> customers = getReservation().getCustomers();
		for (Customer cust : customers) {
			if (cust.getId() == id) {
				customers.remove(cust);
			}
		}
		Reservation reservation = new Reservation();
		reservation.setCustomers(customers);
		setReservation(reservation);
	}

	private Reservation getReservation() {
		try {
			Parser parser = new JaxbParser();
			File file = new File("d:\\reservation.xml");
			Reservation reservation = (Reservation) parser.getObject(file, Reservation.class);
			return reservation;
		} catch (JAXBException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	private void setReservation(Reservation reservation) {
		try {
			Parser parser = new JaxbParser();
			File file = new File("d:\\reservation.xml");
			parser.saveObject(file, reservation);
		} catch (JAXBException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

	}

}
