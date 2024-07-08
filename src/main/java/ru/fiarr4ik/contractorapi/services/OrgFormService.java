package ru.fiarr4ik.contractorapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.entityes.OrgForm;
import ru.fiarr4ik.contractorapi.repos.OrgFormRepository;

@Service
    public class OrgFormService {

        private final OrgFormRepository orgFormRepository;

        @Autowired
        public OrgFormService(OrgFormRepository orgFormRepository) {
            this.orgFormRepository = orgFormRepository;
        }

        public OrgForm saveOrgForm(OrgForm orgForm) {
            return orgFormRepository.save(orgForm);
        }

        public OrgForm findOrgFormById(int id) {
            return orgFormRepository.findById(id).orElse(null);
        }

        public void deleteOrgForm(int id) {
            OrgForm orgForm = orgFormRepository.findById(id).orElse(null);
            if (orgForm != null) {
                orgForm.setActive(false);
                orgFormRepository.save(orgForm);
            }
        }
    }
