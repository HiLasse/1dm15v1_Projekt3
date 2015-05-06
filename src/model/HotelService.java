package model;
/**
 * HotelService is something a Registration (Participant) can buy in excess of a room
 * (contains only ONE service)
 * @author Lasse
 *
 */
public class HotelService {

	//Fields
	
	/**
	 * name of HotelService
	 */
	private String name;
	/**
	 * price of HotelService
	 */
	private double price;

	//-----------------------------------------------------------------------------------------

	//Constructor
	
	/**
	 * Creates a HotelService
	 * @param name of HotelService
	 * @param price of HotelService
	 */
	public HotelService(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	
	//-----------------------------------------------------------------------------------------

	//name methods
	
	/**
	 * @return the name of the HotelService
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name set the name of the HotelService
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
	 * @return the price of the HotelService
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price set the price of the HotelService
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	//-----------------------------------------------------------------------------------------
}
