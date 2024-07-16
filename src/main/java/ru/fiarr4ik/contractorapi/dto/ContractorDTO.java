package ru.fiarr4ik.contractorapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

    /**
     * DTO для сущности {@link ru.fiarr4ik.contractorapi.models.Contractor}
     */
    @Getter
    @Setter
    @Schema(description = "Dto контрагента")
    public class ContractorDTO {

        @JsonProperty
        private String id;

        @JsonProperty
        private String parentId;

        @JsonProperty
        private String name;

        @JsonProperty
        private String nameFull;

        @JsonProperty
        private String inn;

        @JsonProperty
        private String ogrn;

        @JsonProperty
        private CountryDTO country;

        @JsonProperty
        private IndustryDTO industry;

        @JsonProperty
        private OrgFormDTO orgForm;
    }
