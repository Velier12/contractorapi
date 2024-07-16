package ru.fiarr4ik.contractorapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import ru.fiarr4ik.contractorapi.models.Country;
import ru.fiarr4ik.contractorapi.repos.CountryRepository;
import ru.fiarr4ik.contractorapi.repos.IndustryRepository;
import ru.fiarr4ik.contractorapi.repos.OrgFormRepository;

    @DataJpaTest
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    @ContextConfiguration(classes = {ContractorapiApplication.class})
    @TestPropertySource(locations = "classpath:application-test.properties")
    @ComponentScan(basePackages = "ru.fiarr4ik.contractorapi")
    public class RepositoryTests {

        @Autowired
        private CountryRepository countryRepository;

        @Test
        void givenCountry_whenSaved_thenCanBeFoundNyId() {
                Country testCountry = new Country("TC", "TestCountry");
                countryRepository.save(testCountry);
                Country savedCountry = countryRepository.findById(testCountry.getId()).orElse(null);
                if (savedCountry == null) {
                    throw new RuntimeException("Запись не сохранилась");
                }
                Assertions.assertNotNull(savedCountry);
                Assertions.assertEquals(testCountry.getName(),savedCountry.getName());
                countryRepository.delete(testCountry);
        }

    }
