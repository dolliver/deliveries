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
	
	@GraphId
	Long id;	
	
    Long routesMapId;	
    
	@Indexed(indexType=IndexType.FULLTEXT, indexName = "name")
	String name;	


    public MapNode() {
		super();
	}
    
	public MapNode(String name) {
		super();
		this.name = name;
	}    
     
	@RelatedToVia(direction= Direction.BOTH, type="CONNECTED_TO")
	@Fetch
    Set<MapPath> paths=new HashSet<MapPath>();
	
    @RelatedTo(type = "CONNECTED_TO", direction = Direction.BOTH)
    Set<MapNode> originNodes;
    
    
    //Creates a connection between the graphs with the distance as weight
    public MapPath connectTo(MapNode endNode, Double distance) {
    	MapPath path=new MapPath(distance, this, endNode);
    	paths.add(path);
        return path;
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
	public Set<MapPath> getPaths() {
		return paths;
	}
	public void setPaths(Set<MapPath> paths) {
		this.paths = paths;
	}
	public Set<MapNode> getOriginNodes() {
		return originNodes;
	}
	public void setOriginNodes(Set<MapNode> originNodes) {
		this.originNodes = originNodes;
	}
	public Long getRoutesMapId() {
		return routesMapId;
	}
	public void setRoutesMapId(Long routesMapId) {
		this.routesMapId = routesMapId;
	}
	
	//Need hashCode and equals to find object in lists and sets
	//and compare to existing objects
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapNode other = (MapNode) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	

	

	
	
	
	
	
    
    


}