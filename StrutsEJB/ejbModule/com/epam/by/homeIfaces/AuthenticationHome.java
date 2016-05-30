/**
 * 
 */
package com.epam.by.homeIfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import com.epam.by.remoteIfaces.Authentication;

/**
 * @author Andrei Yahorau
 *
 */
public interface AuthenticationHome extends EJBHome {

	Authentication create() throws RemoteException, CreateException;

}
