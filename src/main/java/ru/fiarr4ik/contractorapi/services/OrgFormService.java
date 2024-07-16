package ru.fiarr4ik.contractorapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.dto.OrgFormDTO;
import ru.fiarr4ik.contractorapi.models.OrgForm;
import ru.fiarr4ik.contractorapi.repos.OrgFormRepository;

import java.util.List;
import java.util.stream.Collectors;

    /**
     * Сервис для работы с сущностью {@link OrgForm}
     */
    @Service
    public class OrgFormService {

        private final OrgFormRepository orgFormRepository;
        private final MappingService mappingService;

        @Autowired
        public OrgFormService(OrgFormRepository orgFormRepository, MappingService mappingService) {
            this.orgFormRepository = orgFormRepository;
            this.mappingService = mappingService;
        }

        public OrgFormDTO saveOrgForm(OrgFormDTO orgFormDTO) {
            OrgForm orgForm = mappingService.convertToEntity(orgFormDTO);
            OrgForm savedOrgForm = orgFormRepository.save(orgForm);
            return mappingService.convertToDto(savedOrgForm);
        }

        public OrgFormDTO getOrgFormById(int id) {
            OrgForm orgForm = orgFormRepository.findById(id).orElse(null);
            assert orgForm != null;
            if (orgForm.getIsActive()) {
                return mappingService.convertToDto(orgForm);
            } else {
                return null;
            }
        }

        public void deleteOrgForm(int id) {
            OrgForm orgForm = orgFormRepository.findById(id).orElse(null);
            if (orgForm != null) {
                orgForm.setActive(false);
                orgFormRepository.save(orgForm);
            }
        }

        public List<OrgFormDTO> getAllOrgForm() {
            List<OrgForm> orgForms = orgFormRepository.findAll();
            return orgForms.stream()
                    .filter(OrgForm::getIsActive)
                    .map(mappingService::convertToDto)
                    .collect(Collectors.toList());
        }
    }
