/**
 * 
 */
package com.epam.by.remoteIfaces;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import com.epam.by.ejb.ReservationPOJO;

/**
 * @author Andrei Yahorau
 *
 */
public interface Reservation extends EJBObject {

	public ReservationPOJO getReservation(String fileName) throws RemoteException;

}
