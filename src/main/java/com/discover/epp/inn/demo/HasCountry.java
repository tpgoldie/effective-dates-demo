package com.discover.epp.inn.demo;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "HAS_COUNTRY")
@Getter
@Setter
public class HasCountry extends EppRelationshipEntity {

    @StartNode
    private Address address;

    @EndNode
    private Country country;
}
