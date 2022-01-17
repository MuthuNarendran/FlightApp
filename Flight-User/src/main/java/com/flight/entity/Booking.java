package com.flight.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Booking {
@Id
private int pnr;
private String name;
private int flightId;
private String airlineName;
private String depatureTime;
private String endTime;
private String date;
private String source;
private String destination;
private int businessSeat;
private int economySeat;
private String emailId;
@ElementCollection
private List<String> businessClassSeatNumber;
@ElementCollection
private List<String> economyClassSeatNumber;
@OneToMany(mappedBy ="booking" ,cascade = CascadeType.ALL )
private List<passengers> passenger;
public Booking() {}
public Booking(int pnr, String name, int flightId, String airlineName, String depatureTime, String endTime, String date,
		String source, String destination, int businessSeat, int economySeat, String emailId,
		List<String> businessClassSeatNumber, List<String> economyClassSeatNumber, List<passengers> passenger) {
	super();
	this.pnr = pnr;
	this.name = name;
	this.flightId = flightId;
	this.airlineName = airlineName;
	this.depatureTime = depatureTime;
	this.endTime = endTime;
	this.date = date;
	this.source = source;
	this.destination = destination;
	this.businessSeat = businessSeat;
	this.economySeat = economySeat;
	this.emailId = emailId;
	this.businessClassSeatNumber = businessClassSeatNumber;
	this.economyClassSeatNumber = economyClassSeatNumber;
	this.passenger = passenger;
}
public int getPnr() {
	return pnr;
}
public void setPnr(int pnr) {
	this.pnr = pnr;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getFlightId() {
	return flightId;
}
public void setFlightId(int flightId) {
	this.flightId = flightId;
}
public String getAirlineName() {
	return airlineName;
}
public void setAirlineName(String airlineName) {
	this.airlineName = airlineName;
}
public String getDepatureTime() {
	return depatureTime;
}
public void setDepatureTime(String depatureTime) {
	this.depatureTime = depatureTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public int getBusinessSeat() {
	return businessSeat;
}
public void setBusinessSeat(int businessSeat) {
	this.businessSeat = businessSeat;
}
public int getEconomySeat() {
	return economySeat;
}
public void setEconomySeat(int economySeat) {
	this.economySeat = economySeat;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
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
public List<passengers> getPassenger() {
	return passenger;
}
public void setPassenger(List<passengers> passenger) {
	this.passenger = passenger;
}



}
