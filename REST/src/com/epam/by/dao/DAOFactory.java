/**
 * 
 */
package com.epam.by.dao;

/**
 * @author Andrei Yahorau
 *
 */
public class DAOFactory {

	public static IDAO getInstance() {
		return new XmlDAOimpl();
	}

}
