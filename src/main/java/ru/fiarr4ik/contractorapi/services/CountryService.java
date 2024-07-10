package ru.fiarr4ik.contractorapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.dto.CountryDTO;
import ru.fiarr4ik.contractorapi.entityes.Country;
import ru.fiarr4ik.contractorapi.repos.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class CountryService {

        private final CountryRepository countryRepository;
        private final MappingService mappingService;

        @Autowired
        public CountryService(CountryRepository countryRepository, MappingService mappingService) {
            this.countryRepository = countryRepository;
            this.mappingService = mappingService;
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

        public void deleteCountry(String id) {
            Country country = countryRepository.findById(id).orElse(null);
            if (country != null) {
                country.setActive(false);
                countryRepository.save(country);
            }
        }

        public List<CountryDTO> getAllCountries() {
            List<Country> countries = countryRepository.findAll();
            return countries.stream()
                    .filter(Country::getIsActive)
                    .map(mappingService::convertToDto)
                    .collect(Collectors.toList());
        }
    }
