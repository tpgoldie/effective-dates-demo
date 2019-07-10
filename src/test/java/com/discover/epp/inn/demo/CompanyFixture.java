package com.discover.epp.inn.demo;

import java.util.List;

public interface CompanyFixture extends VersionFixture {

    default Company company(String name, List<Shop> shops) {

        Company entity = new Company();

        entity.setVersion(version(1));
        entity.setName(name);
        entity.setShops(shops);

        return entity;
    }
}
