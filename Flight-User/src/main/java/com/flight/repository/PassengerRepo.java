package com.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.Booking;
import com.flight.entity.passengers;

public interface PassengerRepo extends JpaRepository<passengers,Integer> {

}
