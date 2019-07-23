package com.g2llc.takehometest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.g2llc.takehometest.model.DataHolder;
import com.g2llc.takehometest.model.RouteDTO;
import com.g2llc.takehometest.thread.RouteIteratorThread;

@Service
public class RouteService {

	public void validateInput(String origin, String destination) throws Exception {
		if(origin.equals(destination)) {
			throw new Exception("The origin and the destinantion are the same, please choose different airports");
		}
		
		if(!DataHolder.NODES.contains(origin) || !DataHolder.NODES.contains(destination)) {
			throw new Exception("Origin is not an actual airport or doesn't contain any connection with other airports");
		}
	}
	
	public List<String> getShortestRoute(String origin, String destination) throws Exception {
		Map<String, List<String>> nodesInRoutes = getNodesInRoutes();
		Set<RouteDTO> initialRoutes = getRouteWithOrigin(origin);

		iterateOverRoutes(new ArrayList<>(), nodesInRoutes, initialRoutes, destination);

		List<String> shortestRoute = nodesInRoutes.get(destination);
		
		if(shortestRoute.isEmpty()) {
			throw new Exception("There's no available route between the two airports");
		}
		
		shortestRoute.add(destination);
		
		return shortestRoute;
	}

	private Set<RouteDTO> getRouteWithOrigin(String origin) {
		return DataHolder.ROUTES.stream().filter(route -> origin.equals(route.getOrigin())).collect(Collectors.toSet());
	}

	private Map<String, List<String>> getNodesInRoutes() {
		Map<String, List<String>> nodesInRoutes = new HashMap<>();

		DataHolder.NODES.forEach(node -> nodesInRoutes.put(node, new ArrayList<>()));

		return nodesInRoutes;
	}

	private void iterateOverRoutes(List<String> iteratedNodes, Map<String, List<String>> iteratedNodesForRoutes,
			Set<RouteDTO> initialRoutes, String destination) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		RouteIteratorThread iteratorThread = new RouteIteratorThread(iteratedNodes, iteratedNodesForRoutes, initialRoutes, destination, executorService);
		executorService.execute(iteratorThread);
		executorService.awaitTermination(15, TimeUnit.MINUTES);
		
	}
}
