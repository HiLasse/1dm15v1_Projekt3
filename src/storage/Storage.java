package storage;

import java.util.ArrayList;

import model.Company;
import model.Participant;
import model.Hotel;
import model.Konference;
import model.Registration;

public class Storage 
{
	private static ArrayList<Konference> konferencer = new ArrayList<>();
	private static ArrayList<Participant> participents  = new ArrayList<>();
	private static ArrayList<Hotel> hoteller = new ArrayList<>();
	private static ArrayList<Registration> registrations = new ArrayList<>();
	private static ArrayList<Company> companies = new ArrayList<>();
	
	
	//----------------------------------------------------------------

	public static ArrayList<Konference> getKonferencer() 
	{
		return new ArrayList<Konference>(konferencer);
	}

	public static void addKonference(Konference Konference) 
	{
		konferencer.add(Konference);
	}

	public static void removeKonference(Konference Konference) 
	{
		konferencer.remove(Konference);
	}

	//----------------------------------------------------------------

	public static ArrayList<Participant> getParticipent() {
		return new ArrayList<Participant>(participents);
	}

	public static void addParticipent(Participant participent) {
		participents.add(participent);
	}

	public static void removeParticipent(Participant participent) {
		participents.remove(participent);
	}

	//----------------------------------------------------------------
	
	public static ArrayList<Hotel> gethoteller() {
        return new ArrayList<Hotel>(hoteller);
    }

    public static void addHotel(Hotel Hotel) {
        hoteller.add(Hotel);
    }

    public static void removeHotel(Hotel Hotel) {
        hoteller.remove(Hotel);
    }
	
	
	//----------------------------------------------------------------
	
    public static ArrayList<Registration> getRegistration() {
        return new ArrayList<Registration>(registrations);
    }

    public static void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    public static void removeRegistration(Registration registration) {
        registrations.remove(registration);
    }
    
    //----------------------------------------------------------------
    
    public static ArrayList<Company> getCompany() {
    	return new ArrayList<Company>(companies);
    }
    
    public static void addCompany(Company company) {
    	companies.add(company);
    }
    
    public static void removeCompany(Company company) {
    	companies.remove(company);
    }
}
