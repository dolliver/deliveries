package com.ciandt.challenge.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.ciandt.challenge.entity.Map;

public interface MapRepository extends GraphRepository<Map> {

}