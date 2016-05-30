/**
 * 
 */
package com.epam.by.actions;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.epam.by.forms.LoginForm;
import com.epam.by.homeIfaces.AuthenticationHome;
import com.epam.by.remoteIfaces.Authentication;

/**
 * @author Andrei Yahorau
 *
 */
public class LoginAction extends Action {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		LoginForm loginForm = (LoginForm) form;
		ActionForward forward = mapping.getInputForward();
		String login = loginForm.getLogin();
		String password = loginForm.getPassword();

		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.PROVIDER_URL, "localhost:1099");

		InitialContext jndiContext = new InitialContext(properties);
		Object ref = jndiContext.lookup("Authentication");

		AuthenticationHome home = (AuthenticationHome) PortableRemoteObject.narrow(ref, AuthenticationHome.class);

		Authentication authentication = home.create();

		if (authentication.isUserExist(login, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", login);
			forward = mapping.findForward("success");
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("login", new ActionMessage("reg.error.parameters.exists"));
			saveErrors(request, errors);
		}

		return forward;
	}

}
