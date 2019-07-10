package com.discover.epp.inn.demo;

import java.util.Optional;

public interface ShopQueries {
    Optional<Shop> findByName(String shopName);
}
