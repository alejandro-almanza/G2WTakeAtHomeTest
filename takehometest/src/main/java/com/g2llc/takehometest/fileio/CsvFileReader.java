package com.g2llc.takehometest.fileio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

@Component
public class CsvFileReader {
	public List<String[]> readData(String file) throws IOException {

		List<String[]> records = new ArrayList<String[]>();
		InputStream is = getClass().getResourceAsStream(file);
		
		
		try (CSVReader csvReader = new CSVReader(new InputStreamReader(is))) {
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				records.add(values);
			}
		}

		return records;
	}
}
