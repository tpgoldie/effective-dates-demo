package com.discover.epp.inn.demo;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Getter
@Setter
public class PostCode extends EppNodeEntity {

    private String value;

    @Override
    public String toString() {
        return value;
    }
}
