package service;

import java.time.LocalDate;

import model.Companion;
import model.Company;
import model.Conference;
import model.Excursion;
import model.Hotel;
import model.HotelService;
import model.Participant;
import model.Registration;
import storage.Storage;

public class Service { 
	//Company methods

	public static Company createCompany(String name, String address, int telephone) {
		Company company = new Company(name, address, telephone);
		Storage.addCompany(company);
		return company;
	}

	public static void updateCompany(Company company, String name, String address, int telephone) {
		company.setAddress(address);
		company.setName(name);
		company.setTelephone(telephone);
	}

	public static void deleteCompany(Company company) {
		Storage.removeCompany(company);
	}
	//-----------------------------------------------------------------------------------------

	//Participant methods

	public static Participant createParticipant(String name, String address, int telephone, String email, boolean lecture) {
		Participant participant = new Participant(name, address, telephone, email, lecture);
		Storage.addParticipent(participant);
		return participant;
	}

	public static void updateParticipant(Participant participant, String name, String address, int telephone, String email) {
		participant.setAddress(address);
		participant.setEmail(email);
		participant.setName(name);
		participant.setTelephone(telephone);
	}

	public static void deleteParticipant(Participant participant) {
		Storage.removeParticipent(participant);
	}

	//-----------------------------------------------------------------------------------------

	//Hotels methods

	public static Hotel createHotel(String name, double pricePrDay) {
		Hotel hotel = new Hotel(name, pricePrDay);
		Storage.addHotel(hotel);
		return hotel;
	}

	public static void updateHotel(Hotel hotel, String name, double pricePrDay) {
		hotel.setName(name);
		hotel.setPricePrDay(pricePrDay);
	}

	public static void deleteHotel(Hotel hotel) {
		Storage.removeHotel(hotel);
	}

	//----------------------------------------------------------------------------

	//Hotel Service methods

	public static HotelService createHotelService(String name, double price)
	{
		HotelService hotelservice = new HotelService(name,price);
		return hotelservice;
	}

	public static void updateHotelService(HotelService hotelService, String name, double price) {
		hotelService.setName(name);
		hotelService.setPrice(price);
	}

	//-----------------------------------------------------------------------------------------

	//Conference methods

	public static Conference createConference(String name, String address, LocalDate startTime, LocalDate endTime, double price) {
		Conference conference = new Conference(name, address, startTime, endTime, price);
		Storage.addConference(conference);
		return conference;
	}

	public static void updateConference(Conference conference, String name, String address, LocalDate startTime, LocalDate endTime) {
		conference.setName(name);
		conference.setAddress(address);
		conference.setEndTime(endTime);
		conference.setStartTime(startTime);
	}

	public static void deleteConference(Conference conference) {
		Storage.removeConference(conference);
	}

	//----------------------------------------------------------------------------------------

	//Registration methods

	public static Registration createRegistration(Conference conference, Participant participant, LocalDate arrivalDate,LocalDate departureDate) 
	{	
		Registration registration = conference.createRegistration(conference, participant, arrivalDate, departureDate);
		Storage.addRegistration(registration);
		return registration;
	}

	//----------------------------------------------------------------------------------------
	//Companion methods
	
	//Create a companion
	public static Companion createCompanion (String name) {
		Companion companion = new Companion(name);
		return companion;
	}

	public static void updateCompanion (Companion companion ,String name) {
		companion.setName(name);
	}
	
	//----------------------------------------------------------------------------------------
	//Excursions methods
	
	//Create an excursion
	public static Excursion createExcursion (String name, double price, LocalDate date) {
		Excursion excursion = new Excursion(name, price, date);
		return excursion;
	}
	
	//Update an excursion
	public static void updateExcursion (Excursion excursion ,String name, double price, LocalDate date) {
		excursion.setDate(date);
		excursion.setName(name);
		excursion.setPrice(price);
	}
	
	//----------------------------------------------------------------------------------------

	//---------------------------Companion link methods
	//Update Companion to Participant
	public static void updateCompanionOfParticipant(Companion companion, Participant participant)
	{
		participant.setCompanion(companion);
	}

