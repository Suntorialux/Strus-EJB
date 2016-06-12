/**
 * 
 */
package com.epam.by.remoteIfaces;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import com.epam.by.entities.Reservation;

/**
 * @author Andrei Yahorau
 *
 */
public interface ReservationRetrieve extends EJBObject {

	public Reservation retrieve() throws RemoteException;

}
