package com.taxiticketsystem;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.taxiticketsystem.model.TravelData;
import com.taxiticketsystem.service.TaxiTicketSystemService;
import com.taxiticketsystem.service.TaxiTicketSystemServiceImpl;

@RunWith(Parameterized.class)
public class CalculateTicketFareTest {

	private TaxiTicketSystemService taxiTicketSystemService;
	
	private TravelData input;
	private String expectedOutput;
	
	public CalculateTicketFareTest(TravelData input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testConditions() {
		Object inputOutputs[][] = {
				{new TravelData("PUNE", "NASIK", 2), "Taxi Ticket \n----------- \nSource: PUNE\nDestination: NASIK\nKms: 200\nNo of Travellers = 2\nTotal = 2500 INR"},
				{new TravelData("NASIK", "PUNE", 2), "Taxi Ticket \n----------- \nSource: NASIK\nDestination: PUNE\nKms: 200\nNo of Travellers = 2\nTotal = 2500 INR"},
				{new TravelData("PUNE", "GOA", 2), "No data available for given routes"},
				{new TravelData("MUMBAI", "GOA", 3), "Taxi Ticket \n----------- \nSource: MUMBAI\nDestination: GOA\nKms: 350\nNo of Travellers = 3\nTotal = 6000 INR"},
				{new TravelData("NASIK", "MUMBAI", 1), "Taxi Ticket \n----------- \nSource: NASIK\nDestination: MUMBAI\nKms: 180\nNo of Travellers = 1\nTotal = 1150 INR"}
		};
		
		return Arrays.asList(inputOutputs);
	}

	@Before
	public void setUp() {
		taxiTicketSystemService = new TaxiTicketSystemServiceImpl();
		Map<String, Integer> routes = new HashMap<String, Integer>();
		routes.put("PUNE-MUMBAI", 120);
		routes.put("PUNE-NASIK", 200);
		routes.put("MUMBAI-GOA", 350);
		routes.put("MUMBAI-NASIK", 180);
		
		taxiTicketSystemService.loadData(routes);
	}
	
	@Test
	public void testCalculateFare() {
		assertEquals(expectedOutput, taxiTicketSystemService.calculateFare(input));
	}

}
