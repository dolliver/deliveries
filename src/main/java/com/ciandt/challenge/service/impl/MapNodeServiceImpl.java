package com.ciandt.challenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.challenge.entity.MapNode;
import com.ciandt.challenge.entity.MapPath;
import com.ciandt.challenge.repository.MapNodeRepository;
import com.ciandt.challenge.repository.MapNodeRepository.ShortestPath;
import com.ciandt.challenge.service.MapNodeService;
import com.ciandt.challenge.util.ShortestPathCalculator;

@Service
public class MapNodeServiceImpl implements MapNodeService {

	@Autowired
	MapNodeRepository nodeRepository;

	@Autowired
	Neo4jTemplate template;

	@Override
	@Transactional
	public MapNode save(MapNode node) {
		node = template.save(node);
		return node;
	}

	@Override
	@Transactional(readOnly = true)	
	public ShortestPathCalculator getShortestPath(String startNode,
			String toNode, Long routesMapId) {
		
		ShortestPath shortestPath = nodeRepository.getShortestPath(startNode, toNode, routesMapId);
		
		if (shortestPath != null) {
			Double distance = shortestPath.getTotalDistance();
			List<String> nodeNames = shortestPath.getNodeNames();
			ShortestPathCalculator calculator = new ShortestPathCalculator();
			calculator.setTotalDistance(distance);
			calculator.setFullPath(nodeNames.toString());
			return calculator;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public MapPath savePath(MapPath path) {
		path = template.save(path);
		return path;
	};

}
