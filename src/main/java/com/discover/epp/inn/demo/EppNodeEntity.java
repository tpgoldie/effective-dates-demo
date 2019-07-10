package com.discover.epp.inn.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Getter
@Setter
@EqualsAndHashCode
@NodeEntity
public abstract class EppNodeEntity {
    @Id
    @GeneratedValue
    protected Long id;

    @Relationship(type = "HAS_VERSION")
    private Version version;

    @Override
    public boolean equals(Object obj) {
        if (obj != this) { return false; }

        if (!(obj instanceof EppNodeEntity)) { return false; }

        EppNodeEntity that = (EppNodeEntity) obj;

        return that.id.equals(this.id);
    }
}
