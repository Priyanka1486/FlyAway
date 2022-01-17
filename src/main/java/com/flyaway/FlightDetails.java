package com.flyaway;

import java.sql.Time;

public class FlightDetails {

	private double price;
	private int flight_no;
	private Time departure_time;
	private Time arrival_time;
	private int available_seat;
	private int route_id;
	
	public FlightDetails() {
		
	}

	public FlightDetails(double price, Time departure_time, Time arrival_time, int available_seat,int route_id) {
		this.price = price;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.available_seat = available_seat;
		this.route_id = route_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}

	public Time getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Time departure_time) {
		this.departure_time = departure_time;
	}

	public Time getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(Time arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getAvailable_seat() {
		return available_seat;
	}

	public void setAvailable_seat(int available_seat) {
		this.available_seat = available_seat;
	}
}