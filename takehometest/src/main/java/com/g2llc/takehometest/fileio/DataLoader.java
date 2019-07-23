package com.g2llc.takehometest.fileio;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.g2llc.takehometest.model.DataHolder;

@Configuration
public class DataLoader {

	@Autowired
	CsvFileReader csvFileReader;

	@Bean
	public void loadData() throws IOException {
		loadRoutes();
	}

	private void loadRoutes() throws IOException {
		List<String[]> routes = csvFileReader.readData("/routes.csv");

		routes.forEach(route -> {
			DataHolder.ROUTES.add(RouteMapper.map(route));
			DataHolder.NODES.add(route[1]);
			DataHolder.NODES.add(route[2]);
		});
	}
}
