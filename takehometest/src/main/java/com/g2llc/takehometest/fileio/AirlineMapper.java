package com.g2llc.takehometest.fileio;

import com.g2llc.takehometest.model.AirlineDTO;

public class AirlineMapper {

	public static AirlineDTO map(String[] fields) {
		AirlineDTO airlineDTO = new AirlineDTO();
		
		airlineDTO.setName(fields[0]);
		airlineDTO.setTwoDigitCode(fields[1]);
		airlineDTO.setTreeDigitCode(fields[2]);
		airlineDTO.setCountry(fields[3]);
		
		return airlineDTO;
	}

}
