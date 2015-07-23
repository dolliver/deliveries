package com.ciandt.challenge.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.ciandt.challenge.entity.MapNode;

public interface MapNodeRepository extends GraphRepository<MapNode> {
	
	 @Query("START  startNode=node:name(key = {0}), "+
			   "    endNode=node:name(key = {1})     "+
			   "    MATCH  p=(startNode)<-[:CONNECTED_TO*]->(endNode)  "+ 
			   "    RETURN p AS shortestPath,       "+
			   "           reduce(distance=0, r in relationships(p) | distance+r.distance) AS totalDistance  "+
			   "           ORDER BY totalDistance ASC  "+
			   "           LIMIT 1;")
		Object shortestWay(String startNode, String toNode);
	 
	 
	 /*
	
	
	@Query("START  startNode=node:node_auto_index(name=\"A\"), "+
		   "    endNode=node:node_auto_index(name=\"B\")     "+
		   "    MATCH  p=(startNode)-[:CONNECTED_TO*]->(endNode)  "+ 
		   "    RETURN p AS shortestPath,       "+
		   "           reduce(distance=0, r in relationships(p) : distance+r.distance) AS totalDistance  "+
		   "           ORDER BY totalDistance ASC  "+
		   "           LIMIT 1;")
	 Iterable<EntityPath<MapNode, MapNode>> shortestWay(Long fromid, Long toid);
	 */

}