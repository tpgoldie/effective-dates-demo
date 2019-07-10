package com.discover.epp.inn.demo;

import com.discover.epp.inn.demo.repositories.AddressRepository;
import com.discover.epp.inn.demo.repositories.CompanyRepository;
import com.discover.epp.inn.demo.repositories.ShopRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.harness.junit.Neo4jRule;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataNeo4jTest
@ContextConfiguration(classes = {ShopQueriesHandlerIntegrationTest.Config.class})
@ComponentScan(basePackages = "com.discover.epp.inn.demo")
@EntityScan(basePackageClasses = {EppNodeEntity.class, EppRelationshipEntity.class})
@TestPropertySource(properties = "classpath:application-local.yml")
@ActiveProfiles("local")
public class ShopQueriesHandlerIntegrationTest implements AddressFixture, CompanyFixture, ShopFixture, CountryFixture {

    @org.springframework.context.annotation.Configuration
    static class Config {
        @Bean
        public Configuration configuration() {
            return new Configuration.Builder()
                //.uri(neoServer.boltURI().toString())
                //.uri(neoServer.httpURI().toString()) // For HTTP
                .uri(new File("test-db.txt").toURI().toString()) // For Embedded
                .build();
        }

    }

    @Rule
    public Neo4jRule neoServer = new Neo4jRule();

    @Autowired
    private ShopQueries shopQueriesHandler;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ShopRepository shopRepository;

//    @Before
//    public void setUp() throws Exception {
//
//        Configuration configuration = new Configuration.Builder()
//                //.uri(neoServer.boltURI().toString())
//                //.uri(neoServer.httpURI().toString()) // For HTTP
//                .uri(new File("test-db.txt").toURI().toString()) // For Embedded
//                .build();
//
//        SessionFactory sessionFactory = new SessionFactory(configuration, "com.discover.epp.inn.demo");
//
//        session = sessionFactory.openSession();
//
//        session.purgeDatabase();
//    }

    @Test
    public void findByName() {

        Address address = addressRepository
                .save(address("The Meads", "GU10 1XT", country("England", "ENG")));

        Company company = companyRepository.save(company("Boots", Collections.emptyList()));

        Shop shop = shopRepository.save(shop(company, "Boots Farnborough", address));

        company.setShops(Collections.singletonList(shop));


        Optional<Shop> actual = shopQueriesHandler.findByName("Farnborough");

        assertThat(actual.isPresent()).isTrue();

        assertThat(actual.get().getName()).isEqualTo("Farnborough");

        assertThat(actual.get().getAddress().getLineOne().getValue()).isEqualTo("The Meads");

        assertThat(actual.get().getAddress().getPostCode().getValue()).isEqualTo("GU10 1XT");
    }
}
