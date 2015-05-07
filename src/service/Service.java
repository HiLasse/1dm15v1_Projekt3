package service;

import java.time.LocalDate;
import java.util.ArrayList;

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

	public static void updateParticipant(Participant participant, String name, String address, int telephone, String CountryOrCity) {
		participant.setAddress(address);
		participant.setCountryOrCity(CountryOrCity);
		participant.setName(name);
		participant.setTelephone(telephone);
	}

	public static void deleteParticipant(Participant participant) {
		Storage.removeParticipent(participant);
	}

	public static ArrayList<Participant> getParticipants()
	{
		return Storage.getParticipent();
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
		Storage.addHotelService(hotelservice);
		return hotelservice;
	}

	public static void updateHotelService(HotelService hotelService, String name, double price) {
		hotelService.setName(name);
		hotelService.setPrice(price);
	}

	public static void deleteHotelService(HotelService hotelService) {
		Storage.removeHotelService(hotelService);
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

	public static ArrayList<Conference> getConferences()
	{
		return Storage.getConferences();
	}

	//----------------------------------------------------------------------------------------

	//Registration methods

	public static Registration createRegistration(Conference conference, Participant participant, LocalDate arrivalDate,LocalDate departureDate) 
	{	
		Registration registration = conference.createRegistration(conference, participant, arrivalDate, departureDate);
		Storage.addRegistration(registration);
		return registration;
	}

	public static ArrayList<Registration> getRegistration()
	{
		return Storage.getRegistration();
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
	
	//public ArrayList<Hotel> getHotel

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

	public static void setHotelServiceToRegistration(Registration registraion, HotelService hotelservice){
		registraion.addHotelServices(hotelservice);
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
	
	public static void setExcursionToRegistration(Registration registration, Excursion excursion) {
		registration.addExcursion(excursion);
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
		
		//Participants
		Participant p1 = Service.createParticipant("Anna Bøgedal","Cikorievej 1",10101010,"Arnager", false);
		Participant p2 = Service.createParticipant("Benny Clausen","Dambroen 2",20202020,"Bølshavn", false);
		Participant p3 = Service.createParticipant("Cecilie Damgaard","Egesensvej 3",30303030,"Christians Ø", false);
		Participant p4 = Service.createParticipant("Dennis Engdahl","Florastræde 4",40404040,"Gudhjem", false);
		Participant p5 = Service.createParticipant("Eva Finderrup","Gyvel Allé 5",50505050,"Hasle", false);
		Participant p6 = Service.createParticipant("Felix Gunnarson","Horsentia Boulevard 6",60606060,"Klemensker", false);
		Participant p7 = Service.createParticipant("Gitte Hansen","Irisgade 7",70707070,"Nexø", false);
		Participant p8 = Service.createParticipant("Henrik Ingslev","Julestjerneparken 8",80808080,"Olsker", false);
		Participant p9 = Service.createParticipant("Ida Jakobsdottir","Klematisvej 9",90909090,"Rønne", false);
		Participant p10 = Service.createParticipant("Jens Kutter","Lyngstræde 10",11111111,"Arnager", false);
		Participant p11 = Service.createParticipant("Katrina Lods","Maguritteruten 11",12121212,"Bølshavn", false);
		Participant p12 = Service.createParticipant("Loke Madsen","Nellike Allé 12",13131313,"Christians Ø", false);
		Participant p13 = Service.createParticipant("Marina Nielstrup","Opiumsplads 13",14141414,"Gudhjem", false);
		Participant p14 = Service.createParticipant("Nicky Odendsee","Petagoineparken 14",15151515,"Hasle", false);
		Participant p15 = Service.createParticipant("Olga Piilborg","Quinoagade 15",16161616,"Klemensker", false);
		Participant p16 = Service.createParticipant("Poul Quist","Roseporten 16",17171717,"Nexø", false);
		Participant p17 = Service.createParticipant("Qairina Rust","Solsikkestræde 17",18181818,"Olsker", false);
		Participant p18 = Service.createParticipant("Rolf Sørnsen","Tusinfrydsvej 18",19191919,"Rønne", false);
		Participant p19 = Service.createParticipant("Sarina Thomson","Uglegade 19",21212121,"Arnager", false);
		Participant p20 = Service.createParticipant("Tim Uldgaard","Vildhestevej 20",22222222,"Bølshavn", false);
		Participant p21 = Service.createParticipant("Ulrikke Vagnn","Wombatstræde 21",23232323,"Christians Ø", false);
		Participant p22 = Service.createParticipant("Viggo Willumsen","Xylosmabro 22",24242424,"Gudhjem", false);
		Participant p23 = Service.createParticipant("Wilhelmine Xansen","Yak Allé 23",25252525,"Hasle", false);
		Participant p24 = Service.createParticipant("Xander Ystad","Zebrahajvej 24",26262626,"Klemensker", true);
		Participant p25 = Service.createParticipant("Yannie Zørnsen","Æbleblomstparken 25",27272727,"Nexø", true);
		Participant p26 = Service.createParticipant("Zøren Æbbesen","Ørentvist Boulevard 26",28282828,"Olsker",true);
		Participant p27 = Service.createParticipant("Æbba Øhrberg","Åkandevej 27",29292929,"Rønne", false);
		Participant p28 = Service.createParticipant("Øjvind Åldbæch","Anemomestræde 28",31313131,"Arnager", false);
		Participant p29 = Service.createParticipant("Åse Abrahamsen","Blomstervej 29",32323232,"Bølshavn", false);
		//Companions
		Companion c1 = Service.createCompanion("Allan Bøgedal");
		Companion c2 = Service.createCompanion("Bente Clausen");
		Companion c3 = Service.createCompanion("Claus Damgaard");
		Companion c4 = Service.createCompanion("Dorte Engdahl");
		Companion c5 = Service.createCompanion("Erik Finderrup");
		Companion c6 = Service.createCompanion("Frida Gunnarson");
		Companion c7 = Service.createCompanion("Gunnar Hansen");
		Companion c8 = Service.createCompanion("Helle Ingslev");
		Companion c9 = Service.createCompanion("Ingolf Jakobsdottir");
		Companion c10 = Service.createCompanion("Jette Kutter");
		Companion c11 = Service.createCompanion("Klaus Lods");
		Companion c12 = Service.createCompanion("Lise Madsen");
		Companion c13 = Service.createCompanion("Mikkel Nielstrup");
		Companion c14 = Service.createCompanion("Nina Odendsee");
		Companion c15 = Service.createCompanion("Ole Piilborg");
		Companion c16 = Service.createCompanion("Pia Quist");
		Companion c17 = Service.createCompanion("Qai Rust");
		Companion c18 = Service.createCompanion("Rikke Sørnsen");
		Companion c19 = Service.createCompanion("Søren Thomson");
		Companion c20 = Service.createCompanion("Tina Uldgaard");
		Companion c21 = Service.createCompanion("Ulrik Vagnn");
		Companion c22 = Service.createCompanion("Vinnie Willumsen");
		Companion c23 = Service.createCompanion("Werner Xansen");
		Companion c24 = Service.createCompanion("Xena Ystad");
		Companion c25 = Service.createCompanion("Yannik Zørnsen");
		Companion c26 = Service.createCompanion("Zarina Æbbesen");
		Companion c27 = Service.createCompanion("Ægir Øhrberg");
		Companion c28 = Service.createCompanion("Ønske Åldbæch");
		Companion c29 = Service.createCompanion("Åge Abrahamsen");
		//Conferences
		Conference co1 = Service.createConference("Bornholms Truede Sæler", "Sælstræde 48", LocalDate.of(2001, 2, 17), LocalDate.of(2001, 2, 21), 1000);
		Conference co2 = Service.createConference("Overfiskerri på Bornholm", "Fiskervej 49", LocalDate.of(2010, 2, 18), LocalDate.of(2010, 2, 23), 5000);
		Conference co3 = Service.createConference("Grundvandsforurening på Bornholm", "Kildevænget 50", LocalDate.of(2005, 2, 19), LocalDate.of(2005, 2, 27), 5000);
		//Registrations
		Registration r1 = Service.createRegistration(co1, p1, co1.getStartTime(), co1.getEndTime());
		Registration r2 = Service.createRegistration(co2, p2, co2.getStartTime(), co2.getEndTime());
		Registration r3 = Service.createRegistration(co1, p3, co1.getStartTime(), co1.getEndTime());
		Registration r4 = Service.createRegistration(co2, p4, co2.getStartTime(), co2.getEndTime());
		Registration r5 = Service.createRegistration(co1, p5, co1.getStartTime(), co1.getEndTime());
		Registration r6 = Service.createRegistration(co2, p6, co2.getStartTime(), co2.getEndTime());
		//Hotels
		Hotel h1 = Service.createHotel("Vandrehjemmet",100);
		Hotel h2 = Service.createHotel("Kroen",200);
		Hotel h3 = Service.createHotel("Hotellet",300);
		Hotel h4 = Service.createHotel("Campingpladsen",400);
		Hotel h5 = Service.createHotel("Pensionatet",500);
		Hotel h6 = Service.createHotel("Motellet",600);
		Hotel h7 = Service.createHotel("Bed and Breakfast",700);
		Hotel h8 = Service.createHotel("Gæstegiveriet",800);
		Hotel h9 = Service.createHotel("Herberget",900);
		//Hotel Services
		HotelService hs1 = Service.createHotelService("WiFi",10);
		HotelService hs2 = Service.createHotelService("Morgenmad",50);
		HotelService hs3 = Service.createHotelService("Spa",100);
		HotelService hs4 = Service.createHotelService("Filmpakke",50);
		HotelService hs5 = Service.createHotelService("Luksusmad",250);
		HotelService hs6 = Service.createHotelService("Særlig kost",100);
		HotelService hs7 = Service.createHotelService("Massage",500);
		HotelService hs8 = Service.createHotelService("Dobeltværelse",700);
		HotelService hs9 = Service.createHotelService("Suite",1000);
		//Excurtions
		Excursion e1 = Service.createExcursion("Bornolms Museum",150, LocalDate.of(2001, 2, 17));
		Excursion e2 = Service.createExcursion("Nexø Museum",100, LocalDate.of(2001, 2, 18));
		Excursion e3 = Service.createExcursion("Gudhjem Museum",135, LocalDate.of(2001, 2, 19));
		Excursion e4 = Service.createExcursion("Foreningen De borholmske Jernbaner",95, LocalDate.of(2010, 2, 18));
		Excursion e5 = Service.createExcursion("Bornholms Automobilmuseum",150, LocalDate.of(2010, 2, 19));
		Excursion e6 = Service.createExcursion("Ekkodalen",80, LocalDate.of(2010, 2, 20));
		Excursion e7 = Service.createExcursion("Lilleborg på Bornholm",70, LocalDate.of(2005, 2, 19));
		Excursion e8 = Service.createExcursion("Midelalderns kirker på Bornholm",120, LocalDate.of(2005, 2, 20));
		Excursion e9 = Service.createExcursion("Gudhjem Svømmehal",140, LocalDate.of(2005, 2, 21));


		//links of objects
		//addHotelServiceToHotel
		Service.addHotelServiceToHotel(h1, hs1);
		Service.addHotelServiceToHotel(h1, hs2);
		Service.addHotelServiceToHotel(h1, hs3);
		Service.addHotelServiceToHotel(h2, hs4);
		Service.addHotelServiceToHotel(h2, hs5);
		Service.addHotelServiceToHotel(h2, hs6);
		Service.addHotelServiceToHotel(h3, hs7);
		Service.addHotelServiceToHotel(h3, hs8);
		Service.addHotelServiceToHotel(h3, hs9);
		Service.addHotelServiceToHotel(h4, hs1);
		Service.addHotelServiceToHotel(h4, hs2);
		Service.addHotelServiceToHotel(h4, hs3);
		Service.addHotelServiceToHotel(h5, hs4);
		Service.addHotelServiceToHotel(h5, hs5);
		Service.addHotelServiceToHotel(h5, hs6);
		Service.addHotelServiceToHotel(h6, hs7);
		Service.addHotelServiceToHotel(h6, hs8);
		Service.addHotelServiceToHotel(h6, hs9);
		Service.addHotelServiceToHotel(h7, hs1);
		Service.addHotelServiceToHotel(h7, hs2);
		Service.addHotelServiceToHotel(h7, hs3);
		Service.addHotelServiceToHotel(h8, hs4);
		Service.addHotelServiceToHotel(h8, hs5);
		Service.addHotelServiceToHotel(h8, hs6);
		Service.addHotelServiceToHotel(h9, hs7);
		Service.addHotelServiceToHotel(h9, hs8);
		Service.addHotelServiceToHotel(h9, hs9);
		//setHotelServiceToRegistration
		Service.setHotelServiceToRegistration(r1, hs1);
		Service.setHotelServiceToRegistration(r1, hs2);
		Service.setHotelServiceToRegistration(r2, hs1);
		//setExcursionToRegistration
		Service.setExcursionToRegistration(r1, e1);
		//setHotelToRegistration
		Service.setHotelToRegistration(r1, h1);
		Service.setHotelToRegistration(r2, h2);
		//addHotelOfConference
		Service.addHotelOfConference(h1, co1);
		Service.addHotelOfConference(h2, co1);
		Service.addHotelOfConference(h3, co1);
		Service.addHotelOfConference(h4, co2);
		Service.addHotelOfConference(h5, co2);
		Service.addHotelOfConference(h6, co2);
		Service.addHotelOfConference(h7, co3);
		Service.addHotelOfConference(h8, co3);
		Service.addHotelOfConference(h9, co3);
		//updateCompanionOfParticipant
		Service.updateCompanionOfParticipant(c1, p1);
		Service.updateCompanionOfParticipant(c2, p2);
		Service.updateCompanionOfParticipant(c3, p3);
		Service.updateCompanionOfParticipant(c4, p4);
		Service.updateCompanionOfParticipant(c5, p5);
		Service.updateCompanionOfParticipant(c6, p6);
		Service.updateCompanionOfParticipant(c7, p7);
		Service.updateCompanionOfParticipant(c8, p8);
		Service.updateCompanionOfParticipant(c9, p9);
		Service.updateCompanionOfParticipant(c10, p10);
		Service.updateCompanionOfParticipant(c11, p11);
		Service.updateCompanionOfParticipant(c12, p12);
		Service.updateCompanionOfParticipant(c13, p13);
		Service.updateCompanionOfParticipant(c14, p14);
		Service.updateCompanionOfParticipant(c15, p15);
		Service.updateCompanionOfParticipant(c16, p16);
		Service.updateCompanionOfParticipant(c17, p17);
		Service.updateCompanionOfParticipant(c18, p18);
		Service.updateCompanionOfParticipant(c19, p19);
		Service.updateCompanionOfParticipant(c20, p20);
		Service.updateCompanionOfParticipant(c21, p21);
		Service.updateCompanionOfParticipant(c22, p22);
		Service.updateCompanionOfParticipant(c23, p23);
		Service.updateCompanionOfParticipant(c24, p24);
		Service.updateCompanionOfParticipant(c25, p25);
		Service.updateCompanionOfParticipant(c26, p26);
		Service.updateCompanionOfParticipant(c27, p27);
		Service.updateCompanionOfParticipant(c28, p28);
		Service.updateCompanionOfParticipant(c29, p29);
		//addCompanionToExcursion
		Service.addCompanionToExcursion(c1, e1);
		//addExcursionToConference
		Service.addExcursionToConference(e1, co1);
		Service.addExcursionToConference(e2, co1);
		Service.addExcursionToConference(e3, co1);
		Service.addExcursionToConference(e4, co2);
		Service.addExcursionToConference(e5, co2);
		Service.addExcursionToConference(e6, co2);
		Service.addExcursionToConference(e7, co3);
		Service.addExcursionToConference(e8, co3);
		Service.addExcursionToConference(e9, co3);

	}

}