package com.ciandt.challenge.entity;

import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Map {

  @GraphId Long id;
  String name;
  Set<MapNode> nodes;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<MapNode> getNodes() {
	return nodes;
}

public void setNodes(Set<MapNode> nodes) {
	this.nodes = nodes;
}



 // Person director;

 // @RelatedTo(type="ACTS_IN", direction = INCOMING)
 // Set<Person> actors;

  //@RelatedToVia(type = "RATED")
  //Iterable<Rating> ratings;
  
  

}