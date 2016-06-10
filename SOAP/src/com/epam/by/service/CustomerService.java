/**
 * 
 */
package com.epam.by.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.epam.by.entity.Customers;
import com.epam.by.entity.Customers.Customer;

/**
 * @author Andrei Yahorau
 *
 */
@WebService
public interface CustomerService {

	@WebMethod
	public Customers getAllCustomers();

	@WebMethod
	public Customer getCustomerById(int id);

	@WebMethod
	public void addCustomer(Customer customer);

	@WebMethod
	public void deleteCustomer(int id);

	@WebMethod
	public void updateCustomer(Customer customer);

}
