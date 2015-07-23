package com.ciandt.challenge.base.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ciandt.challenge.base.BaseTest;
import com.ciandt.challenge.entity.MapNode;
import com.ciandt.challenge.entity.MapPath;
import com.ciandt.challenge.entity.RoutesMap;
import com.ciandt.challenge.service.MapNodeService;
import com.ciandt.challenge.service.RoutesMapService;
import com.ciandt.challenge.util.ShortestPathCalculator;


@RunWith(SpringJUnit4ClassRunner.class)
public class MapNodeTest extends BaseTest{

	@Autowired
	private MapNodeService nodeService;
	
	@Autowired
	private RoutesMapService routesMapService;
	

	@Before
	public void init(){
		
	}
	
	@After
	public void destroy(){
	}
	
	@Test
	public void calculateShortestDistanceTest(){
		RoutesMap routesMap = new RoutesMap();
		routesMap.setName("Mapa 1");
		routesMap = routesMapService.save(routesMap);
		
		MapNode pointA = new MapNode("A");
		pointA.setRoutesMapId(routesMap.getId());
		pointA = nodeService.save(pointA);
		
		MapNode pointB = new MapNode("B");
		pointB.setRoutesMapId(routesMap.getId());
		pointB = nodeService.save(pointB);
		
		MapNode pointC = new MapNode("C");
		pointC.setRoutesMapId(routesMap.getId());
		pointC = nodeService.save(pointC);
		
		MapNode pointD = new MapNode("D");
		pointD.setRoutesMapId(routesMap.getId());
		pointD = nodeService.save(pointD);
	
		MapPath ab = pointA.connectTo(pointB, Double.valueOf(10));
		MapPath ac = pointA.connectTo(pointC, Double.valueOf(20));
		MapPath bd = pointB.connectTo(pointD, Double.valueOf(5));
		MapPath cd = pointC.connectTo(pointD, Double.valueOf(5));
		
		ab = nodeService.savePath(ab);
		ac = nodeService.savePath(ac);
		bd = nodeService.savePath(bd);
		cd = nodeService.savePath(cd);
		
		ShortestPathCalculator test = nodeService.getShortestPath( pointA.getName(), pointD.getName(), routesMap.getId());
		assertEquals("[A, B, D]", test.getFullPath());
		assertEquals(Double.valueOf(15), test.getTotalDistance());
		
		nodeService.delete(pointA);
		nodeService.delete(pointB);
		nodeService.delete(pointC);
		nodeService.delete(pointD);
		routesMapService.delete(routesMap);
	}
	
	@Test
	public void calculateShortestDistanceOtherWayAroundTest(){
		RoutesMap routesMap = new RoutesMap();
		routesMap.setName("Mapa 1");
		routesMap = routesMapService.save(routesMap);
		
		MapNode pointA = new MapNode("A");
		pointA.setRoutesMapId(routesMap.getId());
		pointA = nodeService.save(pointA);
		
		MapNode pointB = new MapNode("B");
		pointB.setRoutesMapId(routesMap.getId());
		pointB = nodeService.save(pointB);
		
		MapNode pointC = new MapNode("C");
		pointC.setRoutesMapId(routesMap.getId());
		pointC = nodeService.save(pointC);
		
		MapNode pointD = new MapNode("D");
		pointD.setRoutesMapId(routesMap.getId());
		pointD = nodeService.save(pointD);
	
		MapPath ab = pointA.connectTo(pointB, Double.valueOf(10));
		MapPath ac = pointA.connectTo(pointC, Double.valueOf(20));
		MapPath bd = pointB.connectTo(pointD, Double.valueOf(5));
		MapPath cd = pointC.connectTo(pointD, Double.valueOf(5));
		
		ab = nodeService.savePath(ab);
		ac = nodeService.savePath(ac);
		bd = nodeService.savePath(bd);
		cd = nodeService.savePath(cd);
		
		//going opposite, from D to A
		ShortestPathCalculator test = nodeService.getShortestPath( pointD.getName(), pointA.getName(), routesMap.getId());
		assertEquals("[D, B, A]", test.getFullPath());
		assertEquals(Double.valueOf(15), test.getTotalDistance());
		
		nodeService.delete(pointA);
		nodeService.delete(pointB);
		nodeService.delete(pointC);
		nodeService.delete(pointD);
		routesMapService.delete(routesMap);
	}	
	
	@Test
	public void testChallengeDescriptionTest(){
		RoutesMap routesMap = new RoutesMap();
		routesMap.setName("Mapa 1");
		routesMap = routesMapService.save(routesMap);
		
		MapNode pointA = new MapNode("A");
		pointA.setRoutesMapId(routesMap.getId());
		pointA = nodeService.save(pointA);
		
		MapNode pointB = new MapNode("B");
		pointB.setRoutesMapId(routesMap.getId());
		pointB = nodeService.save(pointB);
		
		MapNode pointC = new MapNode("C");
		pointC.setRoutesMapId(routesMap.getId());
		pointC = nodeService.save(pointC);
		
		MapNode pointD = new MapNode("D");
		pointD.setRoutesMapId(routesMap.getId());
		pointD = nodeService.save(pointD);

		MapNode pointE = new MapNode("E");
		pointE.setRoutesMapId(routesMap.getId());
		pointE = nodeService.save(pointE);
		
	
		MapPath ab = pointA.connectTo(pointB, Double.valueOf(10));
		MapPath bd = pointB.connectTo(pointD, Double.valueOf(15));
		MapPath ac = pointA.connectTo(pointC, Double.valueOf(20));		
		MapPath cd = pointC.connectTo(pointD, Double.valueOf(30));
		MapPath be = pointB.connectTo(pointE, Double.valueOf(50));		
		MapPath de = pointD.connectTo(pointE, Double.valueOf(30));			
		
		ab = nodeService.savePath(ab);
		bd = nodeService.savePath(bd);
		ac = nodeService.savePath(ac);
		cd = nodeService.savePath(cd);
		be = nodeService.savePath(be);
		de = nodeService.savePath(de);
		
		ShortestPathCalculator test = nodeService.getShortestPath( pointA.getName(), pointD.getName(), routesMap.getId());
		assertEquals("[A, B, D]", test.getFullPath());
		assertEquals(Double.valueOf(25), test.getTotalDistance());
		
		test.setMileage(Double.valueOf(10.0));
		test.setGasPrice(2.5);
		test.calculateCost();
		
		assertEquals(Double.valueOf(6.25), test.getTotalCost());		
		
		nodeService.delete(pointA);
		nodeService.delete(pointB);
		nodeService.delete(pointC);
		nodeService.delete(pointD);
		nodeService.delete(pointE);		
		routesMapService.delete(routesMap);
	}	
	
}
