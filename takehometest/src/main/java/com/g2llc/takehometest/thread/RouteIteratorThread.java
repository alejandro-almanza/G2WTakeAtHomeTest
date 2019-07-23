package com.g2llc.takehometest.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

import com.g2llc.takehometest.model.DataHolder;
import com.g2llc.takehometest.model.RouteDTO;

public class RouteIteratorThread extends Thread {

	private List<String> iteratedNodes;
	private Map<String, List<String>> iteratedNodesForRoutes;
	private Set<RouteDTO> initialRoutes;
	private String destination;
	ExecutorService executorService;

	public RouteIteratorThread(List<String> iteratedNodes, Map<String, List<String>> iteratedNodesForRoutes,
			Set<RouteDTO> initialRoutes, String destination, ExecutorService executorService) {
		super();
		this.iteratedNodes = iteratedNodes;
		this.iteratedNodesForRoutes = iteratedNodesForRoutes;
		this.initialRoutes = initialRoutes;
		this.destination = destination;
		this.executorService = executorService;
	}

	@Override
	public void run() {
		// We iterate the possible paths
		initialRoutes.forEach(route -> {
			// First, we make sure we are not iterating a previously iterated node in the
			// current route search
			// If so, then we should not go on
			if (!iteratedNodes.contains(route.getDestination())) {
				// Then, we verify if a previous route search has gone through this node
				List<String> previousNodes = iteratedNodesForRoutes.get(route.getDestination());

				// If no other route search has passed, we write down the path
				// If the current route search is better than the previous one, then we write
				// the path
				if (previousNodes.isEmpty()
						|| (!previousNodes.isEmpty() && (iteratedNodes.size() < previousNodes.size()))) {
					List<String> iteratedForThisNode = new ArrayList<>(iteratedNodes);
					iteratedForThisNode.add(route.getOrigin());
					synchronized (iteratedNodesForRoutes) {
						iteratedNodesForRoutes.put(route.getDestination(), iteratedForThisNode);
					}

					// If the node matches the destination, we are done with the current route
					// search
					if (!route.getDestination().equals(destination)) {
						RouteIteratorThread iteratorThread = new RouteIteratorThread(iteratedForThisNode,
								iteratedNodesForRoutes, getRouteWithOrigin(route.getDestination()), destination, executorService);
						executorService.execute(iteratorThread);
					}
				}
			}
		});
	}

	private Set<RouteDTO> getRouteWithOrigin(String origin) {
		return DataHolder.ROUTES.stream().filter(route -> origin.equals(route.getOrigin())).collect(Collectors.toSet());
	}

}