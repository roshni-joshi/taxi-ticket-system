package com.taxiticketsystem.service;

import java.util.Map;

import com.taxiticketsystem.model.TravelData;

public interface TaxiTicketSystemService {

	void loadData(final Map<String, Integer> routes);
	
	String calculateFare(final TravelData travelData);
}
