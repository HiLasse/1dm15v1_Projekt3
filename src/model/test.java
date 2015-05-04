package model;

import java.time.LocalDate;


//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING


/*
 * TODO
 * Service:
 * 
 * (link == update, create, remove)
 * 
 * link companion to participant ---- Done
 * link companion to excursions
 * link hotel to conference ---- Done
 * link hotel services to hotel
 * link excursions to conference
 * 
 * se evt 17. april opgaver, service
 */
public class test {

	public static void main(String[] args) 
	{
		Participant p1 = new Participant("Dennis", "Vej21", 9876543, "lol@gmail.nu", false);
		Participant p2 = new Participant("Dennissss", "Vej2221", 98276543, "lo123l@gmail.nu", true);
		
		Companion c1 = new Companion("Lars Allan for fanden");
		
		Conference co1 = new Conference("Bæver konf", "her", LocalDate.of(2001, 2, 17), LocalDate.of(2001, 2, 20), 1000);
		
		Hotel h1 = new Hotel("Hotel fint", 200);
		HotelService hs1 = new HotelService("Morgenmad", 100);
		HotelService hs2 = new HotelService("Swimming Pool access", 200);
		
		Excursion e1 = new Excursion("Hyggetur til irma", 100, LocalDate.now());
		
		Registration r1 = new Registration(co1, p1, co1.getStartTime(), co1.getEndTime());
		r1.setHotel(h1); // 200 * 3
		r1.addHotelServices(hs1);// 100*3
		r1.addHotelServices(hs2); // 200*3
		r1.addExcursion(e1);
		r1.setCompanion(c1);
		// sum == 1000 + 600 + 300 + 600 = 2500
		
		System.out.println("Pris for: "+p1.getName()+" "+r1.calcTotalPrice());
		
		Registration r2 = new Registration(co1, p2, co1.getStartTime(), co1.getEndTime());
		r2.setHotel(h1); // 200 * 3
		r2.addHotelServices(hs1);// 100*3
		r2.addHotelServices(hs2); // 200*3
		r2.getExcursions();
		
		System.out.println("Pris for: "+p2.getName()+" "+r2.calcTotalPrice());
		
	}

}
