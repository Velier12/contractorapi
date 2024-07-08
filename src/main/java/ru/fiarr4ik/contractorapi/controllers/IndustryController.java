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
import ru.fiarr4ik.contractorapi.entityes.Industry;
import ru.fiarr4ik.contractorapi.services.IndustryService;

    @RestController
    @RequestMapping("/country")
    public class IndustryController {

        private final IndustryService industryService;

        @Autowired
        public IndustryController(IndustryService industryService) {
            this.industryService = industryService;
        }

        @PutMapping("/save")
        public ResponseEntity<Industry> saveIndustry(@RequestBody Industry industry) {
            return new ResponseEntity<>(industryService.saveIndustry(industry), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Industry> getIndustry(@PathVariable int id) {
            return new ResponseEntity<>(industryService.getIndustryById(id), HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteIndustry(@PathVariable int id) {
            industryService.deleteIndustry(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
