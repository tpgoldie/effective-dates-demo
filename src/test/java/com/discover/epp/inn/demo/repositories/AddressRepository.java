package com.discover.epp.inn.demo.repositories;

import com.discover.epp.inn.demo.Address;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends Neo4jRepository<Address, Long> {
}
