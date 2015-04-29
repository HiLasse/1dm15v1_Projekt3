package model;

import java.util.ArrayList;

public class Hotel 
{	
	private String name;
	private double pricePrDay;
	// link to Ekstraydelser class (--> 0..*)
	
	
	private ArrayList<HotelService> hotelServices;
//github.com/HiLasse/1dm15v1_Projekt3.git
	public Hotel(String name, double pricePrDay)
	{
		this.name = name;
		this.pricePrDay = pricePrDay;
	}

	public double calcPrice()
	{
		double servicePrice = 0;
		for (HotelService x: hotelServices)
		{
			servicePrice += x.getPrice();
		}
		//TODO: Find ud af hvor det skal beregnes
		return servicePrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePrDay() {
		return pricePrDay;
	}

	public void setPricePrDay(double pricePrDay) {
		this.pricePrDay = pricePrDay;
	}

	public ArrayList<HotelService> getHotelServices() {
		return hotelServices;
	}

	public double getpricePrDay()
	{
		return pricePrDay;
	}

}
