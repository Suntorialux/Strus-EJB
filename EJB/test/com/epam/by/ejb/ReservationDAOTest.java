/**
 * 
 */
package com.epam.by.ejb;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.epam.by.DAO.ReservationDAO;

/**
 * @author Andrei Yahorau
 *
 */
public class ReservationDAOTest {

	@InjectMocks
	private ReservationDAO reservationDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void expected_get_reservation_from_DAO() {

		// Act
		String expCode = reservationDAO.getReservation().getCode();

		// Assert
		Assert.assertThat(expCode, CoreMatchers.notNullValue());
	}

}
