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
import ru.fiarr4ik.contractorapi.dto.ContractorDTO;
import ru.fiarr4ik.contractorapi.services.ContractorService;

import java.util.List;

@RestController
    @RequestMapping("/contractor")
    public class ContractorController {

        private final ContractorService contractorService;

        @Autowired
        public ContractorController(ContractorService contractorService) {
            this.contractorService = contractorService;
        }

        @PutMapping("/save")
        public ResponseEntity<ContractorDTO> saveContractor(@RequestBody ContractorDTO contractorDTO) {
            return new ResponseEntity<>(contractorService.saveContractor(contractorDTO), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ContractorDTO> getContractor(@PathVariable String id) {
            return new ResponseEntity<>(contractorService.getContractorById(id), HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteContractor(@PathVariable String id) {
            contractorService.deleteContractor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @GetMapping("/all")
        public ResponseEntity<List<ContractorDTO>> getAllContractor() {
            List<ContractorDTO> contractors = contractorService.getAllContractor();
            return new ResponseEntity<>(contractors, HttpStatus.OK);
        }

    }
