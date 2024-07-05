package ru.fiarr4ik.contractorapi.dto;

import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class ContractorDTO {
        private String id;
        private String parentId;
        private String name;
        private String nameFull;
        private String inn;
        private String ogrn;
        private CountryDTO country;
        private IndustryDTO industry;
        private OrgFormDTO orgForm;
    }
