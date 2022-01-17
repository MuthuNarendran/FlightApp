package com.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
 List<Booking> findByEmailId(String emailId);
 List<Booking> findByAirlineName(String airlineName);
}
