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
		double servicePrice = 0;
		for (HotelService x: services)
		{
			servicePrice += x.getPrice();
		}
		
		return servicePrice;
	}

	public double getpricePrDay()
	{
		return pricePrDay;
	}

}
