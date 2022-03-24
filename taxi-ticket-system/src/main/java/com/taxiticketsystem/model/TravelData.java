package com.taxiticketsystem.model;

import org.springframework.stereotype.Component;

@Component
public class TravelData {

	private String source;
	private String destination;
	private Integer noOfTravellers;
	
	public TravelData() {
	}

	public TravelData(String source, String destination, Integer noOfTravellers) {
		super();
		this.source = source;
		this.destination = destination;
		this.noOfTravellers = noOfTravellers;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getNoOfTravellers() {
		return noOfTravellers;
	}

	public void setNoOfTravellers(Integer noOfTravellers) {
		this.noOfTravellers = noOfTravellers;
	}

	@Override
	public String toString() {
		return "TravelData [source=" + source + ", destination=" + destination + ", noOfTravellers=" + noOfTravellers
				+ "]";
	}
}
