package com.discover.epp.inn.demo;

public interface CountryFixture extends VersionFixture {

    default Country country(String name, String isoCode) {

        Country entity = new Country();

        entity.setIsoCode(isoCode);
        entity.setName(name);
        entity.setVersion(version(1));

        return entity;
    }
}
