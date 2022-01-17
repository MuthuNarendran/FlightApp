package com.flight.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flight.entity.Flight;
import com.flight.exception.CustomErrorMessage;
import com.flight.exception.InvalidFlightException;

@ControllerAdvice
public class GlobalAdvice {

	@ExceptionHandler(InvalidFlightException.class)
	public ResponseEntity<CustomErrorMessage> handleFlightIdNotFoundException(Exception e){
		CustomErrorMessage exception = new CustomErrorMessage(e.getMessage(),LocalDateTime.now());
		return new ResponseEntity<CustomErrorMessage>(exception,HttpStatus.BAD_REQUEST);
	}
}
