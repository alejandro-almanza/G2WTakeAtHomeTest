package com.g2llc.takehometest.fileio;

import com.g2llc.takehometest.model.RouteDTO;

public class RouteMapper {

	public static RouteDTO map(String[] fields) {
		RouteDTO routeDTO = new RouteDTO();
		
		routeDTO.setAirlineId(fields[0]);
		routeDTO.setOrigin(fields[1]);
		routeDTO.setDestination(fields[2]);
		
		return routeDTO;
	}

}
