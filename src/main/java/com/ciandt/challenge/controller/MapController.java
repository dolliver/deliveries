package com.ciandt.challenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.challenge.controller.dto.CalculatedDistanceDTO;
import com.ciandt.challenge.controller.dto.MapDTO;
import com.ciandt.challenge.controller.dto.MapNodeDTO;
import com.ciandt.challenge.entity.Map;
import com.ciandt.challenge.entity.MapNode;
import com.ciandt.challenge.entity.MapPath;
import com.ciandt.challenge.repository.MapNodeRepository;
import com.ciandt.challenge.service.MapNodeService;
import com.ciandt.challenge.service.MapService;

@RestController
@RequestMapping("/maps")
public class MapController {
	
	@Autowired
	MapService mapService;
	@Autowired
	MapNodeService nodeService;
	@Autowired
	MapNodeRepository nodeRepository;
	
	@Autowired Neo4jTemplate template;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public MapDTO addNewMap(){
		Map map = new Map();
		map.setName("A");
		map = mapService.save(map);
		return new MapDTO(map);
	}
	
	@RequestMapping(value = "/node", method = RequestMethod.POST)
	@ResponseBody
	public MapDTO addNewMapNode(){
		/*
		MapNode pontoA = new MapNode("A");
		pontoA = nodeRepository.save(pontoA);
		MapNode pontoB = new MapNode("B");
		pontoB.connectedTo(pontoA, Double.valueOf(10));
		pontoB = nodeRepository.save(pontoB);
		MapNode pontoC = new MapNode("C");
		pontoC.connectedTo(pontoA, Double.valueOf(20));
		pontoC = nodeRepository.save(pontoC);
		MapNode pontoD = new MapNode("D");
		pontoD.connectedTo(pontoB, Double.valueOf(5));
		pontoD.connectedTo(pontoC, Double.valueOf(5));
		pontoD = nodeRepository.save(pontoD);
		*/		
		MapDTO retorno = new MapDTO();
		
		MapNode pontoA = nodeService.save(new MapNode("A"));
		MapNode pontoB = nodeService.save(new MapNode("B"));
		MapNode pontoC = nodeService.save(new MapNode("C"));
		MapNode pontoD = nodeService.save(new MapNode("D"));
	
		MapPath ab = pontoA.connectTo(pontoB, Double.valueOf(10));
		MapPath ac = pontoA.connectTo(pontoC, Double.valueOf(20));
		MapPath bd = pontoB.connectTo(pontoD, Double.valueOf(5));
		MapPath cd = pontoC.connectTo(pontoD, Double.valueOf(5));
		
		ab = nodeService.savePath(ab);
		ac = nodeService.savePath(ab);
		bd = nodeService.savePath(ab);
		cd = nodeService.savePath(ab);

		
		Object teste = nodeService.shortestWay(pontoA.getName(), pontoD.getName());
		retorno.setId(10000L);
		
		MapNode carregado = nodeRepository.findOne(pontoA.getId());
		return retorno;
		
	}
	
	@RequestMapping(value = "/{mapId}", method = RequestMethod.PUT)
	@ResponseBody
	public CalculatedDistanceDTO updatesMap(@PathVariable("mapId") Long  mapId, @RequestBody MapDTO map){
		return new CalculatedDistanceDTO("A", null, null, null, null);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<MapDTO> getAllMaps(){
		List<Map> maps = mapService.findAll();
		
		List<MapDTO> returnedList = new ArrayList<MapDTO>();
		if(maps != null && maps.size() > 0) {
			for(Map map: maps) {
				returnedList.add(new MapDTO(map));
			}
		}
		
		return returnedList;
	}
	
	@RequestMapping(value = "/{mapId}", method = RequestMethod.GET)
	@ResponseBody
	public CalculatedDistanceDTO getSingleMap(@PathVariable("mapId") Long  mapId){
		return null;
	}
	
	
	
	@RequestMapping(value = "/{mapId}", method = RequestMethod.DELETE)
	@ResponseBody
	public CalculatedDistanceDTO deletesMap(@PathVariable("mapId") Long  mapId){
		return null;
	}
	
	@RequestMapping(value = "/{mapId}/node", method = RequestMethod.PUT)
	@ResponseBody
	public CalculatedDistanceDTO addsNodeToExistingMap(@PathVariable("mapId") Long  mapId, @RequestBody MapNodeDTO node){
		return null;
	}	
	
	@RequestMapping(value = "/{mapId}/node", method = RequestMethod.DELETE)
	@ResponseBody
	public CalculatedDistanceDTO removesNodeFromExistingMap(@PathVariable("mapId") Long  mapId){
		return null;
	}		
	
		

	
}
