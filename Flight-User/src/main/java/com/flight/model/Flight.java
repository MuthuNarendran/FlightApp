package com.flight.model;

import java.util.List;

import javax.persistence.ElementCollection;

public class Flight {


	private int id;
	private int number;
	private Airline airline;
	private String origin;
	private String destination;
	private String date;
	private String startTime;
	private String endTime;
	private String scheduledDays;
    private int businessSeats;
    private int economySeats;
    private List<String> businessClassSeatNumber;
    private List<String> economyClassSeatNumber;
    private int fare;
    private String meals;
	
	public Flight() {}

	public Flight(int id, int number, Airline airline, String origin, String destination, String date, String startTime,
			String endTime, String scheduledDays, int businessSeats, int economySeats,
			List<String> businessClassSeatNumber, List<String> economyClassSeatNumber, int fare, String meals) {
		super();
		this.id = id;
		this.number = number;
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.scheduledDays = scheduledDays;
		this.businessSeats = businessSeats;
		this.economySeats = economySeats;
		this.businessClassSeatNumber = businessClassSeatNumber;
		this.economyClassSeatNumber = economyClassSeatNumber;
		this.fare = fare;
		this.meals = meals;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getScheduledDays() {
		return scheduledDays;
	}

	public void setScheduledDays(String scheduledDays) {
		this.scheduledDays = scheduledDays;
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

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getMeals() {
		return meals;
	}

	public void setMeals(String meals) {
		this.meals = meals;
	}

	

	

}
