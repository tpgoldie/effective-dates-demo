package com.discover.epp.inn.demo;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;

import java.time.LocalDateTime;

@NodeEntity
@Getter
@Setter
public class Version {

    private int value;

    private LocalDateTime timestamp;

    @Override
    public String toString() {

        return String.format("version %d %s", value, timestamp);
    }
}
