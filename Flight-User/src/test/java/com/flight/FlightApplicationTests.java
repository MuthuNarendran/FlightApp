package com.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flight.entity.Booking;
import com.flight.entity.passengers;
import com.flight.exception.InvalidFlightException;
import com.flight.model.Airline;
import com.flight.model.Flight;
import com.flight.repository.BookingRepo;
import com.flight.service.UserService;


@SpringBootTest
class FlightApplicationTests {
	@MockBean
	private BookingRepo bookingRepo;
	
	@Autowired
	private UserService userService;

	@Test
	public void shouldGetBookingHistory() throws InvalidFlightException {
		String emailId = "abc@gmail.com";
		Booking booking = new Booking();
		booking.setAirlineName("Indigo");
		booking.setBusinessSeat(1);
		booking.setDate("25-12-2021");
		booking.setDepatureTime("20:00");
		booking.setDestination("Madurai");
		booking.setEconomySeat(1);
		booking.setEmailId("abc@gmail.com");
		booking.setEndTime("21:00");
		booking.setFlightId(2);
		booking.setName("Muthu");
		booking.setPnr(202);
		booking.setSource("Chennai");
		booking.setPassenger(List.of(new passengers(1, "muthu", "male", booking)));
		List<Booking> bookingLists = List.of(booking);
		Mockito.when(bookingRepo.findByEmailId(emailId)).thenReturn((bookingLists));
		
		List<Booking> bookingListsFinal = userService.getBookingHistoryByPnr(emailId);
		Assertions.assertNotNull(bookingListsFinal);
	}
	
	@Test
	public void shouldGetTicketsByPnr() throws InvalidFlightException {
		int pnr = 502;
		Booking booking = new Booking();
		booking.setAirlineName("Air Asia");
		booking.setBusinessSeat(1);
		booking.setDate("25-12-2021");
		booking.setDepatureTime("20:00");
		booking.setDestination("Madurai");
		booking.setEconomySeat(1);
		booking.setEmailId("abc@gmail.com");
		booking.setEndTime("21:00");
		booking.setFlightId(2);
		booking.setName("Muthu");
		booking.setPnr(202);
		booking.setSource("Chennai");
		booking.setPassenger(List.of(new passengers(1, "muthu", "male", booking)));
		Mockito.when(bookingRepo.findById(pnr)).thenReturn(Optional.of(booking));
		
		Booking booking1= userService.getTicketsByPnr(pnr);
		Assertions.assertNotNull(booking1);
	}
	
}
