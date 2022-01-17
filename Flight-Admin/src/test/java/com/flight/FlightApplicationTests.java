package com.flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flight.entity.Airline;
import com.flight.entity.Flight;
import com.flight.exception.InvalidFlightException;
import com.flight.repository.AirlineRepo;
import com.flight.repository.FlightRepo;
import com.flight.service.AirlineService;
import com.flight.service.FlightService;

@SpringBootTest
class FlightApplicationTests {
	
	@MockBean
	private AirlineRepo airlineRepo;
	
	@MockBean
	private FlightRepo flightRepo;
	
	@Autowired
	private AirlineService airlineService;
	
	@Autowired
	private FlightService flightService;

	@Test
	public void shouldFindAnAirline() throws InvalidFlightException {
		String name = "Air india";
		Airline airline = new Airline("Air India", "operational");
		Mockito.when(airlineRepo.findById(name)).thenReturn(Optional.of(airline));
		
		Airline airlineObj = airlineService.getAirlineByName(name);
		Assertions.assertNotNull(airlineObj);
	}
	
	@Test
	public void shouldFindAllFlights(){
	Airline airline = new Airline("Air India", "operational");
	Airline airline2 = new Airline("Air Asia", "operational");
	List<String> businessSeatNumberLists =Arrays.asList("1A","1B");
	List<String> economySeatNumberLists =Arrays.asList("1E","1E");
	Flight f1 = new Flight(1, 10, airline, "Chennai", "Mumbai", "12-10-2021", "02:00", "03:00", "tuesday", 10, 11, businessSeatNumberLists,economySeatNumberLists,1111, "Veg");
	Flight f2 = new Flight(2, 10, airline2, "Chennai", "Kolkatta", "13-10-2021", "02:00", "03:00", "tuesday", 10, 11,businessSeatNumberLists,economySeatNumberLists, 1111, "Veg");
	List<Flight> flightLists = new ArrayList<>();
	flightLists.add(f1);
	flightLists.add(f2);
	Mockito.when(flightRepo.findAll()).thenReturn(flightLists);
	
	List<Flight> allFlightLists = flightService.getAllFlights();
	Assertions.assertNotNull(allFlightLists);
	}

}
