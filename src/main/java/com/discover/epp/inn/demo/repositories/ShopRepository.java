package com.discover.epp.inn.demo.repositories;

import com.discover.epp.inn.demo.Shop;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends Neo4jRepository<Shop, Long> {

    Shop findByName(String shopName);
}
