package com.discover.epp.inn.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@EqualsAndHashCode(callSuper = true)
public class Shop extends EppNodeEntity {

    private String name;

    @Relationship(type = "HAS_ADDRESS")
    private Address address;

    @Relationship(type = "IS_OWNED_BY")
    private Company company;
}
