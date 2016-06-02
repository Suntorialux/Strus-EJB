/**
 * 
 */
package com.epam.by.tags;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.epam.by.ejb.ReservationPOJO;
import com.epam.by.ejb.ReservationPOJO.Customer;
import com.epam.by.ejb.ReservationPOJO.FareFamily;
import com.epam.by.homeIfaces.ReservationHome;
import com.epam.by.remoteIfaces.Reservation;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
public class ReservationTag extends TagSupport {

	private String component;

	public void setComponent(String component) {
		this.component = component;
	}

	@Override
	public int doStartTag() throws JspException {

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		ServletContext context = request.getSession().getServletContext();
		String fileName = context.getRealPath("/WEB-INF/" + "Reservations.xml");

		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");

		InitialContext jndiContext;
		try {
			jndiContext = new InitialContext(properties);
			Object ref = jndiContext.lookup("Reservation");
			ReservationHome home = (ReservationHome) PortableRemoteObject.narrow(ref, ReservationHome.class);
			Reservation reservation = home.create();
			ReservationPOJO ob = reservation.getReservation(fileName);

			switch (component) {
			case "reservation": {
				pageContext.setAttribute("reservation", ob);
				break;
			}
			case "customer": {
				List<Customer> customers = ob.getCustomers();
				pageContext.setAttribute("customers", customers);
			}
			case "fareFamily": {
				List<FareFamily> fareFamilies = ob.getFareFamilies();
				pageContext.setAttribute("fareFamilies", fareFamilies);
			}

			}
		} catch (NamingException | RemoteException | CreateException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {

		return EVAL_PAGE;
	}

}
