package com.discover.epp.inn.demo;

public interface ShopFixture {

    default Shop shop(Company company, String name, Address address) {
        Shop entity = new Shop();

        entity.setCompany(company);
        entity.setAddress(address);
        entity.setName(name);

        return entity;
    }
}
