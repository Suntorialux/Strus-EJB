/**
 * 
 */
package com.epam.by.DAO;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.epam.by.entities.Reservation;

/**
 * @author Andrei Yahorau
 *
 */
public class ReservationDAO {

	private final String FILE_NAME = "Reservations.xml";

	public Reservation getReservation() {

		Reservation reservation = new Reservation();
		File file = new File(FILE_NAME);
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Reservation.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			reservation = (Reservation) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return reservation;
	}

}
