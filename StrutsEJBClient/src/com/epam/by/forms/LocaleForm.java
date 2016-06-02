/**
 * 
 */
package com.epam.by.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
public class LocaleForm extends ActionForm {

	private String language;

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
}
