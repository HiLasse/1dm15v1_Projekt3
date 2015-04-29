package model;

import java.util.ArrayList;

public class Hotel 
{	
	private String name;
	private double pricePrDay;

	// link to Ekstraydelser class (--> 0..*)
	private ArrayList<HotelService> services;
	
	
	private ArrayList<HotelService> hotelServices;
//github.com/HiLasse/1dm15v1_Projekt3.git
	public Hotel()
	{

	}

	public double calcPrice()
	{

		return 0.0;
	}

	public double getpricePrDay()
	{
		return pricePrDay;
	}

}
