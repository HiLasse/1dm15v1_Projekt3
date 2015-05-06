package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import com.sun.corba.se.internal.Interceptors.PIORB;

import service.Service;

public class Conference {
	//Fields
	/**
	 * name of Conference
	 */
	private String name;
	
	/**
	 * address of Conference
	 */
	private String address;
	
	/**
	 * startTime of Conference
	 */
	private LocalDate startTime;
	
	/**
	 * endTime of Conference
	 */
	private LocalDate endTime;
	
	/**
	 * participants of Conference
	 */
	private ArrayList<Registration> registrations = new ArrayList<>();

	/**
	 * excurtions during Conference
	 */
	private ArrayList<Excursion> excursions = new ArrayList<>();

	/**
	 * hotels available for Participant during a Conference
	 */
	private ArrayList<Hotel> hotels = new ArrayList<>();

	/**
	 * price of Conference per day per Participant
	 */
	private double price;

	private long days;
	
	//-----------------------------------------------------------------------------------------

	//Constructor
	
	/**
	 * Constructs a Conference object
	 * @param name of Conference
	 * @param address of Conference
	 * @param startTime of Conference
	 * @param endTime of Conference
	 */
	public Conference(String name, String address, LocalDate startTime, LocalDate endTime, double price) {
		this.name = name;
		this.address = address;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
	}

	//-----------------------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return name;
	}
	
	//price methods
	
	/**
	 * @return the price of Conference per day per Participant
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price set the price of Conference per day per Participant
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	//-----------------------------------------------------------------------------------------

	//name methods
	
	/**
	 * @return the name of the Conference
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name set the name of the Conference
	 */
	public void setName(String name) {
		this.name = name;
	}

	//-----------------------------------------------------------------------------------------

	//address methods
	
	/**
	 * @return the address of the Conference
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address set the address of the Conference
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	//-----------------------------------------------------------------------------------------

	//startTime methods
	
	/**
	 * @return the startTime of the Conference
	 */
	public LocalDate getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime set the startTime of the Conference
	 */
	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}
	
	//-----------------------------------------------------------------------------------------

	//endTime methods
	
	/**
	 * @return the endTime of the Conference
	 */
	public LocalDate getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime set the endTime of the Conference
	 */
	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}
	
	//-----------------------------------------------------------------------------------------
	
	//Total time method
	
	public long getTotaltime() {
		days = Period.between(startTime, endTime).getDays();
		return days;
	}
	

	//-----------------------------------------------------------------------------------------

	//Get participants, companions, excursions and hotels methods
	
	public ArrayList<Participant> getParticipants() {
		ArrayList<Participant> participants = new ArrayList<Participant>();
		for (Registration registration : Service.getRegistration()) {
			if (registration.getConference().equals(this)){
			participants.add(registration.getParticipant());
			}
		}
		return participants;
	}
	
	public ArrayList<Companion> getCompanions() {
		ArrayList<Companion> companions = new ArrayList<Companion>();
		for (Registration registration : Service.getRegistration()) {
			if (registration.getConference().equals(this)){
			companions.add(registration.getCompanion());
			}
		}
		return companions;
	}
	
	public ArrayList<Excursion> getExcursions() {
		ArrayList<Excursion> excursions = new ArrayList<Excursion>();
		for (Registration registration : Service.getRegistration()) {
			if (registration.getConference().equals(this)){
			excursions.addAll(registration.getExcursions());
			
			}
		}
		return excursions;
	}
	
	public ArrayList<Hotel> getHotel() {
		ArrayList<Hotel> Hotel = new ArrayList<Hotel>();
		for (Registration registration : Service.getRegistration()) {
			if (registration.getConference().equals(this)){
			Hotel.add(registration.getHotel());
			}
		}
		return Hotel;
	}
	
	/**
	 * @return the registrations ArrayList of the Conference
	 */
	public ArrayList<Registration> getRegistrationsArray() {
		return registrations;
	}

	/**
	 * @param registration adds Participant object to participants ArrayList
	 */
	public void addRegistration(Registration registration) {
		this.registrations.add(registration);
	}
	/**
	 * Removes specified Participant object for participants ArrayList
	 * @param registration to be removed
	 */
	public void removeParticipant(Registration registration){
		this.registrations.remove(registration);
	}

	//-----------------------------------------------------------------------------------------

	//excurtions methods
	
	/**
	 * @return the excursions ArrayList of the Conference
	 */
	public ArrayList<Excursion> getExcursion() {
		return excursions;
	}
	
	/**
	 * @param excursion adds Excursion object to excursions ArrayList
	 */
	public void addExcursion(Excursion excursion) {
		this.excursions.add(excursion);
	}
	/**
	 * Removes specified Excursion object for participants ArrayList
	 * @param excursion to be removed
	 */
	public void removeExcursion(Excursion excursion){
		this.excursions.remove(excursion);
	}

	//-----------------------------------------------------------------------------------------

	//hotels methods
	
	/**
	 * @return the hotels ArrayList of the Conference
	 */
	public ArrayList<Hotel> getHotelsArray() {
		return hotels;
	}
	
	/**
	 * @param hotel adds Hotel object to hotels ArrayList
	 */
	public void addHotel(Hotel hotel) {
		this.hotels.add(hotel);
	}
	/**
	 * Removes specified Hotel object for hotels ArrayList
	 * @param hotel to be removed
	 */
	public void removeHotel(Hotel hotel){
		this.hotels.remove(hotel);
	}
	
	//-----------------------------------------------------------------------------------------

	public Registration createRegistration (Conference conference, Participant participant, LocalDate arrivalDate,LocalDate departureDate) {
		Registration registration = new Registration(conference, participant, arrivalDate, departureDate);
		return registration;
	}
}
