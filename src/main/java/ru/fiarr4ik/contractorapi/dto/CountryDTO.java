package ru.fiarr4ik.contractorapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

    /**
     * DTO для сущности {@link ru.fiarr4ik.contractorapi.models.Country}
     */
    @Getter
    @Setter
    @Schema(description = "DTO стран")
    public class CountryDTO {

        @JsonProperty
        private String id;

        @JsonProperty
        private String name;
    }
