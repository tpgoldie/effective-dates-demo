package com.discover.epp.inn.demo;

public interface AddressFixture extends VersionFixture {

    default Address address(String firstLine, String pCode, Country country) {

        Version version = version(1);

        Address entity = new Address();

        entity.setVersion(version);

        LineOne lineOne = new LineOne();
        lineOne.setVersion(version);
        lineOne.setValue(firstLine);

        PostCode postCode = new PostCode();
        postCode.setVersion(version);
        postCode.setValue(pCode);

        entity.setLineOne(lineOne);
        entity.setPostCode(postCode);

        entity.setCountry(country);

        return entity;
    }
}
