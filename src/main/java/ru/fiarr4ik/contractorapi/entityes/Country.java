package ru.fiarr4ik.contractorapi.entityes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

    @Entity
    @Data
    public class Country {
        @Id
        private String id;
        private String name;
        private boolean isActive = true;
    }
