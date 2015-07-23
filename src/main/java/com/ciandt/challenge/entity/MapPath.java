package com.ciandt.challenge.entity;


import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "CONNECTED_TO")
public class MapPath {
  @GraphId Long pathId;
  Double distance;
  @StartNode private MapNode startNode;
  @EndNode private MapNode endNode;
  
  
  
public MapPath() {
	super();
}
public MapPath(Double distance, MapNode startNode, MapNode endNode) {
	super();
	this.distance = distance;
	this.startNode = startNode;
	this.endNode = endNode;
}
public Double getDistance() {
	return distance;
}
public void setDistance(Double distance) {
	this.distance = distance;
}
public MapNode getStartNode() {
	return startNode;
}
public void setStartNode(MapNode startNode) {
	this.startNode = startNode;
}
public MapNode getEndNode() {
	return endNode;
}
public void setEndNode(MapNode endNode) {
	this.endNode = endNode;
}
  
  


}