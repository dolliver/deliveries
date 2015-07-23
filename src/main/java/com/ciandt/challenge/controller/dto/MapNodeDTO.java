package com.ciandt.challenge.controller.dto;

import com.ciandt.challenge.entity.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapNodeDTO {
	
	private String startingPoint;
	private String destinationPoint;
	private Double distance;
	
	public String getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	public String getDestinationPoint() {
		return destinationPoint;
	}
	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
   }
		
	
	

}
