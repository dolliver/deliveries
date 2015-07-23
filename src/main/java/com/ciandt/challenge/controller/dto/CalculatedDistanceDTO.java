package com.ciandt.challenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatedDistanceDTO {
	
	private String route;
	private Double totalDistance;
	private Double mileage;
	private Double gastPrice;
	private Double deliveryCost;
	
	public CalculatedDistanceDTO(String route, Double totalDistance,
			Double mileage, Double gastPrice, Double deliveryCost) {
		super();
		this.route = route;
		this.totalDistance = totalDistance;
		this.mileage = mileage;
		this.gastPrice = gastPrice;
		this.deliveryCost = deliveryCost;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public Double getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}
	public Double getMileage() {
		return mileage;
	}
	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}
	public Double getGastPrice() {
		return gastPrice;
	}
	public void setGastPrice(Double gastPrice) {
		this.gastPrice = gastPrice;
	}
	public Double getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(Double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	

	
	
	

}
