package ie.lyit.flight;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BookingTest {
	
	//create booking object
	private Booking booking;
	
	//create flights
	Flight outboundFlight = new Flight("CI330","Taipei","Dublin",new Date(01,12,2021),new Time(06,50),16.99);
    
	Flight emptyOutboundFlight = new Flight();
    
	Flight inboundFlight = new Flight("CI320","Dublin","Derry",new Date(17,12,2021),new Time(05,10),16.99);
	
	//create arraylist of passengers
	ArrayList<Passenger> passengess = new ArrayList<Passenger>();
	//create emptyarraylist
	ArrayList<Passenger> emptyPassengers = new ArrayList<Passenger>();
	//create arraylist of 20 passengers
	ArrayList<Passenger> passengers20 = new ArrayList<Passenger>();
    
	Passenger p1 = new Passenger(new Name("Mr","Mankit","Siu"),new Date(12,9,1995),1,true);
    
    
    @Before
	public void setUp() throws Exception {
    	
    	passengess.add(p1);
		
    	booking = new Booking(outboundFlight,
    									    inboundFlight, 
    									    passengess);
		
    	for (int i = 1; i < 20; i++)
	    
    		passengers20.add(p1);
	}

	@Test
	public void testBooking() {

		assertEquals(outboundFlight, 
							booking.getOutboundFlight());
		
		assertEquals(inboundFlight, 
							booking.getInboundFlight());
		
		assertEquals(passengess, 
							booking.getPassengers());
	}

	@Test
	public void testBookingFlightArrayListOfPassenger() {
		
		booking.setPassengers(passengess);
		
		assertEquals(passengess,
							booking.getPassengers());
	}

	@Test(expected = IllegalArgumentException.class)
	
	public void testBookingFlighArrayListOfPassenger2() {
		
		booking.setPassengers(emptyPassengers);
		
		assertEquals(emptyPassengers, booking.getPassengers());	
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	
	public void testBookingArrayListOfPassenger3() {
		
		booking.setPassengers(passengers20);
		
		assertEquals(passengers20, booking.getPassengers());	
	}


	@Test
	public void testSetOutboundFlight() {
		booking.setOutboundFlight(outboundFlight);
		
		assertEquals(outboundFlight, 
							booking.getOutboundFlight());
	}
	
	@Test
	public void testSetOutboundFlight2() {
		booking.setOutboundFlight(emptyOutboundFlight);
		
		assertEquals(emptyOutboundFlight, 
							booking.getOutboundFlight());
	}

	@Test
	public void testSetInboundFlight() {
		booking.setInboundFlight(inboundFlight);
		
		assertEquals(inboundFlight, 
							booking.getInboundFlight());
	}

	@Test
	public void testSetPassengers() {
		booking.setPassengers(passengess);
		
		assertEquals(passengess, 
							booking.getPassengers());	}


	
	@Test
	public void testfindoutPassenger() {
		booking.findoutPassenger(p1);
		
		assertTrue( booking.findoutPassenger(p1) == true);
	}
	
	
	@Test
	public void testcalculateTotalFare() {
		
		assertTrue( booking.calculateTotalFare() == 33.98);
	}
}
