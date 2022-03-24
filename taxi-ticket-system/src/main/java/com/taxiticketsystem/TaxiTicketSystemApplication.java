package com.taxiticketsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taxiticketsystem.model.TravelData;
import com.taxiticketsystem.service.TaxiTicketSystemService;
import com.taxiticketsystem.service.TaxiTicketSystemServiceImpl;

@SpringBootApplication
public class TaxiTicketSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiTicketSystemApplication.class, args);
		
		TaxiTicketSystemService s = new TaxiTicketSystemServiceImpl();
		
		System.out.println(s.calculateFare(new TravelData("PUNE", "NASIK", 2)));
		System.out.println(s.calculateFare(new TravelData("NASIK", "PUNE", 2)));
		System.out.println(s.calculateFare(new TravelData("NASIK", "GOA", 2)));
		System.out.println(s.calculateFare(new TravelData("MUMBAI", "GOA", 3)));
		System.out.println(s.calculateFare(new TravelData("NASIK", "MUMBAI", 1)));
	}

}
