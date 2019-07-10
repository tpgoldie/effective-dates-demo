package com.discover.epp.inn.demo;

import lombok.Data;

@Data
public class Country extends EppNodeEntity {

    private String isoCode;

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
