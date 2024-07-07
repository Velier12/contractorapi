package ru.fiarr4ik.contractorapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.entityes.Country;
import ru.fiarr4ik.contractorapi.repos.CountryRepository;

@Service
    public class CountryService {

        private final CountryRepository countryRepository;

        @Autowired
        public CountryService(CountryRepository countryRepository) {
            this.countryRepository = countryRepository;
        }

        public Country saveCountry(Country country) {
            return countryRepository.save(country);
        }

        public Country getCountryById(String id) {
            return countryRepository.findById(id).orElse(null);
        }

        public void deleteContractor(String id) {
            Country country = countryRepository.findById(id).orElse(null);
            if (country != null) {
                country.setActive(false);
                countryRepository.save(country);
            }
        }
    }
