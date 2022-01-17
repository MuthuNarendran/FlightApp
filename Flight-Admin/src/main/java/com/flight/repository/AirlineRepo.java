package com.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.Airline;
import com.flight.entity.Flight;

public interface AirlineRepo extends JpaRepository<Airline, String>{

}
