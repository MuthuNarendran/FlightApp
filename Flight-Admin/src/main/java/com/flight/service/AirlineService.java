package com.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.flight.entity.Airline;
import com.flight.entity.Flight;
import com.flight.exception.InvalidFlightException;
import com.flight.repository.AirlineRepo;
import com.flight.repository.FlightRepo;

@Service
public class AirlineService {
	
	public static String Topic ="DemoTopic";

	@Autowired
	private AirlineRepo airlineRepo;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	public List<Airline> getAllFlightsFromInventory(){
		return airlineRepo.findAll();
	}
	
	public Airline saveAirlines(Airline airline) {
		return airlineRepo.save(airline);		
	}
	
	public Airline blockAirlines(Airline airline) {
		if (airline.getStatus().equalsIgnoreCase("Non-Operational"))
		kafkaTemplate.send(Topic, airline.getName());
		return airlineRepo.save(airline);
	}
	
	public Airline getAirlineByName(String name) throws InvalidFlightException { 
		Optional<Airline> airline = airlineRepo.findById(name);
		if (!airline.isPresent()) {
            throw new InvalidFlightException("There are no Airlines found in this name. Pls register this airline");
        }
		return airline.get();
	}
}
