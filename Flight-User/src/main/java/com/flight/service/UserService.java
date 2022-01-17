package com.flight.service;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.flight.entity.Booking;
import com.flight.entity.passengers;
import com.flight.exception.InvalidFlightException;
import com.flight.model.BookingModelData;
import com.flight.model.Flight;
import com.flight.model.SeatUpdateRequest;
import com.flight.model.UserSearchData;
import com.flight.repository.BookingRepo;
import com.flight.repository.PassengerRepo;

@Service
public class UserService {

	@Autowired
	private BookingRepo bookingRepo;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private PassengerRepo passengerRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	List<Flight> finalSearchLists ;

	public List<Flight> searchFlights(List<Flight> flightLists, UserSearchData userSearchData) {
		finalSearchLists = new ArrayList<>();
		List<Flight> SearchListsOnDepatureDate= flightLists.stream()
				.filter(flight -> flight.getAirline().getStatus().equalsIgnoreCase("operational")
						&& userSearchData.getDepaturedate().equalsIgnoreCase(flight.getDate())
						&& userSearchData.getSource().equalsIgnoreCase(flight.getOrigin())
						&& userSearchData.getDestination().equalsIgnoreCase(flight.getDestination()))
				.collect(Collectors.toList());

		List<Flight> SearchListsOnReturnDate = flightLists.stream()
				.filter(flight -> flight.getAirline().getStatus().equalsIgnoreCase("operational")
						&& userSearchData.getReturnDate().equalsIgnoreCase(flight.getDate())
						&& userSearchData.getDestination().equalsIgnoreCase(flight.getOrigin())
						&& userSearchData.getSource().equalsIgnoreCase(flight.getDestination()))
				.collect(Collectors.toList());
		finalSearchLists.addAll(SearchListsOnDepatureDate);
		finalSearchLists.addAll(SearchListsOnReturnDate);
		return finalSearchLists;
	}

	public Booking bookTickets(int id, BookingModelData bookingData) throws InvalidFlightException {
		Random random = new Random();
		int pnr = random.nextInt(1000);
		int detectBusinessSeatCount = 0;
		int detectEconomySeatCount = 0;
		Flight flight =null;
		

		for(int i=0;i<finalSearchLists.size();i++) {
				if(finalSearchLists.get(i).getId()==id) flight =finalSearchLists.get(i);
		}
		
		if(flight==null) throw new InvalidFlightException("This flight Id is not found in the saerch results");
//		String url = "http://localhost:8989/api/v1.0/admin/flight/" + id;
//		Flight flight = restTemplate.getForObject(url, Flight.class);

//		passengers passenger = new passengers();
//		passenger.setId(bookingData.pass());
//		passenger.setName(bookingData.getName());
//		passenger.setGender(bookingData.getGender());

//		List<passengers> passengerLists = 

		Booking booking = new Booking();
		booking.setPnr(pnr);
		booking.setFlightId(id);
		booking.setAirlineName(flight.getAirline().getName());
		booking.setDepatureTime(flight.getStartTime());
		booking.setEndTime(flight.getEndTime());
		booking.setSource(flight.getOrigin());
		booking.setDestination(flight.getDestination());
		booking.setDate(flight.getDate());
		booking.setEmailId(bookingData.getEmailId());
		booking.setName(bookingData.getName());
		booking.setPassenger(bookingData.getPassengers());
		booking.setBusinessClassSeatNumber(bookingData.getBusinessClassSeatNumber());
		booking.setEconomyClassSeatNumber(bookingData.getEconomyClassSeatNumber());
		

		if (bookingData.getEconomySeats() > flight.getEconomySeats()) {
			throw new InvalidFlightException("The requested Economy Class Seats are not available");
		} else {
			booking.setEconomySeat(bookingData.getEconomySeats());
			detectEconomySeatCount = flight.getEconomySeats() - bookingData.getEconomySeats();
		}

		if (bookingData.getBusinessSeats() > flight.getBusinessSeats()) {
			throw new InvalidFlightException("The requested Business Class Seats are not available");
		}

		else {
			booking.setBusinessSeat(bookingData.getBusinessSeats());
			detectBusinessSeatCount = flight.getBusinessSeats() - bookingData.getBusinessSeats();
		}
		
		System.out.println(detectEconomySeatCount+" "+detectBusinessSeatCount);
		
		detectSeatsFromFlightInventory(detectEconomySeatCount,detectBusinessSeatCount,bookingData.getBusinessClassSeatNumber(),bookingData.getEconomyClassSeatNumber(),id);
		for(int i=0;i<bookingData.getPassengers().size();i++){
		bookingData.getPassengers().get(i).setBooking(booking);
		}
		return bookingRepo.save(booking);
	}

