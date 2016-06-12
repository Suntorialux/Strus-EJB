/**
 * 
 */
package com.epam.by.ejb;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
public class AuthenticationImpl implements SessionBean {

	private static Map<String, String> users;

	static {

		users = new HashMap<String, String>();
		users.put("sysadmin", "111");
		users.put("clever", "111");
		users.put("ternal", "111");
		users.put("user", "user");

	}

	public boolean isUserExist(String login, String password) {
		for (Map.Entry<String, String> user : users.entrySet()) {
			if (user.getKey().equals(login) && user.getValue().equals(password)) {
				return true;
			}
		}

		return false;
	}

	public void ejbCreate() {

	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {

	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {

	}

}
