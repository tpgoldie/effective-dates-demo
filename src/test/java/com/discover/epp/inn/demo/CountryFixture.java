package com.discover.epp.inn.demo;

public interface CountryFixture {

    default Country country(String name, String isoCode) {

        Country entity = new Country();

        entity.setIsoCode(isoCode);
        entity.setName(name);

        return entity;
    }
}
