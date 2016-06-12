/**
 * 
 */
package com.epam.by.ejb;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.epam.by.DAO.ReservationDAO;
import com.epam.by.entities.Reservation;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
public class ReservationRetrieveImpl implements SessionBean {

	private ReservationDAO reservationDAO;

	public Reservation retrieve() {
		Reservation reservation = reservationDAO.getReservation();

		return reservation;
	}

	public void ejbCreate() {
	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {

	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {

	}

}
