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
import ru.fiarr4ik.contractorapi.dto.OrgFormDTO;
import ru.fiarr4ik.contractorapi.services.OrgFormService;

    @RestController
    @RequestMapping("/org-form")
    public class OrgFormController {

        private final OrgFormService orgFormService;

        @Autowired
        public OrgFormController(OrgFormService orgFormService) {
            this.orgFormService = orgFormService;
        }

        @PutMapping("/save")
        public ResponseEntity<OrgFormDTO> saveOrgForm(@RequestBody OrgFormDTO orgFormDTO) {
            return new ResponseEntity<>(orgFormService.saveOrgForm(orgFormDTO), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<OrgFormDTO> getOrgForm(@PathVariable int id) {
            return new ResponseEntity<>(orgFormService.getOrgFormById(id), HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteOrgForm(@PathVariable int id) {
            orgFormService.deleteOrgForm(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
