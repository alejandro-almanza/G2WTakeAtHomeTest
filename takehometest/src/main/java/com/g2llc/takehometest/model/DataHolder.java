package com.g2llc.takehometest.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataHolder {
	public static Map<String, AirlineDTO> AIRLINES = new HashMap<>();
	public static Map<String, AirportDTO> AIRPORTS = new HashMap<>();
	public static Set<RouteDTO> ROUTES = new HashSet<>();
	public static Set<String> NODES = new HashSet<>();
}
