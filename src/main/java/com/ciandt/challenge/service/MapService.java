package com.ciandt.challenge.service;

import java.util.List;

import com.ciandt.challenge.entity.Map;

public interface MapService {

	Long findShortestRoute();

	Map save(Map map);

	List<Map> findAll();	
}
