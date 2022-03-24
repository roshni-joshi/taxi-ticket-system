package com.taxiticketsystem.bootstrap;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.taxiticketsystem.service.TaxiTicketSystemService;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private TaxiTicketSystemService taxiTicketSystemService; 
	
	@Override
	public void run(String... args) throws Exception {
		
		Map<String, Integer> routes = new HashMap<String, Integer>();
		routes.put("PUNE-MUMBAI", 120);
		routes.put("PUNE-NASIK", 200);
		routes.put("MUMBAI-GOA", 350);
		routes.put("MUMBAI-NASIK", 180);
		
		taxiTicketSystemService.loadData(routes);
	}

}
