package com.flyaway;

public class RouteDetails {

	private int route_id;
	private String source;
	private String destination;
	
	public RouteDetails() {
		
	}
	public RouteDetails(String source, String destination) {
		this.source = source;
		this.destination = destination;
	}
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Override
	public String toString() {
		return "RouteDetails [source=" + source + ", destination=" + destination + "]";
	}
	
	
}
