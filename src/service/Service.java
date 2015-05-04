package service;

import java.time.LocalDateTime;

import model.Company;
import model.Conference;
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
	
	public static Participant createParticipant(String name, String address, int telephone, String email) {
		Participant participant = new Participant(name, address, telephone, email);
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
	
	public static Conference createConference(String name, String address, LocalDateTime startTime, LocalDateTime endTime, double price) {
		Conference conference = new Conference(name, address, startTime, endTime, price);
		Storage.addConference(conference);
		return conference;
	}
	
	public static void updateConference(Conference conference, String name, String address, LocalDateTime startTime, LocalDateTime endTime) {
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
	
	public static Registration createRegistration() {
		//something
		return null;
	}
	
}
