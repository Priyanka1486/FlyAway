package com.flyaway;

public class BookingDetails {
	int booking_id;
	String traveldate;
	int flight_no;
	String useremail;
	int no_of_passengers;
	
	public BookingDetails() {
		
	}
	public BookingDetails(String traveldate, int flight_no, String useremail, int no_of_passengers) {
		this.traveldate = traveldate;
		this.flight_no = flight_no;
		this.useremail = useremail;
		this.no_of_passengers = no_of_passengers;
	}
	
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getTraveldate() {
		return traveldate;
	}
	public void setTraveldate(String traveldate) {
		this.traveldate = traveldate;
	}
	public int getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public int getNo_of_passengers() {
		return no_of_passengers;
	}
	public void setNo_of_passengers(int no_of_passengers) {
		this.no_of_passengers = no_of_passengers;
	}
	@Override
	public String toString() {
		return "BookingDetails [booking_id=" + booking_id + ", traveldate=" + traveldate + ", flight_no=" + flight_no
				+ ", useremail=" + useremail + ", no_of_passengers=" + no_of_passengers + "]";
	}
}
