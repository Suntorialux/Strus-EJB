package com.epam.by.remoteIfaces;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

/**
 * @author Andrei Yahorau
 *
 */
public interface Authentication extends EJBObject {

	public boolean isUserExist(String login, String password) throws RemoteException;

}
