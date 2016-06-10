/**
 * 
 */
package com.epam.by.dao;

import java.io.File;

import javax.xml.bind.JAXBException;

/**
 * @author Andrei Yahorau
 *
 */
public interface Parser {

	Object getObject(File file, Class<?> c) throws JAXBException;

	void saveObject(File file, Object o) throws JAXBException;

}
