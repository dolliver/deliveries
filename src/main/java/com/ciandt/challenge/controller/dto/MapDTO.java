package com.ciandt.challenge.controller.dto;

import java.util.List;

import com.ciandt.challenge.entity.RoutesMap;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapDTO {
	
	private List<MapNodeDTO> nodes;
	private String name;
	private Long id;
	
	public MapDTO() {
		super();
	}

	public MapDTO(RoutesMap map) {
		super();
		this.name = map.getName();
		this.id = map.getId();
	}

	public List<MapNodeDTO> getNodes() {
		return nodes;
	}

	public void setNodes(List<MapNodeDTO> nodes) {
		this.nodes = nodes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public RoutesMap convertToMap(){
		RoutesMap convertedMap = new RoutesMap();
		convertedMap.setName(name);
		return convertedMap;
	}
	
	
	
	

}
