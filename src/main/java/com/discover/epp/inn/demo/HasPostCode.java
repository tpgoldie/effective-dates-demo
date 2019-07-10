package com.discover.epp.inn.demo;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.StartNode;

@Getter
@Setter
public class HasPostCode extends EppRelationshipEntity {

    @StartNode
    private Address address;

    @EndNode
    private PostCode postCode;
}
