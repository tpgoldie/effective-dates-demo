package com.discover.epp.inn.demo;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
public class Company extends EppNodeEntity {

    private String name;

    @Relationship(type = "OWNS")
    private List<Shop> shops = new ArrayList<>();

    @Override
    public String toString() {
        return name;
    }
}
