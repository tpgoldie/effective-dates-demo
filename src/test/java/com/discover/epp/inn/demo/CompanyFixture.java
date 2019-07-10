package com.discover.epp.inn.demo;

import java.util.List;

public interface CompanyFixture {

    default Company company(String name, List<Shop> shops) {

        Company entity = new Company();

        entity.setName(name);
        entity.setShops(shops);

        return entity;
    }
}
