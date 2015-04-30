package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * An Excursion during one or more conferences
 * @author Lasse
 *
 */
public class Excursion {

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
	private LocalDateTime date;

	/**
	 * List of Companion who are on an Excursion.
	 * Link to Companion class(-->0..*)
	 */
	private ArrayList<Companion> companions = new ArrayList<Companion>();

	/**
	 * Constructs an Excursion
	 * @param name of Excursion
	 * @param price of Excursion per person
	 * @param date of Excursion
	 */
	public Excursion (String name, double price, LocalDateTime date){
		this.name = name;
		this.price = price;
		this.date = date;
	}

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
	/**
	 * @return the date of Excursion
	 */
	public LocalDateTime getDate() {
		return date;
	}
	/**
	 * @param date , set the date of Excursion
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * Returns an ArrayList of Companions on an Excursion
	 * @return companions ArrayList
	 */
	public ArrayList<Companion> getCompanions() {
		return companions;
	}
	

}
