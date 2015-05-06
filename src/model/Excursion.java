package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * An Excursion during one or more conferences
 * @author Lasse
 *
 */
public class Excursion {

	//Fields
	/**
	 * name of an Excursion
	 */
	private String name;

	/**
	 * price of Excursion per person
	 */
	private double price;

	/**
	 * date of Excursion
	 */
	private LocalDate date;

	/**
	 * List of Companion who are on an Excursion.
	 * Link to Companion class(-->0..*)
	 */
	private ArrayList<Companion> companions = new ArrayList<Companion>();

	//-----------------------------------------------------------------------------------------

	//Constructor
	
	/**
	 * Constructs an Excursion
	 * @param name of Excursion
	 * @param price of Excursion per person
	 * @param date of Excursion
	 */
	public Excursion (String name, double price, LocalDate date){
		this.name = name;
		this.price = price;
		this.date = date;
	}
	
	//-----------------------------------------------------------------------------------------

	//name methods
	
	/**
	 * @return the name of Excursion
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name , set the name of Excursion
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	//-----------------------------------------------------------------------------------------

	//price methods
	
	/**
	 * @return the price of Excursion per person
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param price , set the price  of Excursion per person
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	//-----------------------------------------------------------------------------------------

	//price methods
	
	/**
	 * @return the date of Excursion
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date , set the date of Excursion
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	//-----------------------------------------------------------------------------------------

	//Companion methods
	
	/**
	 * Returns an ArrayList of Companions on an Excursion
	 * @return companions ArrayList
	 */
	public ArrayList<Companion> getCompanions() {
		return companions;
	}
	
	
	/**
	 * @param companion adds Companion object to companions ArrayList
	 */
	public void addCompanion(Companion companion) {
		this.companions.add(companion);
	}
	
	/**
	 * Removes specified Companion object for companions ArrayList
	 * @param companion to be removed
	 */
	public void removeCompanion(Companion companion){
		this.companions.remove(companion);
	}
	//-----------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------

}
