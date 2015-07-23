package com.ciandt.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciandt.challenge.controller.dto.CalculatedDistanceDTO;
import com.ciandt.challenge.service.MapService;

public class PointAPIController {
	
	@Autowired
	MapService pointApiService;

	@RequestMapping(value = "/{startingPoint}/to/{destinationPoint}", method = RequestMethod.DELETE)
	@ResponseBody
	public CalculatedDistanceDTO calculateShortestDistance(@PathVariable("startingPoint") String  startingPoint, @PathVariable("startingPoint") String  destinationPoint){
		return null;
	}

	
}
