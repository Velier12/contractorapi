package ru.fiarr4ik.contractorapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

    /**
     * DTO для сущности {@link ru.fiarr4ik.contractorapi.models.OrgForm}
     */
    @Getter
    @Setter
    @Schema(description = "DTO организационных форм")
    public class OrgFormDTO {

        @JsonProperty
        private Integer id;

        @JsonProperty
        private String name;
    }
