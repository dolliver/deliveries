package com.ciandt.challenge.util;


public class ShortestPathCalculator {
	private Double totalDistance;
	private String fullPath;
	private Double mileage;
	private Double gasPrice;
	private Double totalCost;
		
	public ShortestPathCalculator() {
		super();
	}
	public ShortestPathCalculator(Double totalDistance, String fullPath) {
		super();
		this.totalDistance = totalDistance;
		this.fullPath = fullPath;
	}
	public Double getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	public Double getMileage() {
		return mileage;
	}
	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}
	public Double getGasPrice() {
		return gasPrice;
	}
	public void setGasPrice(Double gasPrice) {
		this.gasPrice = gasPrice;
	}
	
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public void calculateCost(){
		if(totalDistance != null && mileage != null && gasPrice != null) {
			totalCost = totalDistance / mileage * gasPrice;
		} else {
			totalCost = null;
		}
	}
	
	

}
