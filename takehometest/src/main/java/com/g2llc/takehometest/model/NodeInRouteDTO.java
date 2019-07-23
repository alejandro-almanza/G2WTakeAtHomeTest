package com.g2llc.takehometest.model;

import java.util.HashSet;
import java.util.Set;

public class NodeInRouteDTO {
	private String airport;
	private Set<String> previousAirports = new HashSet<>();
	
	public NodeInRouteDTO(String airport) {
		this.airport = airport;
	}

	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public Set<String> getPreviousAirports() {
		return previousAirports;
	}
	public void setPreviousAirports(Set<String> previousAirports) {
		this.previousAirports = previousAirports;
	}
}
