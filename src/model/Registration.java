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
	
	public double calcPrice()
	{
		double totalPrice = 0;
		if (hotel != null)
		{
			totalPrice = (hotel.calcPrice()+hotel.getpricePrDay())*days();
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

	public void setExcursions(ArrayList<Excursion> excursions) {
		this.excursions = excursions;
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
