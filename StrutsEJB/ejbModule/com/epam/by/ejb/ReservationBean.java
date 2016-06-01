/**
 * 
 */
package com.epam.by.ejb;

import java.io.File;
import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
public class ReservationBean implements SessionBean {

	public ReservationPOJO getReservation(String fileName) {

		ReservationPOJO reservation = new ReservationPOJO();
		File file = new File(fileName);
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ReservationPOJO.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			reservation = (ReservationPOJO) jaxbUnmarshaller.unmarshal(file);
			System.out.println("EJB " + reservation);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reservation;
	}

	public void ejbCreate() {

	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

}