	public Booking getTicketsByPnr(int pnr) throws InvalidFlightException {
		Optional<Booking> bookings = bookingRepo.findById(pnr);
		if (bookings.isEmpty()) {
			throw new InvalidFlightException("There are no booking details available for this pnr");
		} else {
			return bookings.get();
		}
	}

	public List<Booking> getBookingHistoryByPnr(String emailId) {
		return bookingRepo.findByEmailId(emailId);
	}

	public void cancelTicketByPnr(int pnr) throws InvalidFlightException, ParseException {
		Booking booking = getTicketsByPnr(pnr);
		if(booking==null) throw new InvalidFlightException("Invalid PNR Number");
		String url = "http://localhost:8989/api/v1.0/admin/flight/" + booking.getFlightId();
		Flight flight = restTemplate.getForObject(url, Flight.class);
		if (checkIfUserIsCancellingBefore24hrs(booking)) {
			detectSeatsFromFlightInventory(flight.getEconomySeats() + booking.getEconomySeat(),
					flight.getBusinessSeats() + booking.getBusinessSeat(),booking.getBusinessClassSeatNumber(),booking.getEconomyClassSeatNumber(), booking.getFlightId());
			bookingRepo.deleteById(pnr);
		} else
			throw new InvalidFlightException("Cancellation can be done only before 24 hrs from the journey time");
	}
	
	public void detectSeatsFromFlightInventory(int detectEconomySeatCount,int detectBusinessSeatCount,List<String> businessClassSeatnumbers,List<String> economyClassSeatNumbers,int id) {
		String url = "http://localhost:8989/api/v1.0/admin/flight/updateSeats";
		SeatUpdateRequest request = new SeatUpdateRequest(detectBusinessSeatCount, detectEconomySeatCount,businessClassSeatnumbers,economyClassSeatNumbers,id);
		restTemplate.put(url, request);
		System.out.println("ki");
	}
	
	public boolean checkIfUserIsCancellingBefore24hrs(Booking booking) throws InvalidFlightException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate today = LocalDate.now();

		LocalDate date1 = LocalDate.parse(booking.getDate(), formatter);
		LocalDate returnvalue = date1.minusDays(1);

		if (returnvalue.equals(today)) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
			String str[] = sdf1.format(new Date()).split(":");
			int time = Integer.parseInt(str[0]);
			String[] depatureTime = booking.getDepatureTime().split(":");
			if (time <= Integer.parseInt(depatureTime[0])) {
				return true;
			} else
				return false;
		} else if (today.isBefore(returnvalue))
			return true;
		else
			return false;

	}
	
	public void sendMessageToUserForBlockedBookings(String airlineName) {
	  List<Booking> bookingLists =  bookingRepo.findByAirlineName(airlineName);
	  for(Booking book: bookingLists) {
		 sendMail(book.getEmailId(),book);
	  }	
	}
	
	public void sendMail(String emailId,Booking booking) {
		SimpleMailMessage mailMsg = new SimpleMailMessage();
		mailMsg.setTo(emailId);
		mailMsg.setFrom("narendranmuthu07@gmail.com");
		mailMsg.setSubject("Regarding your flight Booking");
		mailMsg.setText("Dear Passenger,  We are sorry to inform that your flight Booking for PNR  "+booking.getPnr()+"has been cancelled and the amount will be refunded in 7 days");
		javaMailSender.send(mailMsg);
	}

}
