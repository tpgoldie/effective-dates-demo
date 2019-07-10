package com.discover.epp.inn.demo.repositories;

import com.discover.epp.inn.demo.Shop;

public interface ShopRepository {

    Shop latestAddressByShopName(String shopName);
}
