package com.flight.model;

import java.util.List;

import javax.persistence.ElementCollection;

import com.flight.entity.passengers;

public class BookingModelData {
	private String name;
	private String emailId;
	private List<passengers> passengers;
	private int economySeats;
	private int businessSeats;
    private List<String> businessClassSeatNumber;
    private List<String> economyClassSeatNumber;
	public BookingModelData(String name, String emailId, List<com.flight.entity.passengers> passengers,
			int economySeats, int businessSeats, List<String> businessClassSeatNumber,
			List<String> economyClassSeatNumber) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.passengers = passengers;
		this.economySeats = economySeats;
		this.businessSeats = businessSeats;
		this.businessClassSeatNumber = businessClassSeatNumber;
		this.economyClassSeatNumber = economyClassSeatNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<passengers> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<passengers> passengers) {
		this.passengers = passengers;
	}
	public int getEconomySeats() {
		return economySeats;
	}
	public void setEconomySeats(int economySeats) {
		this.economySeats = economySeats;
	}
	public int getBusinessSeats() {
		return businessSeats;
	}
	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
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
	
	

}
