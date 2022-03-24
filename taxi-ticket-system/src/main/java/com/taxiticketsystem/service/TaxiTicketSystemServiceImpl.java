package com.taxiticketsystem.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.taxiticketsystem.model.TravelData;

@Service
public class TaxiTicketSystemServiceImpl implements TaxiTicketSystemService {

	private static final String HEADING = "Taxi Ticket \n----------- \n";
	
	private static Map<String, String> routeData = new HashMap<String, String>();
	
	@Override
	public String calculateFare(TravelData travelData) {
		
		String routeKey = "";
		
		if(routeData.containsKey(travelData.getSource()+ "-" +travelData.getDestination())) {
			routeKey = travelData.getSource()+ "-" +travelData.getDestination();
		}
		else if(routeData.containsKey(travelData.getDestination()+ "-" +travelData.getSource())) {
			routeKey = travelData.getDestination()+ "-" +travelData.getSource();
		}
		else {
			return "No data available for given routes";
		}
		
		int totalFare = Integer.parseInt(routeData.get(routeKey).split(":")[1]) * travelData.getNoOfTravellers();
		
		StringBuilder fareData = new StringBuilder();
		fareData.append(HEADING);
		fareData.append("Source: "+travelData.getSource() +"\n");
		fareData.append("Destination: "+travelData.getDestination() +"\n");
		fareData.append("Kms: "+routeData.get(routeKey).split(":")[0] +"\n");
		fareData.append("No of Travellers = "+travelData.getNoOfTravellers() +"\n");
		fareData.append("Total = "+ totalFare + " INR");
		
		return fareData.toString();
	}

	@Override
	public void loadData(Map<String, Integer> routes) {
		
		routeData = routes.entrySet()
						.stream()
						.collect(Collectors.toMap(
								e -> e.getKey(), 
								e -> new String(e.getValue()+":"+(750 + ((e.getValue()-100)*5)))));		
	}

}
