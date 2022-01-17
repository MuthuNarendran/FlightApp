package com.flight.model;

public class UserSearchData {
	
	private String source;
	private String destination;
	private String depaturedate;
	private String returnDate;
	public UserSearchData(String source, String destination, String depaturedate, String returnDate) {
		super();
		this.source = source;
		this.destination = destination;
		this.depaturedate = depaturedate;
		this.returnDate = returnDate;
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
	public String getDepaturedate() {
		return depaturedate;
	}
	public void setDepaturedate(String depaturedate) {
		this.depaturedate = depaturedate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	

	

}
