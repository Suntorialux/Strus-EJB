/**
 * 
 */
package com.epam.by.ejb;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.by.DAO.ReservationDAO;
import com.epam.by.entities.Reservation;

/**
 * @author Andrei Yahorau
 *
 */
public class ReservationRetrieveTest {
	@InjectMocks
	private ReservationRetrieveImpl reservationRetrieve;
	@Mock
	private ReservationDAO reservationDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void retrieveReservation_Expected_Return_Reservation_From_DAO() throws SQLException {

		Reservation expReservation = new Reservation();
		// Act
		Mockito.doReturn(expReservation).when(reservationDAO).getReservation();
		Reservation actReservation = reservationRetrieve.retrieve();
		// Assert
		assertThat(actReservation, is(equalTo(expReservation)));
	}

	@Test
	public void retrieveReservation_Expected_Not_Null_ResComponents_Should_Be_Added_To_Reservation() {

		Reservation expReservation = new Reservation();
		// Act
		Mockito.doReturn(expReservation).when(reservationDAO).getReservation();
		Reservation actReservation = reservationRetrieve.retrieve();
		// Assert
		assertThat(actReservation.getResComponents(), CoreMatchers.notNullValue());
	}

	@Test
	public void retrieveReservation_Expected_Call_DAO() throws SQLException {

		// Act
		Mockito.doReturn(new Reservation()).when(reservationDAO).getReservation();
		reservationRetrieve.retrieve();
		// Assert
		Mockito.verify(reservationDAO, Mockito.times(1)).getReservation();
	}

	@Test
	public void retrieveReservation_Expected_Not_Null_List_Customers_Should_Be_Added_To_Reservation() {

		Reservation expReservation = new Reservation();
		// Act
		Mockito.doReturn(expReservation).when(reservationDAO).getReservation();
		Reservation actReservation = reservationRetrieve.retrieve();
		// Assert
		assertThat(actReservation.getCustomers(), CoreMatchers.notNullValue());
	}

}
