package com.ciandt.challenge.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import com.ciandt.challenge.config.Neo4jConfig;
import com.ciandt.challenge.config.SpringConfig;
import com.ciandt.challenge.config.WebAppConfig;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {  SpringConfig.class, BaseTestScanConfig.class, Neo4jConfig.class, WebAppConfig.class})
@WebAppConfiguration
public abstract class BaseTest {

	static {
		System.setProperty("PASSAPORTE_CONFIG_PATH", "classpath:passaporte-core.properties");
		
		
	}
	
}