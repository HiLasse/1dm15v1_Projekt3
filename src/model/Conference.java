package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Conference {

	private String name;
	private String address;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private ArrayList<Participant> participants;
	private ArrayList<Excursion> excursions;
	private ArrayList<Hotel> hotels;
	
	public Conference(String name, String address, LocalDateTime startTime, LocalDateTime endTime) {
		this.name = name;
		this.address = address;
		this.startTime = startTime;
		this.endTime = endTime;
		this.participants = null;
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
	 * @return the participants of the Conference
	 */
	public ArrayList<Participant> getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(ArrayList<Participant> participants) {
		this.participants = participants;
	}
	
	public Participant findParticipant(String Name){
		for(int i = 0; i < )
		return null;
	}
	
	
}
