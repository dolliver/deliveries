package com.ciandt.challenge.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ciandt.challenge.config.SpringConfig;
import com.ciandt.challenge.config.WebAppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {  SpringConfig.class, BaseTestScanConfig.class, Neo4jTestConfig.class, WebAppConfig.class})
@WebAppConfiguration
public abstract class BaseTest {
	
}