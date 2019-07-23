package com.g2llc.takehometest.model;

import java.util.HashSet;
import java.util.Set;

public class RouteCalculationData {

	private RouteDTO origin;
	private RouteDTO destination;
	private RouteDTO current;
	private Set<RouteDTO> previousSteps = new HashSet<>();
	private Set<RouteDTO> nextSteps = new HashSet<>();
	
	public RouteDTO getOrigin() {
		return origin;
	}
	public void setOrigin(RouteDTO origin) {
		this.origin = origin;
	}
	public RouteDTO getDestination() {
		return destination;
	}
	public void setDestination(RouteDTO destination) {
		this.destination = destination;
	}
	public RouteDTO getCurrent() {
		return current;
	}
	public void setCurrent(RouteDTO current) {
		this.current = current;
	}
	public Set<RouteDTO> getPreviousSteps() {
		return previousSteps;
	}
	public void setPreviousSteps(Set<RouteDTO> previousSteps) {
		this.previousSteps = previousSteps;
	}
	public Set<RouteDTO> getNextSteps() {
		return nextSteps;
	}
	public void setNextSteps(Set<RouteDTO> nextSteps) {
		this.nextSteps = nextSteps;
	}
}
