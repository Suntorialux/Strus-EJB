/**
 * 
 */
package com.epam.by.remoteIfaces;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

/**
 * @author Andrei Yahorau
 *
 */
public interface User extends EJBObject {

	public int getUserId() throws RemoteException;

	public String getLogin() throws RemoteException;
}
