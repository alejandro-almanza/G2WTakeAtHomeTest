package com.g2llc.takehometest.model;

public class AirportDTO {
	private String name;
	private String city;
	private String country;
	private String iata3;
	private String latitute;
	private String longitude;

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIata3() {
		return iata3;
	}
	public void setIata3(String iata3) {
		this.iata3 = iata3;
	}
	public String getLatitute() {
		return latitute;
	}
	public void setLatitute(String latitute) {
		this.latitute = latitute;
	}
}
