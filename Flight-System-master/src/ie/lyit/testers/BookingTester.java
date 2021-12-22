package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.flight.Booking;
import ie.lyit.flight.Date;
import ie.lyit.flight.Employee;
import ie.lyit.flight.Flight;
import ie.lyit.flight.Name;
import ie.lyit.flight.Passenger;
import ie.lyit.flight.Time;

public class BookingTester {

	public static void main(String[] args) {
		
		// new one ArrayList of Passenger called Passenger1
		// new another one ArrayList of  Passenger called Passenger2
		
		ArrayList<Passenger> Passenger1 = new ArrayList<Passenger>();
		ArrayList<Passenger> Passenger2 = new ArrayList<Passenger>();

		// type my name and information to it.
	    Name n1 = new Name("Mr","Mankit","Siu");
	    Passenger p1 = new Passenger(n1,new Date(12,9,1994),2,true);	
	    

	    Name n2 = new Name("Miss","Helen","Doris");
	    Passenger p2 = new Passenger(n2,new Date(15,6,1999),1,true);
	    
	    Passenger1.add(p1);
	    Passenger1.add(p2);
	    Passenger2.add(new Passenger(new Name("Ms","Helen","Doris"),
	    		                     new Date(3,5,2016),0,true)); 

	    
	    System.out.println(Passenger1);
	    System.out.println(Passenger2);


	    Flight outboundFlight = new Flight("CI330","Taipei","Dublin",new Date(01,12,2021),new Time(06,50),16.99);
        System.out.println(outboundFlight);
        
        Flight outboundFlightTest = new Flight("CI320","Dublin","Derry",new Date(17,12,2021),new Time(05,10),16.99);
        
	    Flight inboundFlight = new Flight("CI350","Dublin","London",new Date(30,11,2021),new Time(11,15),24.99);
        System.out.println(inboundFlight);
        
		if(outboundFlight.equals(inboundFlight))
			System.out.println(outboundFlight + " is the same flight as "+ inboundFlight);
		else
			System.out.println(outboundFlight + " is not the same flight as "+ inboundFlight);
		
		if(outboundFlight.equals(outboundFlightTest))
			System.out.println(outboundFlight + " is the same flight as "+ outboundFlightTest);
		else
			System.out.println(outboundFlight + " is not the same flight as "+ outboundFlightTest);
		
		Booking Booking1 = new Booking(outboundFlight, inboundFlight, Passenger1);
		Booking Booking2 = new Booking(outboundFlightTest, inboundFlight, Passenger2);
		Booking Booking3 = new Booking(outboundFlightTest, Passenger2);

	    System.out.println(Booking1);
	    System.out.println(Booking2);
	    System.out.println(Booking3);
		
	    
	}
}