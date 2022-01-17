//package com.flight.entity;
//
//import java.util.List;
//
//import javax.annotation.Generated;
//import javax.persistence.CascadeType;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//public class SeatNumber {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//private int id;
//	@ElementCollection
//private List<String> businessClassSeatNumber;
//	@ElementCollection
//private List<String> economyClassSeatNumber;
//@ManyToOne(cascade = CascadeType.ALL)
//@JoinColumn(name = "id")
//private Flight flight;
//public SeatNumber(int id, List<String> businessClassSeatNumber, List<String> economyClassSeatNumber, Flight flight) {
//	super();
//	this.id = id;
//	this.businessClassSeatNumber = businessClassSeatNumber;
//	this.economyClassSeatNumber = economyClassSeatNumber;
//	this.flight = flight;
//}
//public int getId() {
//	return id;
//}
//public void setId(int id) {
//	this.id = id;
//}
//public List<String> getBusinessClassSeatNumber() {
//	return businessClassSeatNumber;
//}
//public void setBusinessClassSeatNumber(List<String> businessClassSeatNumber) {
//	this.businessClassSeatNumber = businessClassSeatNumber;
//}
//public List<String> getEconomyClassSeatNumber() {
//	return economyClassSeatNumber;
//}
//public void setEconomyClassSeatNumber(List<String> economyClassSeatNumber) {
//	this.economyClassSeatNumber = economyClassSeatNumber;
//}
//public Flight getFlight() {
//	return flight;
//}
//public void setFlight(Flight flight) {
//	this.flight = flight;
//}
//
//
//}
