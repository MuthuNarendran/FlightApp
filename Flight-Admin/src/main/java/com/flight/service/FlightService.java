package com.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.entity.Flight;
import com.flight.exception.InvalidFlightException;
import com.flight.model.SeatupdateRequest;
import com.flight.repository.FlightRepo;

@Service
public class FlightService {

	@Autowired
	private FlightRepo flightRepo;
	
	
	public List<Flight> getAllFlights(){
		return flightRepo.findAll();
	}
	
	public Flight getFlightById(int id) throws InvalidFlightException {
		Optional<Flight> flightLists= flightRepo.findById(id);
		if(flightLists.isEmpty()) {
			throw new InvalidFlightException("There are no flights available for this id");
		}
		else {
		return flightLists.get();
		}
	}
	
	public Flight saveFlights(Flight flight) {
		return flightRepo.save(flight);
		
	}
	
	public void updateFlightSeats(SeatupdateRequest request) {
		 flightRepo.updateSeats(request.getId(),request.getBusinessSeats(),request.getEconomySeats());
	}
	
}
