package ru.fiarr4ik.contractorapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.dto.CountryDTO;
import ru.fiarr4ik.contractorapi.entityes.Country;
import ru.fiarr4ik.contractorapi.repos.CountryRepository;

@Service
    public class CountryService {

        private final CountryRepository countryRepository;
        private final MappingService mappingService;

        @Autowired
        public CountryService(CountryRepository countryRepository, MappingService mappingService) {
            this.countryRepository = countryRepository;
            this.mappingService = mappingService;
        }

        public void addCountry(String id, String name) {
            Country country = new Country(id, name);
            countryRepository.save(country);
        }

        public CountryDTO saveCountry(CountryDTO countryDTO) {
            Country country = mappingService.convertToEntity(countryDTO);
            Country savedCountry = countryRepository.save(country);
            return mappingService.convertToDto(savedCountry);
        }

        public CountryDTO getCountryById(String id) {
            Country country = countryRepository.findById(id).orElse(null);
            if (country.getIsActive()) {
                return mappingService.convertToDto(country);
            } else {
                return null;
            }
        }

        public void deleteContractor(String id) {
            Country country = countryRepository.findById(id).orElse(null);
            if (country != null) {
                country.setActive(false);
                countryRepository.save(country);
            }
        }
    }
