package com.ciandt.challenge.config;

import java.io.IOException;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.JtaTransactionManagerFactoryBean;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.support.Neo4jExceptionTranslator;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.support.mapping.Neo4jMappingContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.ciandt.challenge.repository")
@EnableTransactionManagement
public class Neo4jConfig extends Neo4jConfiguration {


	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().newEmbeddedDatabase("target/database.db");
	}

	@Bean
    public Neo4jTemplate neo4jTemplate() throws IOException {
        return new Neo4jTemplate(graphDatabaseService());
    }

    @Bean
    public Neo4jMappingContext neo4jMappingContext() {
        return new Neo4jMappingContext();
    }

    @Bean
    public JtaTransactionManagerFactoryBean transactionManager() throws Exception {
        return new JtaTransactionManagerFactoryBean(graphDatabaseService());
    }

    @Bean
    public Neo4jExceptionTranslator exceptionTranslator() {
        return new Neo4jExceptionTranslator();
    }
    
}