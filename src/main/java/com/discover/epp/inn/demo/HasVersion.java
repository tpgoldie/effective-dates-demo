package com.discover.epp.inn.demo;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "HAS_VERSION")
@Getter
@Setter
public class HasVersion extends EppRelationshipEntity {

    @StartNode
    private EppNodeEntity entity;

    @EndNode
    private Version version;
}
