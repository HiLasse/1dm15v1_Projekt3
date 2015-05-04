package model;

import java.time.LocalDate;
import java.time.LocalDateTime;


//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING
//TEST KLASSE, SKAL SLETTES INDEN AFLEVERING

public class test {

	public static void main(String[] args) 
	{
		Participant p1 = new Participant("Dennis", "Vej21", 9876543, "lol@gmail.nu", false);
		Participant p2 = new Participant("Dennissss", "Vej2221", 98276543, "lo123l@gmail.nu", true);
		
		Companion c1 = new Companion("Lars Allan for fanden");
		
		Conference co1 = new Conference("Bæver konf", "her", LocalDate.of(2001, 2, 17), LocalDate.of(2001, 2, 20), 800);
		
		Registration r1 = new Registration(co1, p1, co1.getStartTime(), co1.getEndTime());
		
		
		
	}

}
