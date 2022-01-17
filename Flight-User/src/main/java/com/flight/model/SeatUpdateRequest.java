package com.flight.model;

import java.util.List;

import javax.persistence.ElementCollection;

public class SeatUpdateRequest {
private int businessSeats;
private int economySeats;
private List<String> businessClassSeatNumber;
private List<String> economyClassSeatNumber;
private int id;
public SeatUpdateRequest(int businessSeats, int economySeats, List<String> businessClassSeatNumber,
		List<String> economyClassSeatNumber, int id) {
	super();
	this.businessSeats = businessSeats;
	this.economySeats = economySeats;
	this.businessClassSeatNumber = businessClassSeatNumber;
	this.economyClassSeatNumber = economyClassSeatNumber;
	this.id = id;
}
public int getBusinessSeats() {
	return businessSeats;
}
public void setBusinessSeats(int businessSeats) {
	this.businessSeats = businessSeats;
}
public int getEconomySeats() {
	return economySeats;
}
public void setEconomySeats(int economySeats) {
	this.economySeats = economySeats;
}
public List<String> getBusinessClassSeatNumber() {
	return businessClassSeatNumber;
}
public void setBusinessClassSeatNumber(List<String> businessClassSeatNumber) {
	this.businessClassSeatNumber = businessClassSeatNumber;
}
public List<String> getEconomyClassSeatNumber() {
	return economyClassSeatNumber;
}
public void setEconomyClassSeatNumber(List<String> economyClassSeatNumber) {
	this.economyClassSeatNumber = economyClassSeatNumber;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
