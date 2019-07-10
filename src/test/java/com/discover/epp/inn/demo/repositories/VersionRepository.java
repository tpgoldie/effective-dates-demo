package com.discover.epp.inn.demo.repositories;

import com.discover.epp.inn.demo.Version;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends Neo4jRepository<Version, Long> {
}
