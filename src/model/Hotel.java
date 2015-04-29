package model;

import java.util.ArrayList;

public class Hotel 
{	
	private String name;
	private double pricePrDay;

	// link to Ekstraydelser class (--> 0..*)
	private ArrayList<HotelService> hotelServices;

	public Hotel()
	{

	}

	public double calcPrice()
	{

		return 0.0;
	}

	public double getPricePrDay()
	{
		return pricePrDay;
	}

}
