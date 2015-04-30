package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Conference {

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
	private LocalDateTime startTime;
	
	/**
	 * endTime of Conference
	 */
	private LocalDateTime endTime;
	
	/**
	 * participants of Conference
	 */
	private ArrayList<Participant> participants;

	/**
	 * excurtions during Conference
	 */
	private ArrayList<Excursion> excursions;

	/**
	 * hotels available for Participant during a Conference
	 */
	private ArrayList<Hotel> hotels;

	/**
	 * price of Conference per day per Participant
	 */
	private double price;
	
	/**
	 * Constructs a Conference object it initializes the ArrayLists participants, excursions and hotels, but sets them to NULL
	 * @param name of Conference
	 * @param address of Conference
	 * @param startTime of Conference
	 * @param endTime of Conference
	 */
	public Conference(String name, String address, LocalDateTime startTime, LocalDateTime endTime, double price) {
		this.name = name;
		this.address = address;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.participants = null;
		this.excursions = null;
		this.hotels = null;
	}

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

	/**
	 * @return the startTime of the Conference
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime set the startTime of the Conference
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime of the Conference
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime set the endTime of the Conference
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the participants ArrayList of the Conference
	 */
	public ArrayList<Participant> getParticipantsArray() {
		return participants;
	}

	/**
	 * @param participant adds Participant object to participants ArrayList
	 */
	public void addParticipant(Participant participant) {
		this.participants.add(participant);
	}
	/**
	 * Removes specified Participant object for participants ArrayList
	 * @param participant to be removed
	 */
	public void removeParticipant(Participant participant){
		this.participants.remove(participant);
	}

	/**
	 * @return the excursions ArrayList of the Conference
	 */
	public ArrayList<Excursion> getExcursionsArray() {
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
	public void removeExcursion(Participant excursion){
		this.excursions.remove(excursion);
	}

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
	public void removeParticipant(Hotel hotel){
		this.hotels.remove(hotel);
	}

}
