package storage;

import java.util.ArrayList;

import model.Deltager;
import model.Hotel;
import model.Konference;
import model.Tilmelding;

public class Storage 
{
	private static ArrayList<Konference> konferencer = new ArrayList<>();
	private static ArrayList<Deltager> deltagerer  = new ArrayList<>();
	private static ArrayList<Hotel> hoteller = new ArrayList<>();
	private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
	
	
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

	public static ArrayList<Deltager> getdeltagerer() {
		return new ArrayList<Deltager>(deltagerer);
	}

	public static void addDeltager(Deltager Deltager) {
		deltagerer.add(Deltager);
	}

	public static void removeDeltager(Deltager Deltager) {
		deltagerer.remove(Deltager);
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
	
    public static ArrayList<Tilmelding> gettilmeldinger() {
        return new ArrayList<Tilmelding>(tilmeldinger);
    }

    public static void addTilmelding(Tilmelding Tilmelding) {
        tilmeldinger.add(Tilmelding);
    }

    public static void removeTilmelding(Tilmelding Tilmelding) {
        tilmeldinger.remove(Tilmelding);
    }
}
