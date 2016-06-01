/**
 * 
 */
package com.epam.by.tags;

import java.rmi.RemoteException;
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
import com.epam.by.homeIfaces.ReservationHome;
import com.epam.by.remoteIfaces.Reservation;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
public class ReservationTag extends TagSupport {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
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
			System.out.println(ob.toString());
			pageContext.setAttribute("reservation", ob);
		} catch (NamingException | RemoteException | CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {

		return EVAL_PAGE;
	}

}
