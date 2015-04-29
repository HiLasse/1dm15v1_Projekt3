package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Registration 
{
	
	
	private Companion companion;
	private Hotel hotel;
	private ArrayList<Excursion> excursions = new ArrayList<>();
	private LocalDateTime arrivalDate;
	private LocalDateTime departureDate;
	
	public Registration(Participant participant)
	{
		
	}
	
	public double calcPrice()
	{
		double totalPrice = 0;
		int days = departureDate -  arrivalDate;
		if (hotel != null)
		{
			totalPrice = hotel.getPricePrDay()*(departureDate - arrivalDate);
		}
		return totalPrice;
	}
	
	
}
