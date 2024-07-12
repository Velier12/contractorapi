package ru.fiarr4ik.contractorapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

    /**
     * DTO для сущности {@link ru.fiarr4ik.contractorapi.models.Industry}
     */
    @Getter
    @Setter
    @Schema(description = "DTO промышленности")
    public class IndustryDTO {

        @JsonProperty
        private Integer id;

        @JsonProperty
        private String name;
    }
