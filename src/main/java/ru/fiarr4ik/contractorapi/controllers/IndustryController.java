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
import ru.fiarr4ik.contractorapi.dto.IndustryDTO;
import ru.fiarr4ik.contractorapi.services.IndustryService;

import java.util.List;

    @RestController
    @RequestMapping("/industry")
    public class IndustryController {

        private final IndustryService industryService;

        @Autowired
        public IndustryController(IndustryService industryService) {
            this.industryService = industryService;
        }

        @Operation(summary = "Сохранение промышленности")
        @PutMapping("/save")
        public ResponseEntity<IndustryDTO> saveIndustry(@RequestBody IndustryDTO industryDTO) {
            return new ResponseEntity<>(industryService.saveIndustry(industryDTO), HttpStatus.OK);
        }

        @Operation(summary = "Получение промышленности по id")
        @GetMapping("/{id}")
        public ResponseEntity<IndustryDTO> getIndustry(@PathVariable int id) {
            return new ResponseEntity<>(industryService.getIndustryById(id), HttpStatus.OK);
        }

        @Operation(summary = "Логическое удаление промышленности")
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteIndustry(@PathVariable int id) {
            industryService.deleteIndustry(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @Operation(summary = "Вывод всех активных промышленностей")
        @GetMapping("/all")
        public ResponseEntity<List<IndustryDTO>> getAllIndustryes() {
            List<IndustryDTO> industryes = industryService.getAllIndustry();
            return new ResponseEntity<>(industryes, HttpStatus.OK);
        }
    }
