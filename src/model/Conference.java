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
	public ArrayList<Participant> getParticipants() {
		return participants;
	}

	/**
	 * @param participant adds Participant object to participants ArrayList
	 */
	public void addParticipant(Participant participant) {
		participants.add(participant);
	}
	/**
	 * Removes specified Participant object for participants ArrayList
	 * @param participant to be removed
	 */
	public void removeParticipant(Participant participant){
		participants.remove(participant);
	}

	/**
	 * Searches the participants ArrayList for an object with a string matching the name
	 * IF NONE FOUND RETURNS NULL
	 * DOES NOT FIND DUPLICATES
	 * @param name the name String of Participant object
	 * @return Participant object matching string or NULL if none found
	 */
	public Participant findParticipant(String name){
		Participant tempoary = null; 
		for(int i = 0; i < this.participants.size(); i++){
			if (this.participants.get(i).getName() == name){
				tempoary = this.participants.get(i);
				break;
			}
			else{
				tempoary = null;
			}

		}
		return tempoary;
	}

	/**
	 * @param participant adds Excursion object to excursions ArrayList
	 */
	public void addExcursion(Excursion excursion) {
		excursions.add(excursion);
	}
	/**
	 * Removes specified Excursion object for participants ArrayList
	 * @param excursion to be removed
	 */
	public void removeExcursion(Participant excursion){
		excursions.remove(excursion);
	}

	/**
	 * Searches the excursions ArrayList for an object with a string matching the name
	 * IF NONE FOUND RETURNS NULL
	 * DOES NOT FIND DUPLICATES
	 * @param name the name String of Excursion object
	 * @return Excursion object matching string or NULL if none found
	 */
	public Excursion findExcursion(String name){
		Excursion tempoary = null; 
		for(int i = 0; i < this.excursions.size(); i++){
			if (this.excursions.get(i).getName() == name){
				tempoary = this.excursions.get(i);
				break;
			}
			else{
				tempoary = null;
			}

		}
		return tempoary;
	}

	/**
	 * @param hotel adds Hotel object to hotels ArrayList
	 */
	public void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}
	/**
	 * Removes specified Hotel object for hotels ArrayList
	 * @param hotel to be removed
	 */
	public void removeParticipant(Hotel hotel){
		hotels.remove(hotel);
	}

	/**
	 * Searches the hotels ArrayList for an object with a string matching the name
	 * IF NONE FOUND RETURNS NULL
	 * DOES NOT FIND DUPLICATES
	 * @param name the name String of Hotel object
	 * @return Hotel object matching string or NULL if none found
	 */
	public Hotel findHotel(String name){
		Hotel tempoary = null; 
		for(int i = 0; i < this.hotels.size(); i++){
			if (this.hotels.get(i).getName() == name){
				tempoary = this.hotels.get(i);
				break;
			}
			else{
				tempoary = null;
			}

		}
		return tempoary;
	}

}
