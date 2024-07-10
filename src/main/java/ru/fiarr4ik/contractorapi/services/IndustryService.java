package ru.fiarr4ik.contractorapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.dto.IndustryDTO;
import ru.fiarr4ik.contractorapi.entityes.Industry;
import ru.fiarr4ik.contractorapi.repos.IndustryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class IndustryService {

        private final IndustryRepository industryRepository;
        private final MappingService mappingService;

        @Autowired
        public IndustryService(IndustryRepository industryRepository, MappingService mappingService) {
            this.industryRepository = industryRepository;
            this.mappingService = mappingService;
        }

        public IndustryDTO saveIndustry(IndustryDTO industryDTO) {
            Industry industry = mappingService.convertToEntity(industryDTO);
            Industry savedIndustry = industryRepository.save(industry);
            return mappingService.convertToDto(savedIndustry);
        }

        public IndustryDTO getIndustryById(int id) {
            Industry industry = industryRepository.findById(id).orElse(null);
            if (industry.getIsActive()) {
                return mappingService.convertToDto(industry);
            } else {
                return null;
            }
        }

        public void  deleteIndustry(int id) {
            Industry industry = industryRepository.findById(id).orElse(null);
            if (industry != null) {
                industry.setActive(false);
                industryRepository.save(industry);
            }
        }

        public List<IndustryDTO> getAllIndustry() {
            List<Industry> industries = industryRepository.findAll();
            return industries.stream()
                    .filter(Industry::getIsActive)
                    .map(mappingService::convertToDto)
                    .collect(Collectors.toList());
        }
    }
