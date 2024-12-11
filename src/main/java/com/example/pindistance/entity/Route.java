package com.example.pindistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromPincode;
    private String toPincode;
    private double distance;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromPincode() {
		return fromPincode;
	}
	public void setFromPincode(String fromPincode) {
		this.fromPincode = fromPincode;
	}
	public String getToPincode() {
		return toPincode;
	}
	public void setToPincode(String toPincode) {
		this.toPincode = toPincode;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getRouteDetails() {
		return routeDetails;
	}
	public void setRouteDetails(String routeDetails) {
		this.routeDetails = routeDetails;
	}
	private String duration;
    @Lob
    private String routeDetails; // Store the route as JSON string
}


