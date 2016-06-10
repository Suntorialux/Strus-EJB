/**
 * 
 */
package com.epam.by.dao;

import com.epam.by.entity.Customers;
import com.epam.by.entity.Customers.Customer;

/**
 * @author Andrei Yahorau
 *
 */
public interface IDAO {

	Customers getAllCustomers();

	Customer getCustomerById(int id);

	void addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int id);

}
