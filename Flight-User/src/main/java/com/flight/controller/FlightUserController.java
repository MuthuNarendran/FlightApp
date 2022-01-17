package com.flight.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flight.entity.Booking;
import com.flight.exception.InvalidFlightException;
import com.flight.model.BookingModelData;
import com.flight.model.Flight;
import com.flight.model.UserSearchData;
import com.flight.service.UserService;

@RestController
@RequestMapping("/flight")
public class FlightUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/search")
	public ResponseEntity<List<Flight>> searchFlights(@RequestBody UserSearchData userSearchData) {
		String url = "http://localhost:8989/api/v1.0/admin/flight/";
		HttpMethod method = HttpMethod.GET;
		RequestEntity<?> requestEntity = null;
		ResponseEntity<List<Flight>> restTemplateRes = restTemplate.exchange(url, method, requestEntity,
				new ParameterizedTypeReference<List<Flight>>() {
				});
		List<Flight> flightLists = restTemplateRes.getBody();
		return new ResponseEntity<>(userService.searchFlights(flightLists, userSearchData), HttpStatus.OK);
	}

	@PostMapping("/booking/{flightId}")
	public Booking bookTickets(@PathVariable int flightId,@RequestBody BookingModelData bookingData) throws InvalidFlightException {
		 return userService.bookTickets(flightId,bookingData);
	}

	@GetMapping("/ticket/{pnr}")
	public Booking getTicketsByPnr(@PathVariable int pnr) throws InvalidFlightException {
         return userService.getTicketsByPnr(pnr);
	}

	@GetMapping("/booking/history/{emailId}")
	public List<Booking> getBookingHistoryByEmailId(@PathVariable String emailId) {
		 return userService.getBookingHistoryByPnr(emailId);
	}

	@DeleteMapping("/booking/cancel/{pnr}")
	public void cancelTicketByPnr(@PathVariable int pnr) throws InvalidFlightException, ParseException {
		userService.cancelTicketByPnr(pnr);
	}
}