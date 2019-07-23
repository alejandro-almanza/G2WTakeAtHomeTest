package com.g2llc.takehometest.fileio;

import com.g2llc.takehometest.model.AirportDTO;

public class AirportMapper {

	public static AirportDTO map(String[] fields) {
		AirportDTO airportDTO = new AirportDTO();
		
		airportDTO.setName(fields[0]);
		airportDTO.setCity(fields[1]);
		airportDTO.setCountry(fields[2]);
		airportDTO.setIata3(fields[3]);
		
		return airportDTO;
	}

}
