package com.flight.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.entity.Flight;
import com.flight.model.SeatupdateRequest;


@Repository
@Transactional
public interface FlightRepo extends JpaRepository<Flight, Integer>{
	@Modifying(clearAutomatically = true)
	@Query(value="update flight u set u.business_seats= :businessSeats , u.economy_seats= :economySeats where u.id= :id" , nativeQuery = true)
   void updateSeats(@Param("id") int id ,@Param("businessSeats") int businessSeats,@Param("economySeats") int economySeats );
}
