/**
 * 
 */
package com.epam.by.dao;

import java.util.List;

import com.epam.by.entity.Reservation.Customer;

/**
 * @author Andrei Yahorau
 *
 */
public interface IDAO {

	List<Customer> getAllCustomers();

	Customer getCustomerById(int id);

	void addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int id);

}
