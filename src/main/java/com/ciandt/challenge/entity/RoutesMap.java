package com.ciandt.challenge.entity;

import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class RoutesMap {

	@GraphId Long id;
	String name;
	Set<MapNode> nodes;
	
	public RoutesMap() {
		super();
	}

	public RoutesMap(Long id, String name, Set<MapNode> nodes) {
		super();
		this.id = id;
		this.name = name;
		this.nodes = nodes;
	}

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

}