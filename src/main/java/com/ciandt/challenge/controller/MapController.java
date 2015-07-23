package com.ciandt.challenge.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.challenge.controller.dto.MapNodeDTO;
import com.ciandt.challenge.controller.dto.RoutesMapDTO;
import com.ciandt.challenge.entity.MapNode;
import com.ciandt.challenge.entity.MapPath;
import com.ciandt.challenge.entity.RoutesMap;
import com.ciandt.challenge.repository.MapNodeRepository;
import com.ciandt.challenge.service.MapNodeService;
import com.ciandt.challenge.service.RoutesMapService;
import com.ciandt.challenge.util.ShortestPathCalculator;

@RestController
@RequestMapping("/maps")
public class MapController {
	
	@Autowired
	RoutesMapService mapService;
	@Autowired
	MapNodeService nodeService;
	@Autowired
	MapNodeRepository nodeRepository;
	
	@Autowired Neo4jTemplate template;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public RoutesMapDTO addNewMap(@RequestBody RoutesMapDTO mapDTO){
		
		//First created a new map
		RoutesMap map = mapDTO.convertToMap();
		map = mapService.save(map);
		
		if(mapDTO.getNodes() != null && mapDTO.getNodes().size() > 0) {
			Map<String, MapNode> createdNodeList = new HashMap<String, MapNode>();
			
			//Saves each individual unique node
			// if they were saved before, they shouldnt be saved again
			// but the relation between the nodes will always be saved with their distances
			for(MapNodeDTO nodeDTO : mapDTO.getNodes()) {
				
				//starting point first
				MapNode startingPoint = createdNodeList.get(nodeDTO.getStartingPoint());
				if(startingPoint == null) { 
					startingPoint = new MapNode(nodeDTO.getStartingPoint());
					startingPoint.setRoutesMapId(map.getId());
					startingPoint = nodeService.save(startingPoint);
					createdNodeList.put(nodeDTO.getStartingPoint(), startingPoint);
				}
				
				//destination point first
				MapNode destinationPoint = createdNodeList.get(nodeDTO.getDestinationPoint());
				if(destinationPoint == null) { 
					destinationPoint = new MapNode(nodeDTO.getDestinationPoint());
					destinationPoint.setRoutesMapId(map.getId());
					destinationPoint = nodeService.save(destinationPoint);
					createdNodeList.put(nodeDTO.getDestinationPoint(), destinationPoint);
				}		
				
				//Make weighted connection  (by distance)
				MapPath path = startingPoint.connectTo(destinationPoint, nodeDTO.getDistance());
				path = nodeService.savePath(path);
			}
		}
		
		return new RoutesMapDTO(map);
	}
	
	@RequestMapping(value = "/{mapId}/from/{start}/to/{end}", method = RequestMethod.GET)
	@ResponseBody
	public ShortestPathCalculator getShortestPath(@PathVariable("mapId") Long  mapId,
			@PathVariable("start") String start, @PathVariable("end") String  end,
			@RequestParam(value="mileage", required=false, defaultValue="10.0") Double mileage,
			@RequestParam(value="gasPrice", required=false, defaultValue="3.0") Double gasPrice){
			
		RoutesMap map = mapService.findById(mapId);
		
		if(map == null) {
			throw new NoSuchElementException();			
		}
		
		ShortestPathCalculator shortestPathCalculator = nodeService.getShortestPath( start, end, map.getId());
		
		if(shortestPathCalculator == null) {
			return null;
		}
		
		shortestPathCalculator.setMileage(mileage);
		shortestPathCalculator.setGasPrice(gasPrice);
		shortestPathCalculator.calculateCost();		
		
		return shortestPathCalculator;
	}		
}
