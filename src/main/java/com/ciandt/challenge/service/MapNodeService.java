package com.ciandt.challenge.service;

import com.ciandt.challenge.entity.MapNode;
import com.ciandt.challenge.entity.MapPath;

public interface MapNodeService {


	MapNode save(MapNode node);
	MapPath savePath(MapPath path);

	MapNode findByPropertyValue(String property, Object value);
	Object shortestWay(String startNode, String toNode);

}
