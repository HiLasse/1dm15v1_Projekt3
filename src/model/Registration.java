package model;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
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
		if (hotel != null)
		{
			totalPrice = hotel.getPricePrDay()*days();
		}
		return totalPrice;
	}
	
	
	/**
	 * @return days for the registration
	 */
	private long days()
	{
		return ChronoUnit.DAYS.between(arrivalDate, departureDate);
	}
	
	
}