	//Remove Companion from Participant
	public static void removeCompanionOfParticipant(Companion companion, Participant participant)
	{
		participant.setCompanion(null);
	}

	// Add Companion to excursion
	public static void addCompanionToExcursion(Companion companion, Excursion excursion)
	{
		excursion.addCompanion(companion);
	}

	// Remove Companion from excursion
	public static void removeCompanionToExcursion(Companion companion, Excursion excursion)
	{
		excursion.removeCompanion(companion);
	}

	// Clear companions from excursion
	public static void clearCompanionsOfExcursion(Excursion excursion)
	{
		for (Companion companion: excursion.getCompanions())
		{
			removeCompanionToExcursion(companion,excursion);
		}
	}


	//----------------------------Hotel link methods
	//remove Hotel from Conference
	public static void removeHotelOfConference(Hotel hotel, Conference conference)
	{
		conference.removeHotel(hotel);
	}

	//add Hotel to Conference
	public static void addHotelOfConference(Hotel hotel, Conference conference)
	{
		conference.addHotel(hotel);
	}

	//----------------------------HotelService link methods
	//add HotelService to Hotel
	public static void addHotelServiceToHotel(Hotel hotel, HotelService hotelService)
	{
		hotel.addHotelServices(hotelService);
	}

	//remove HotelService from Hotel
	public static void removeHotelServiceToHotel(Hotel hotel, HotelService hotelService)
	{
		hotel.removeHotelServices(hotelService);
	}

	//Clears hotelServices from Hotel
	public static void clearHotelServiceToHotel(Hotel hotel)
	{
		for (HotelService hotelService: hotel.getHotelServices())
		{
			removeHotelServiceToHotel(hotel,hotelService);
		}
	}

	//----------------------------Excursions link methods
	// Add Excursion to Conference
	public static void addExcursionToConference(Excursion excursion, Conference conference)
	{
		conference.addExcursion(excursion);
	}

	// Remove Excursion from Conference
	public static void removeExcursionFromConference(Excursion excursion, Conference conference)
	{
		conference.removeExcursion(excursion);
	}

	// Clear Excursion from Conference
	public static void clearExcursionOfConference( Conference conference)
	{
		for(Excursion excursion: conference.getExcursions())
		{
			removeExcursionFromConference(excursion,conference);
		}
	}

	//----------------------------Hotel link methods
	// Add hotel to registration
	public static void setHotelToRegistration (Registration registration, Hotel hotal) {
		registration.setHotel(hotal);
	}

	//----------------------------------------------------------------------
	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() 
	{
		//Creation of objects
		Participant p1 = Service.createParticipant("Dennis", "Vej21", 9876543, "lol@gmail.nu", false);
		Participant p2 = Service.createParticipant("Dennissss", "Vej2221", 98276543, "lo123l@gmail.nu", true);
		Companion c1 = Service.createCompanion("Lars Allan for fanden");
		Conference co1 = Service.createConference("Bæver konf", "her", LocalDate.of(2001, 2, 17), LocalDate.of(2001, 2, 20), 1000);
		Conference co2 = Service.createConference("Egn konf", "der", LocalDate.of(2010, 2, 17), LocalDate.of(2010, 2, 20), 5000);
		Registration r1 = Service.createRegistration(co1, p1, co1.getStartTime(), co1.getEndTime());
		Registration r2 = Service.createRegistration(co2, p2, co2.getStartTime(), co2.getEndTime());
		Hotel h1 = Service.createHotel("Hotel fint", 200);		
		HotelService hs1 = Service.createHotelService("Morgenmad", 100);
		HotelService hs2 = Service.createHotelService("Swimming Pool access", 200);
		Excursion e1 = Service.createExcursion("Hyggetur til irma", 100, LocalDate.now());
		
		
		//links of objects
		Service.addHotelServiceToHotel(h1, hs1);
		Service.addHotelServiceToHotel(h1, hs2);
		Service.setHotelToRegistration(r1, h1);
		Service.setHotelToRegistration(r2, h1);
		Service.updateCompanionOfParticipant(c1, p1);
		Service.addCompanionToExcursion(c1, e1);

	}

}