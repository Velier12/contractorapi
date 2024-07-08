package ru.fiarr4ik.contractorapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import ru.fiarr4ik.contractorapi.entityes.Country;
import ru.fiarr4ik.contractorapi.services.CountryService;

    @RestController
    @RequestMapping("/country")
    public class CountryController {

        private final CountryService countryService;

        @Autowired
        public CountryController(CountryService countryService) {
            this.countryService = countryService;
        }

        @PutMapping("/save")
        public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
            return new ResponseEntity<>(countryService.saveCountry(country), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Country> getCountry(@PathVariable String id) {
            return new ResponseEntity<>(countryService.getCountryById(id), HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteCountry(@PathVariable String id) {
            countryService.deleteContractor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
