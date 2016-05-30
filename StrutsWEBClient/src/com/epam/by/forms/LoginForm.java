/**
 * 
 */
package com.epam.by.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
public class LoginForm extends ActionForm {

	/** The login of user */
	private String login = null;
	/** The password of user */
	private String password = null;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action.
	 * ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if (login == null || login.trim().isEmpty()) {
			errors.add("login", new ActionMessage("reg.error.login.missing"));
		}
		if (password == null || password.trim().isEmpty()) {
			errors.add("password", new ActionMessage("reg.error.password.missing"));
		}
		return errors;
	}

}
