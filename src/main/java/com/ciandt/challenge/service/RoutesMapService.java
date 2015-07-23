package com.ciandt.challenge.service;

import com.ciandt.challenge.entity.RoutesMap;

public interface RoutesMapService {

	RoutesMap save(RoutesMap map);
	RoutesMap delete(RoutesMap map);	
	RoutesMap findById(Long id) ;
}
