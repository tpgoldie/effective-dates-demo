package com.discover.epp.inn.demo;

import com.discover.epp.inn.demo.repositories.ShopRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShopQueriesHandlerTest implements AddressFixture, CountryFixture, ShopFixture, CompanyFixture {

    @Mock
    private ShopRepository shopRepository;

    @InjectMocks
    private ShopQueriesHandler shopQueriesHandler;

    @Test
    public void findAddress() {

        Country england = country("England", "ENG");

        Company company = company("Boots", emptyList());

        Shop shop = shop(company, "Farnborough", address("The Meads", "GU10 1XT", england));

        company.setShops(singletonList(shop));

        when(shopRepository.findByName("Farnborough")).thenReturn(shop);

        Optional<Shop> actual = shopQueriesHandler.findByName("Farnborough");

        assertThat(actual.isPresent()).isTrue();

        assertThat(actual.get().getName()).isEqualTo("Farnborough");

        assertThat(actual.get().getAddress().getLineOne().getValue()).isEqualTo("The Meads");

        assertThat(actual.get().getAddress().getPostCode().getValue()).isEqualTo("GU10 1XT");
    }
}
