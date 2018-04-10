package com.wedding.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Venue {

	private String venue_name;
	private String location;
	private String city;
	private Double venue_rating;
	private Integer price;
	private String type;
	@DBRef
	private User userName;
	public String getVenue_name() {
		return venue_name;
	}

	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getVenue_rating() {
		return venue_rating;
	}

	public void setVenue_rating(Double venue_rating) {
		this.venue_rating = venue_rating;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
