package service;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Companion;
import model.Company;
import model.Conference;
import model.Excursion;
import model.Hotel;
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

	public static Registration createRegistration(Conference conference, Participant participant, LocalDate arrivalDate,LocalDate departureDate) {
		return conference.createRegistration(conference, participant, arrivalDate, departureDate);
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
	
	
	//----------------------------Hotel link methods
	//remove
	public static ArrayList<Hotel> removeHotelOfConference(Hotel hotel, Conference conference)
	{
		conference.removeHotel(hotel);
		return new ArrayList<Hotel>();
	}
	//add
	public static ArrayList<Hotel> addHotelOfConference(Hotel hotel, Conference conference)
	{
		conference.addHotel(hotel);
		return new ArrayList<Hotel>();
	}
	
	
	
	
}