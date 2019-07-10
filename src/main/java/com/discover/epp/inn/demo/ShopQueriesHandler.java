package com.discover.epp.inn.demo;

import com.discover.epp.inn.demo.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopQueriesHandler {

    private ShopRepository shopRepository;

    @Autowired
    public ShopQueriesHandler(ShopRepository shopRepository) {

        this.shopRepository = shopRepository;
    }

    public Optional<Shop> findByLatestAddressAndName(String shopName) {
        return Optional.ofNullable(shopRepository.latestAddressByShopName(shopName));
    }
}
