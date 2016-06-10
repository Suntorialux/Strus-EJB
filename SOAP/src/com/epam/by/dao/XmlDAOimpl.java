/**
 * 
 */
package com.epam.by.dao;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.epam.by.entity.Customers;
import com.epam.by.entity.Customers.Customer;

/**
 * @author Andrei Yahorau
 *
 */
public class XmlDAOimpl implements IDAO {

	@Override
	public Customers getAllCustomers() {
		Customers customers = getCustomers();
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		List<Customer> customers = getCustomers().getListCustomers();
		for (Customer cust : customers) {
			if (cust.getId() == id) {
				customer = cust;
			}
		}
		return customer;
	}

	@Override
	public void addCustomer(Customer customer) {
		List<Customer> listCustomers = getCustomers().getListCustomers();
		listCustomers.add(customer);
		Customers customers = new Customers();
		customers.setListCustomers(listCustomers);
		setCustomers(customers);
	}

	@Override
	public void updateCustomer(Customer customer) {
		List<Customer> customers = getCustomers().getListCustomers();
		for (Customer cust : customers) {
			if (cust.getId() == customer.getId()) {
				cust.setFirstName(customer.getFirstName());
				cust.setLastName(customer.getLastName());
				cust.setEmail(customer.getEmail());
				cust.setPhone(customer.getPhone());
			}
		}
		Customers custom = new Customers();
		custom.setListCustomers(customers);
		setCustomers(custom);
	}

	@Override
	public void deleteCustomer(int id) {
		List<Customer> listCustomers = getCustomers().getListCustomers();
		Iterator<Customer> iterator = listCustomers.iterator();
		while (iterator.hasNext()) {
			Customer cust = iterator.next();
			if (cust.getId() == id) {
				iterator.remove();
			}
		}
		Customers customers = new Customers();
		customers.setListCustomers(listCustomers);
		setCustomers(customers);
	}

	private Customers getCustomers() {
		try {
			Parser parser = new JaxbParser();
			File file = new File("d:\\reservation.xml");
			Customers customers = (Customers) parser.getObject(file, Customers.class);
			return customers;
		} catch (JAXBException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	private void setCustomers(Customers customers) {
		try {
			Parser parser = new JaxbParser();
			File file = new File("d:\\reservation.xml");
			parser.saveObject(file, customers);
		} catch (JAXBException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

	}

}
