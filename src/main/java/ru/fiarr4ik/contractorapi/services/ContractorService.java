package ru.fiarr4ik.contractorapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.entityes.Contractor;
import ru.fiarr4ik.contractorapi.repos.ContractorRepository;

    @Service
    public class ContractorService {
        @Autowired
        private ContractorRepository contractorRepository;

        public Contractor saveContractor(Contractor contractor) {
            return contractorRepository.save(contractor);
        }

        public Contractor getContractorById(String id) {
            return contractorRepository.findById(id).orElse(null);
        }

        public void deleteContractor(String id) {
            Contractor contractor = contractorRepository.findById(id).orElse(null);
            if (contractor != null) {
                contractor.setActive(false);
                contractorRepository.save(contractor);
            }
        }
    }
