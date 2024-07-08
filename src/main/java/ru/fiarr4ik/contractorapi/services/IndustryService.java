package ru.fiarr4ik.contractorapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.entityes.Industry;
import ru.fiarr4ik.contractorapi.repos.IndustryRepository;

@Service
    public class IndustryService {

        private final IndustryRepository industryRepository;

        @Autowired
        public IndustryService(IndustryRepository industryRepository) {
            this.industryRepository = industryRepository;
        }

        public Industry saveIndustry(Industry industry) {
            return industryRepository.save(industry);
        }

        public Industry getIndustryById(int id) {
            return industryRepository.findById(id).orElse(null);
        }

        public void  deleteIndustry(int id) {
            Industry industry = industryRepository.findById(id).orElse(null);
            if (industry != null) {
                industry.setActive(false);
                industryRepository.save(industry);
            }
        }
    }
