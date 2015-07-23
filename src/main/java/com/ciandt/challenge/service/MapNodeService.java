package com.ciandt.challenge.service;

import com.ciandt.challenge.entity.MapNode;
import com.ciandt.challenge.entity.MapPath;
import com.ciandt.challenge.entity.RoutesMap;
import com.ciandt.challenge.util.ShortestPathCalculator;

public interface MapNodeService {


	MapNode save(MapNode node);
	MapPath savePath(MapPath path);
	MapNode delete(MapNode node);
	ShortestPathCalculator getShortestPath(String startNode, String toNode, Long routesMapId);

}
