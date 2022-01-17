package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.entity.Airline;
import com.flight.entity.Flight;
import com.flight.exception.InvalidFlightException;
import com.flight.model.SeatupdateRequest;
import com.flight.service.AirlineService;
import com.flight.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightAdminController {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private AirlineService airlineService;
	
	@PostMapping("/airline/inventory/add")
	public Flight AddFlightsToInventory(@RequestBody Flight flight) throws InvalidFlightException {
		Airline airline = getAirlineByName(flight.getAirline().getName());
	    flight.setAirline(airline);
		return flightService.saveFlights(flight);
	}
	
	@GetMapping("")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	@GetMapping("/{id}")
	public Flight getFlightById(@PathVariable int id) throws InvalidFlightException {
		return flightService.getFlightById(id);
	}
	
	@PutMapping("/updateSeats")
	public void updateFlightSeatCounts(@RequestBody SeatupdateRequest request) {
		 flightService.updateFlightSeats(request);
	}

	@PostMapping("/airline/register")
	public Airline saveFlights(@RequestBody Airline airline) {
		return airlineService.saveAirlines(airline);
	}
	
	@GetMapping("/airline/{name}")
	public Airline getAirlineByName(String name) throws InvalidFlightException  {
		return airlineService.getAirlineByName(name);
	}
	
	@PutMapping("/airline/register")
	public Airline updateFlights(@RequestBody Airline airline) {
		return airlineService.blockAirlines(airline);
	}
	
	

}