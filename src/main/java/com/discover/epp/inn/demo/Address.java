package com.discover.epp.inn.demo;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
public class Address extends EppNodeEntity {

    @Relationship(type = "HAS_LINE_ONE")
    private LineOne lineOne;

    @Relationship(type = "HAS_POST_CODE")
    private PostCode postCode;

    @Relationship(type = "HAS_COUNTRY")
    private Country country;
}
