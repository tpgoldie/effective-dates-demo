package com.discover.epp.inn.demo;

public interface ShopFixture extends VersionFixture {

    default Shop shop(Company company, String name, Address address) {
        Shop entity = new Shop();

        entity.setVersion(version(1));
        entity.setCompany(company);
        entity.setAddress(address);
        entity.setName(name);

        return entity;
    }
}
