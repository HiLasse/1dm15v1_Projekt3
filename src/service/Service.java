package service;

import storage.Storage;
import model.Company;
import model.Hotel;
import model.Participant;

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

	//Participent methods
	
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
	
	public static Hotel createHotel() {
		Hotel hotel = new Hotel();
		Storage.addHotel(hotel);
		return hotel;
	}
}
