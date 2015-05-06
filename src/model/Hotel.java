	package model;

import java.util.ArrayList;
/**
 * A Hotel is a place a Registration can sleep at.
 * @author Lasse
 */
public class Hotel 
{	
	//Fields
	/**
	 * name of Hotel
	 */
	private String name;
	
	/**
	 * Base price of Hotel per day
	 */
	private double pricePrDay;
	
	/**
	 * List containing additional services (HotelService) a Registration can "buy"
	 *  link to Ekstraydelser class (--> 0..*)
	 */
	private ArrayList<HotelService> hotelServices  = new ArrayList<HotelService>();

	//-----------------------------------------------------------------------------------------

	//Constructor
	/**
	 * Constructs a Hotel with name and price
	 * @param name of Hotel
	 * @param pricePrDay for stay in hotel, excluding any HotelService
	 */
	public Hotel(String name, double pricePrDay)
	{
		this.name = name;
		this.pricePrDay = pricePrDay;
	}
	//-----------------------------------------------------------------------------------------

	// Work in Progress
	/**
	 * Calculates total price of a stay in a Hotel for a given Registration including added HotelService
	 * @return servicePrice
	 */
	public double calcHotelServicePrice()
	{
		double servicePrice = 0;
		for (HotelService x: hotelServices)
		{
			servicePrice += x.getPrice();
		}
		return servicePrice;
	}

	//-----------------------------------------------------------------------------------------

	//name methods
	
	/**
	 * 
	 * @return name of Hotel
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name , set name of Hotel
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	//-----------------------------------------------------------------------------------------

	//pricePrDay methods
	
	/**
	 * Base cost of a room in a Hotel
	 * @return pricePrDay
	 */
	public double getPricePrDay() {
		return pricePrDay;
	}

	/**
	 * Changes the base price per day of a Hotel
	 * @param pricePrDay set pricePrDay
	 */
	public void setPricePrDay(double pricePrDay) {
		this.pricePrDay = pricePrDay;
	}

	//-----------------------------------------------------------------------------------------

	//HotelServices methods
	
	/**
	 * Returns an ArrayList of hotelServies of a given Hotel
	 * @return hotelServices
	 */
	public ArrayList<HotelService> getHotelServices() {
		return hotelServices;
	}
	
	/**
	 * @param hotelService adds HotelService object to hotelService ArrayList
	 */
	public void addHotelServices(HotelService hotelService) {
		this.hotelServices.add(hotelService);
	}
	
	/**
	 * Removes specified HotelService object for hotelService ArrayList
	 * @param hotelService to be removed
	 */
	public void removeHotelServices(HotelService hotelService){
		this.hotelServices.remove(hotelService);
	}
	//-----------------------------------------------------------------------------------------
}
