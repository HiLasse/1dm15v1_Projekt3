package storage;

import java.util.ArrayList;

import model.Company;
import model.Conference;
import model.Hotel;
import model.HotelService;
import model.Participant;
import model.Registration;

public class Storage 
{
	private static ArrayList<Conference> conferences = new ArrayList<>();
	private static ArrayList<Participant> participants  = new ArrayList<>();
	private static ArrayList<Hotel> hotels = new ArrayList<>();
	private static ArrayList<HotelService> hotelServices = new ArrayList<>();
	private static ArrayList<Registration> registrations = new ArrayList<>();
	private static ArrayList<Company> companies = new ArrayList<>();


	//----------------------------------------------------------------

	public static ArrayList<Conference> getConferences() 
	{
		return new ArrayList<Conference>(conferences);
	}

	public static void addConference(Conference conference) 
	{
		conferences.add(conference);
	}

	public static void removeConference(Conference conference) 
	{
		conferences.remove(conference);
	}

	//----------------------------------------------------------------

	public static ArrayList<Participant> getParticipent() {
		return new ArrayList<Participant>(participants);
	}

	public static void addParticipent(Participant participant) {
		participants.add(participant);
	}

	public static void removeParticipent(Participant participant) {
		participants.remove(participant);
	}

	//----------------------------------------------------------------

	public static ArrayList<Hotel> getHotels() {
		return new ArrayList<Hotel>(hotels);
	}

	public static void addHotel(Hotel Hotel) {
		hotels.add(Hotel);
	}

	public static void removeHotel(Hotel Hotel) {
		hotels.remove(Hotel);
	}


	//----------------------------------------------------------------

	public static ArrayList<HotelService> getHotelServices() {
		return new ArrayList<HotelService>(hotelServices);
	}

	public static void addHotelService(HotelService HotelService) {
		hotelServices.add(HotelService);
	}

	public static void removeHotelService(HotelService HotelService) {
		hotelServices.remove(HotelService);
	}
	
	//----------------------------------------------------------------

	public static ArrayList<Registration> getRegistration() {
		return new ArrayList<Registration>(registrations);
	}

	public static void addRegistration(Registration registration) {
		registrations.add(registration);
	}

	public static void removeRegistration(Registration registration) {
		registrations.remove(registration);
	}

	//----------------------------------------------------------------

	public static ArrayList<Company> getCompany() {
		return new ArrayList<Company>(companies);
	}

	public static void addCompany(Company company) {
		companies.add(company);
	}

	public static void removeCompany(Company company) {
		companies.remove(company);
	}
}
