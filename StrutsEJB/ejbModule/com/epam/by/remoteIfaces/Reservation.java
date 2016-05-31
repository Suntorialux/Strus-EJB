/**
 * 
 */
package com.epam.by.remoteIfaces;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import com.epam.by.ejb.ReservationBean.Customer;
import com.epam.by.ejb.ReservationBean.FareFamily;

/**
 * @author Andrei Yahorau
 *
 */
public interface Reservation extends EJBObject {

	public Customer getCustomer() throws RemoteException;

	public FareFamily getFareFamily() throws RemoteException;
}
