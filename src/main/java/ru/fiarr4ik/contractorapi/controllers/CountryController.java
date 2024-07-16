package ru.fiarr4ik.contractorapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
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
import ru.fiarr4ik.contractorapi.dto.CountryDTO;
import ru.fiarr4ik.contractorapi.services.CountryService;

import java.util.List;

    @RestController
    @RequestMapping("/country")
    public class CountryController {

        private final CountryService countryService;

        @Autowired
        public CountryController(CountryService countryService) {
            this.countryService = countryService;
        }

        @Operation(summary = "Сохранение страны")
        @PutMapping("/save")
        public ResponseEntity<CountryDTO> saveCountry(@RequestBody CountryDTO countryDTO) {
            return new ResponseEntity<>(countryService.saveCountry(countryDTO), HttpStatus.OK);
        }

        @Operation(summary = "Получение страны по id")
        @GetMapping("/{id}")
        public ResponseEntity<CountryDTO> getCountry(@PathVariable String id) {
            return new ResponseEntity<>(countryService.getCountryById(id), HttpStatus.OK);
        }

        @Operation(summary = "Логическое удаление страны")
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteCountry(@PathVariable String id) {
            countryService.deleteCountry(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @Operation(summary = "Вывод всех активных стран")
        @GetMapping("/all")
        public ResponseEntity<List<CountryDTO>> getAllCountries() {
            List<CountryDTO> countries = countryService.getAllCountries();
            return new ResponseEntity<>(countries, HttpStatus.OK);
        }

    }
