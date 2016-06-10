/**
 * 
 */
package com.epam.by.service.impl;

import javax.jws.WebService;

import com.epam.by.dao.DAOFactory;
import com.epam.by.dao.IDAO;
import com.epam.by.entity.Customers;
import com.epam.by.entity.Customers.Customer;
import com.epam.by.service.CustomerService;

/**
 * @author Andrei Yahorau
 *
 */
@WebService(endpointInterface = "com.epam.by.service.CustomerService")
public class CustomerServiceImplementation implements CustomerService {

	private IDAO iDAO = DAOFactory.getInstance();

	@Override
	public Customers getAllCustomers() {
		Customers customers = iDAO.getAllCustomers();
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = iDAO.getCustomerById(id);
		return customer;
	}

	@Override
	public void addCustomer(Customer customer) {
		iDAO.addCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		iDAO.deleteCustomer(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		iDAO.updateCustomer(customer);
	}

}
