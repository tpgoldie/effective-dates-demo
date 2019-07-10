package com.discover.epp.inn.demo;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public abstract class EppRelationshipEntity {

    @Id
    @GeneratedValue
    protected Long id;
}
