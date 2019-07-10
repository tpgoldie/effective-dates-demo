package com.discover.epp.inn.demo;

public interface AddressFixture {

    default Address address(String firstLine, String pCode, Country country) {

        Address entity = new Address();

        LineOne lineOne = new LineOne();
        lineOne.setValue(firstLine);

        PostCode postCode = new PostCode();
        postCode.setValue(pCode);

        entity.setLineOne(lineOne);
        entity.setPostCode(postCode);

        entity.setCountry(country);

        return entity;
    }
}
