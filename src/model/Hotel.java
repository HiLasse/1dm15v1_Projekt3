package model;

import java.util.ArrayList;

public class Hotel {
	
	private String navn;
	private double prisPrDag;
	private boolean enkeltværelse;
	
	// link to Ekstraydelser class (--> 0..*)
	private ArrayList<Hotelydelser> ekstraydelser;
	
	
	public Hotel()
	{
		
	}
	
	public double calcPrice()
	{
		
		return 0.0;
	}
	
	public double getPricePrDay()
	{
		return prisPrDag;
	}

}
