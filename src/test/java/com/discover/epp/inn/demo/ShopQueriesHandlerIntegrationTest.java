package com.discover.epp.inn.demo;

import com.discover.epp.inn.demo.repositories.AddressRepository;
import com.discover.epp.inn.demo.repositories.CompanyRepository;
import com.discover.epp.inn.demo.repositories.CountryRepository;
import com.discover.epp.inn.demo.repositories.ShopRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataNeo4jTest
@ComponentScan(basePackages = "com.discover.epp.inn.demo")
@EntityScan(basePackageClasses = {EppNodeEntity.class, EppRelationshipEntity.class})
@TestPropertySource(properties = "classpath:application-local.yml")
@ActiveProfiles("local")
public class ShopQueriesHandlerIntegrationTest implements VersionFixture, AddressFixture, CompanyFixture, ShopFixture, CountryFixture {

    @Autowired
    private ShopQueries shopQueriesHandler;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Test
    public void findByName() {

        Country country = countryRepository.save(country("England", "ENG"));

        Address address = addressRepository
                .save(address("The Meads", "GU10 1XT", country));

        Company company = companyRepository.save(company("Boots", Collections.emptyList()));

        Shop shop = shopRepository.save(shop(company, "Boots Farnborough", address));

        company.setShops(singletonList(shop));

        Optional<Shop> actual = shopQueriesHandler.findByName("Farnborough");

        assertThat(actual.isPresent()).isTrue();

        assertThat(actual.get().getName()).isEqualTo("Farnborough");

        assertThat(actual.get().getAddress().getLineOne().getValue()).isEqualTo("The Meads");

        assertThat(actual.get().getAddress().getPostCode().getValue()).isEqualTo("GU10 1XT");
    }
}
