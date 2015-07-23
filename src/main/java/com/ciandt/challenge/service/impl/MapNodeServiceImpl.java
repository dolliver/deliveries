package com.ciandt.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.challenge.entity.MapNode;
import com.ciandt.challenge.entity.MapPath;
import com.ciandt.challenge.repository.MapNodeRepository;
import com.ciandt.challenge.service.MapNodeService;



@Service
public class MapNodeServiceImpl implements MapNodeService {

	@Autowired
	MapNodeRepository nodeRepository;
	
	@Autowired Neo4jTemplate template;
	
	
	@Override
	@Transactional
	public MapNode save(MapNode node){
		node =  template.save(node);
		return node;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	@Transactional(readOnly = true)
	public MapNode findByPropertyValue(String property, Object value) {
		return nodeRepository.findByPropertyValue(property, value);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Object shortestWay(String startNode, String toNode){
		return nodeRepository.shortestWay(startNode, toNode);
	}

	@Override
	@Transactional
	public MapPath savePath(MapPath path) {
		path =  template.save(path);
		return path;
	};


	
}
