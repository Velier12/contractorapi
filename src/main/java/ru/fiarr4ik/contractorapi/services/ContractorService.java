package ru.fiarr4ik.contractorapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.dto.ContractorDTO;
import ru.fiarr4ik.contractorapi.entityes.Contractor;
import ru.fiarr4ik.contractorapi.repos.ContractorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class ContractorService {

        private final ContractorRepository contractorRepository;
        private final MappingService mappingService;

        @Autowired
        public ContractorService(ContractorRepository contractorRepository, MappingService mappingService) {
            this.contractorRepository = contractorRepository;
            this.mappingService = mappingService;
        }

        public ContractorDTO saveContractor(ContractorDTO contractorDTO) {
            Contractor contractor = mappingService.convertToEntity(contractorDTO);
            Contractor savedContractor = contractorRepository.save(contractor);
            return mappingService.convertToDto(savedContractor);
        }

        public ContractorDTO getContractorById(String id) {
            Contractor contractor = contractorRepository.findById(id).orElse(null);
            assert contractor != null;
            if (contractor.getIsActive()) {
                return mappingService.convertToDto(contractor);
            } else {
                return null;
            }
        }

        public void deleteContractor(String id) {
            Contractor contractor = contractorRepository.findById(id).orElse(null);
            if (contractor != null) {
                contractor.setActive(false);
                contractorRepository.save(contractor);
            }
        }

        public List<ContractorDTO> getAllContractor() {
            List<Contractor> contractors = contractorRepository.findAll();
            return contractors.stream()
                    .filter(Contractor::getIsActive)
                    .map(mappingService::convertToDto)
                    .collect(Collectors.toList());
        }
    }
