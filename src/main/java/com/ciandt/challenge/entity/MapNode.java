package com.ciandt.challenge.entity;




import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class MapNode {
	
	@GraphId Long id;
	
	@Indexed(indexType=IndexType.FULLTEXT, indexName = "name")
	String name;

    public MapNode() {
		super();
	}
     
	@RelatedToVia(direction= Direction.BOTH, type="CONNECTED_TO")
	@Fetch
    Set<MapPath> paths=new HashSet<MapPath>();
	
    @RelatedTo(type = "CONNECTED_TO", direction = Direction.BOTH)
    Set<MapNode> originNodes;
	
	
    public MapPath connectTo(MapNode endNode, Double distance) {
    	MapPath path=new MapPath(distance, this, endNode);
    	paths.add(path);
        return path;
    }
	public MapNode(String name) {
		super();
		this.name = name;
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
	public Set<MapPath> getDestinations() {
		return paths;
	}
	public void setDestinations(Set<MapPath> paths) {
		this.paths = paths;
	}
	
	
    
    


}