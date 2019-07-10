package com.discover.epp.inn.demo;

import java.time.LocalDateTime;

public interface VersionFixture {

    default Version version(int value) {

        return version(LocalDateTime.now(), value);
    }

    default Version version(LocalDateTime timestamp, int value) {

        Version version = new Version();
        version.setTimestamp(timestamp);
        version.setValue(value);

        return version;
    }
}
