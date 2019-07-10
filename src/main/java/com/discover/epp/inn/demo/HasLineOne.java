package com.discover.epp.inn.demo;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@Getter
@Setter
@RelationshipEntity(type = "HAS_LINE_ONE")
public class HasLineOne {

    @StartNode
    private Address address;

    @EndNode
    private LineOne lineOne;
}
