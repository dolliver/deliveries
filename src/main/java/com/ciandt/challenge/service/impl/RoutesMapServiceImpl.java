package com.ciandt.challenge.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.challenge.entity.RoutesMap;
import com.ciandt.challenge.repository.RoutesMapRepository;
import com.ciandt.challenge.service.RoutesMapService;



@Service
public class RoutesMapServiceImpl implements RoutesMapService {

	@Autowired
	RoutesMapRepository mapRepository;
	
	@Override
	@Transactional
	public RoutesMap save(RoutesMap map){
		map = mapRepository.save(map);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<RoutesMap> findAll(){
		return (List<RoutesMap>) mapRepository.findAll().as(Collection.class);

	}

	
}
