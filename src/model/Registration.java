package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Registration 
{
	
	
	private Companion companion;
	private Hotel hotel;
	private Conference conference;
	private ArrayList<Excursion> excursions = new ArrayList<>();
	private ArrayList<HotelService> hotelServices = new ArrayList<>();
	private LocalDateTime arrivalDate;
	private LocalDateTime departureDate;
	
	public Registration(Conference conference,Participant participant, LocalDateTime arrivalDate,LocalDateTime departureDate)
	{
		this.conference = conference;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}
	
	//With companion
	public Registration(Conference conference,Participant participant, LocalDateTime arrivalDate,LocalDateTime departureDate, Companion companion)
	{
		this.conference = conference;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.companion = companion;
	}
	
	
	// beregner pris for alt (service, hotel, konference)
	public double calcTotalPrice()
	{
		double totalPrice = 0;
		if (hotel != null)
		{
			//Hotel service priser
			for (HotelService x: hotelServices)
			{
				totalPrice += x.getPrice();
			}
			
			// Antal dage på hotel 
			totalPrice += hotel.getPricePrDay()*days();
			
			// Konference pris
			totalPrice += conference.getPrice();
			
			// Udflugt pris
			for (Excursion excursion : excursions) 
			{
				totalPrice += excursion.getPrice();
			}
			
			//TODO: Checkup
		}
		return totalPrice;
	}
	
	
	/**
	 * @return days for the registration
	 */
	private long days()
	{
		return ChronoUnit.DAYS.between(arrivalDate, departureDate);
	}

	
	// Getters and setters
	public Companion getCompanion() {
		return companion;
	}

	public void setCompanion(Companion companion) {
		this.companion = companion;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}
	
	
	
	
}
