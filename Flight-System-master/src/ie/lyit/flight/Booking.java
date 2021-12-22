package ie.lyit.flight;

import java.util.ArrayList;

public class Booking {
	
	////the instance variables of the class.
	//Set private arraylist, totalfare, bookingflightnumber, inboundflight, outboundflight.
	//To protect the data safety.
	private ArrayList<Passenger> passengess;
	
	private double totalFare;
	
	private int bookingFlightNumber;
	
	private Flight inboundFlight;
	
	private Flight outboundFlight;
	
	private static int nextFlightNumber = 00353001;

	//Write the constructor, with no parameters and set the instance variable=0.
	public Booking(){
	
	this.bookingFlightNumber = nextFlightNumber++;
		
	this.outboundFlight= new Flight();
		
	this.inboundFlight = new Flight();
		
	this.passengess = new ArrayList<Passenger>();
		
	this.totalFare = 0.0;
	}
	
	//Write the second constructor, with parameters. 
	//Initialize the parameters to the instance variable without inbound.
	public Booking(Flight otb, ArrayList<Passenger> pgs){
	
	this.bookingFlightNumber = nextFlightNumber++;
	
	this.outboundFlight=otb;
	
	this.inboundFlight=null;
	
	this.passengess=pgs;
	
	this.totalFare=calculateTotalFare();	
	
	// Check if the user has not type anything, the system return the error with below comment.
	if (otb==null)
		
		throw new IllegalArgumentException("You have not type anything for OutBound Flight yet.");	
	
	// Check if the user type the number not between 1 to 9, the system return the error with below comment.
	if (passengess.size()<1 || passengess.size()>9)
	
		throw new IllegalArgumentException("Passengers number shoule be between 1 to 10.");		
}
	
	//Write the thrid constructor, with parameters. 
	//Initialize the parameters to the instance variable with outbound, inbound and arraylist.
	public Booking(Flight otb, Flight ibd, ArrayList<Passenger> pgs){
		
		this.bookingFlightNumber = nextFlightNumber++;
		
		this.outboundFlight = otb;
		
		this.inboundFlight= ibd;
		
		this.passengess=pgs;
		
		this.totalFare=calculateTotalFare();
		
		// Check if the user has not type anything, the system return the error with below comment.
		if (otb == null)
			   throw new IllegalArgumentException("You have not type anything for OutBound Flight yet.");		
		
		// Check if the user type the number not between 1 to 9, the system return the error with below comment.
		if (pgs.size() < 1 || pgs.size() > 9)
			   throw new IllegalArgumentException("Passengers number shoule be between 1 to 10.");		
	}
	
	//get method
	public Flight getOutboundFlight() {
		return this.outboundFlight;
	}
	
	public Flight getInboundFlight() {
		return this.inboundFlight;
	}
	
	public ArrayList<Passenger> getPassengers(){
		return this.passengess;
	}
	
	//set method
	public void setOutboundFlight(Flight outbound) {
		// Check the outbound flight number should at least 1 and no more than 10.
		if (outbound == null)
		throw new IllegalArgumentException("they should be outbound filght in the booking.");
		
		this.outboundFlight = outbound;
		}
		
		
		public void setInboundFlight(Flight inbound) {
			this.inboundFlight = inbound;
		}
		
		// Check the passengers array number at least 1 and no more than 10.
		public void setPassengers(ArrayList<Passenger> passengess) {
		if (passengess.size() < 1 || passengess.size() > 9)
		throw new IllegalArgumentException("Passengers number shoule be between 1 to 10.");		
			
		this.passengess = passengess;
		}
	
	//toString method
	public String toString() {
	
		String string;
		
		//Check if inboundflight is no booking return outbound flight information and have not found out inboundflight yet.
		if (inboundFlight == null)
			string = 
			"Total Fare is : "+this.totalFare+
			
			"Passengers: "+this.passengess +
		
			"Booking Flight Number: "+this.bookingFlightNumber + 
				    	
			"Outbound Flight: "+this.outboundFlight +
			
			"Return Flight: Have not found out it yet";
		else
		//otherwise reutrn the flight information.
			string = 

			"Outbound Flight: "+this.outboundFlight+
		
		     "Inbound Flight: "+this.inboundFlight+
			
			"Total Fare: "+this.totalFare+	
			
			"Passengers: "+this.passengess+
			
			"Booking Flight Number: "+this.bookingFlightNumber;
			
		return string;
	}
	
	// equals method
	public boolean equals(Object object) {
		
		Booking bookingObject;
		
		if (object instanceof Booking)
		
			bookingObject = (Booking)object;
		
		else
			
			return false;
		
		return this.bookingFlightNumber == (bookingObject.bookingFlightNumber);	
	}
	
	public boolean findoutPassenger(Object passengerObject) {
		
		boolean ispFlag = false;

		if (passengerObject instanceof Passenger)

		for(Passenger tmpPassengers : passengess)
			
		if (tmpPassengers.equals(passengerObject))
				
		ispFlag = true;
		
		return ispFlag;
	}
	
	//calculate total fare method
	public double calculateTotalFare() {
		
		double Money = 0;
		
		int totalNumberOfPassengers = this.passengess.size() ;
		
		double outboundPrice = outboundFlight.getPrice();
		
		if (inboundFlight == null)
			
			Money = outboundPrice * totalNumberOfPassengers;
		
		else
			
			{double inboundPrice = inboundFlight.getPrice();
			
			Money = (outboundPrice + inboundPrice) * totalNumberOfPassengers;}

		return Money;
	}
}