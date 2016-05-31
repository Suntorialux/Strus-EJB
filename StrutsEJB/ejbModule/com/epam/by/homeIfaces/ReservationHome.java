/**
 * 
 */
package com.epam.by.homeIfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import com.epam.by.remoteIfaces.Reservation;

/**
 * @author Andrei Yahorau
 *
 */
public interface ReservationHome extends EJBHome {

	Reservation create() throws RemoteException, CreateException;
}
