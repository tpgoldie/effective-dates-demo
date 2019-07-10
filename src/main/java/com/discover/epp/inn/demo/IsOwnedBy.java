package com.discover.epp.inn.demo;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "IS_OWNED_BY")
@Getter
@Setter
public class IsOwnedBy extends EppRelationshipEntity {

    @StartNode
    private Company company;

    @EndNode
    private Shop shop;
}
