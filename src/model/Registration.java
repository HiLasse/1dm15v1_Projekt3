package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Registration 
{


	private Companion companion;
	private Participant participant;
	private Hotel hotel;
	private Conference conference;
	private ArrayList<Excursion> excursions = new ArrayList<>();
	private ArrayList<HotelService> hotelServices = new ArrayList<>();
	private LocalDate arrivalDate;
	private LocalDate departureDate;

	public Registration(Conference conference,Participant participant, LocalDate arrivalDate,LocalDate departureDate)
	{
		this.conference = conference;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.participant = participant;
	}

	//With companion
	public Registration(Conference conference,Participant participant, LocalDate arrivalDate,LocalDate departureDate, Companion companion)
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
				totalPrice += x.getPrice()*days();
			}

			// Antal dage på hotel 
			totalPrice += hotel.getPricePrDay()*days();
		}
		// Konference pris
		totalPrice += conference.getPrice();

		// Udflugt pris
		if(companion != null)
		{
			for (Excursion excursion : excursions) 
			{
				totalPrice += excursion.getPrice();
			}
		}

		if( participant.isLecture())
		{
			totalPrice = 0;
		}
		//TODO: Checkup
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
	
	public void addExcursion(Excursion excursion)
	{
		this.excursions.add(excursion);
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public ArrayList<HotelService> getHotelServices() {
		return hotelServices;
	}

	public void addHotelServices(HotelService hotelService) {
		this.hotelServices.add(hotelService);
	}

	public Participant getParticipant() {
		return participant;
	}
	
	


}
