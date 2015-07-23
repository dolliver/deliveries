package com.ciandt.challenge.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.MapResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.ResultColumn;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.ciandt.challenge.entity.MapNode;
import com.ciandt.challenge.entity.MapPath;
import com.ciandt.challenge.entity.RoutesMap;

public interface MapNodeRepository extends GraphRepository<MapNode> {
	
	
	//Uses Cypher query on graph database to find the shortest path between the graphs
	 @Query("START  startNode=node:name(name = {0}), " +
			   "    endNode=node:name(name = {1}) " +
			   "    MATCH  p= (startNode)<-[:CONNECTED_TO*]->(endNode)" + 
			   "    WHERE startNode.routesMapId = {2} AND endNode.routesMapId = {2} " +
			    "   RETURN p AS shortestPath,       "+
			   "           reduce(distance=0, r in relationships(p) | distance+r.distance) AS totalDistance,"
			   + "           EXTRACT(n in NODES(p) | n.name) as nodeNames"
			   + "		 "+
			   "           ORDER BY totalDistance ASC  "+
			   "           LIMIT 1;")
	 ShortestPath getShortestPath(String startNode, String toNode, Long routesMapId);
	 
	 
	 	//Interface used to transform the result in a map with the values needed
	    @SuppressWarnings("deprecation")
		@MapResult
	    public interface ShortestPath {
	        @ResultColumn("shortestPath")
	        MapPath getShortestPath();

	        @ResultColumn("totalDistance")
	        Double getTotalDistance();
	        
	        @ResultColumn("nodeNames")
	        List<String> getNodeNames();	        
	        
	    }	 
}