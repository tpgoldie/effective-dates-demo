package com.discover.epp.inn.demo;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

import java.time.LocalDateTime;

@NodeEntity
@Data
public class Version {
    private int value;
    private LocalDateTime timestamp;

    @Override
    public String toString() {

        return String.format("version %d %s", value, timestamp);
    }
}
