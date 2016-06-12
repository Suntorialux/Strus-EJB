/**
 * 
 */
package com.epam.by.homeIfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import com.epam.by.remoteIfaces.ReservationRetrieve;

/**
 * @author Andrei Yahorau
 *
 */
public interface ReservationRetrieveHome extends EJBHome {

	ReservationRetrieve create() throws RemoteException, CreateException;
}
