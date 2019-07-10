package com.discover.epp.inn.demo;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "HAS_ADDRESS")
@Getter
@Setter
public class HasAddress extends EppRelationshipEntity {

    @StartNode
    private Shop shop;

    @EndNode
    private Address address;
}
