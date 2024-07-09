package ru.fiarr4ik.contractorapi.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.contractorapi.dto.ContractorDTO;
import ru.fiarr4ik.contractorapi.dto.CountryDTO;
import ru.fiarr4ik.contractorapi.dto.IndustryDTO;
import ru.fiarr4ik.contractorapi.dto.OrgFormDTO;
import ru.fiarr4ik.contractorapi.entityes.Contractor;
import ru.fiarr4ik.contractorapi.entityes.Country;
import ru.fiarr4ik.contractorapi.entityes.Industry;
import ru.fiarr4ik.contractorapi.entityes.OrgForm;

@Service
public class MappingService {

    private final ModelMapper modelMapper;

    @Autowired
    public MappingService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ContractorDTO convertToDto(Contractor contractor) {
        return modelMapper.map(contractor, ContractorDTO.class);
    }

    public Contractor convertToEntity(ContractorDTO contractorDTO) {
        return modelMapper.map(contractorDTO, Contractor.class);
    }

    public CountryDTO convertToDto(Country country) {
        return modelMapper.map(country, CountryDTO.class);
    }

    public Country convertToEntity(CountryDTO countryDTO) {
        return modelMapper.map(countryDTO, Country.class);
    }

    public IndustryDTO convertToDto(Industry industry) {
        return modelMapper.map(industry, IndustryDTO.class);
    }

    public Industry convertToEntity(IndustryDTO industryDTO) {
        return modelMapper.map(industryDTO, Industry.class);
    }

    public OrgFormDTO convertToDto(OrgForm orgForm) {
        return modelMapper.map(orgForm, OrgFormDTO.class);
    }

    public OrgForm convertToEntity(OrgFormDTO orgFormDTO) {
        return modelMapper.map(orgFormDTO, OrgForm.class);
    }

}
