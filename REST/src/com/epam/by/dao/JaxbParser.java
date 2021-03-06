/**
 * 
 */
package com.epam.by.dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author Andrei Yahorau
 *
 */
public class JaxbParser implements Parser {

	@Override
	public Object getObject(File file, Class<?> c) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(c);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object object = unmarshaller.unmarshal(file);
		return object;
	}

	@Override
	public void saveObject(File file, Object o) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(o.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(o, file);
	}

}
