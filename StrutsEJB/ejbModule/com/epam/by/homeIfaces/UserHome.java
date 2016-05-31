/**
 * 
 */
package com.epam.by.homeIfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;

import com.epam.by.ejb.UserPK;
import com.epam.by.remoteIfaces.User;

/**
 * @author Andrei Yahorau
 *
 */
public interface UserHome extends EJBHome {

	public User create(String login, String password) throws RemoteException, CreateException;

	public User findByPrimaryKey(UserPK userPk) throws RemoteException, FinderException;

	public boolean isUserExist(String login, String password) throws RemoteException, FinderException;

}
