package com.ciandt.challenge.service;

import java.util.List;

import com.ciandt.challenge.entity.RoutesMap;

public interface RoutesMapService {

	RoutesMap save(RoutesMap map);

	List<RoutesMap> findAll();	
}
