/**
 * 
 */
package com.epam.by.actions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.epam.by.forms.LocaleForm;

/**
 * @author Andrei Yahorau
 *
 */
public class LocalAction extends Action {

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

		LocaleForm localeForm = (LocaleForm) form;
		String language = localeForm.getLanguage();
		if (language.equals("English")) {
			request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
		} else {
			setLocale(request, new Locale("ru"));
		}
		return mapping.findForward("success");
	}

}
