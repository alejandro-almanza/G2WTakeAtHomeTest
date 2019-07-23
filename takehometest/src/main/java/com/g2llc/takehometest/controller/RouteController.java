package com.g2llc.takehometest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g2llc.takehometest.service.RouteService;

@Controller
@RequestMapping(value = "/shortestroute")
public class RouteController {

	@Autowired
	private RouteService routeService;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody List<String> getShortestRoute(@RequestParam(name = "origin") String origin,
			@RequestParam(name = "destination") String destination) throws Exception {
 
		routeService.validateInput(origin, destination);
		
        return routeService.getShortestRoute(origin, destination);
    } 
	
}
