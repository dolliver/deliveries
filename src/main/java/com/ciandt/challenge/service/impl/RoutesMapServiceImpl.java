package com.ciandt.challenge.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.challenge.entity.RoutesMap;
import com.ciandt.challenge.repository.RoutesMapRepository;
import com.ciandt.challenge.service.RoutesMapService;



@Service
public class RoutesMapServiceImpl implements RoutesMapService {

	@Autowired
	RoutesMapRepository mapRepository;
	
	@Autowired
	Neo4jTemplate template;
	
	@SuppressWarnings("deprecation")
	@Override
	@Transactional(readOnly = true)
	public RoutesMap findById(Long id) {
		return mapRepository.findOne(id);
	}	
	
	@Override
	@Transactional
	public RoutesMap save(RoutesMap map){
		map = mapRepository.save(map);
		return map;
	}

	@Override
	@Transactional
	public RoutesMap delete(RoutesMap map) {
		mapRepository.delete(map);
		 return map;
	};	

	
}
