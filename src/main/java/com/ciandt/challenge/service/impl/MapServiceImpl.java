package com.ciandt.challenge.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.challenge.entity.Map;
import com.ciandt.challenge.repository.MapRepository;
import com.ciandt.challenge.service.MapService;



@Service
public class MapServiceImpl implements MapService {

	@Autowired
	MapRepository mapRepository;
	
	@Override
	public Long findShortestRoute() {
		return null;
	}
	
	@Override
	public Map save(Map map){
		map = mapRepository.save(map);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Map> findAll(){
		return (List<Map>) mapRepository.findAll().as(Collection.class);

	}

	
}
