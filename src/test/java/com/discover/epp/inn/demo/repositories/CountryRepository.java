package com.discover.epp.inn.demo.repositories;


import com.discover.epp.inn.demo.Country;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends Neo4jRepository<Country, Long> {
}
