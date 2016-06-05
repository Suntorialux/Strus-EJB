/**
 * 
 */
package com.epam.by.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.epam.by.dao.DAOFactory;
import com.epam.by.dao.IDAO;
import com.epam.by.entity.Reservation.Customer;

/**
 * @author Andrei Yahorau
 *
 */
@Path("Customers")
public class CustomerService {

	private IDAO iDAO = DAOFactory.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> getAllCustomers() {

		List<Customer> customers = iDAO.getAllCustomers();
		return customers;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomerById(@PathParam("id") int id) {
		Customer customer = iDAO.getCustomerById(id);
		return customer;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void addCustomer(JAXBElement<Customer> customer) {
		iDAO.addCustomer(customer.getValue());
	}

	@DELETE
	@Path("{id}")
	public void deleteCustomer(@PathParam("id") int id) {
		iDAO.deleteCustomer(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void updateCustomer(JAXBElement<Customer> customer) {
		iDAO.updateCustomer(customer.getValue());
	}

}
