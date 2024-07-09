package ru.fiarr4ik.contractorapi.entityes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

    @Entity
    @Data
    @Table(name = "country")
    public class Country {

        @Id
        @Column(name = "id")
        private String id;

        @Column(name = "name")
        private String name;

        @Column(name = "is_active")
        private boolean isActive;

        public Country(String id, String name) {
            this.id = id;
            this.name = name;
            this.isActive = true;
        }

        public Country() {
            this.isActive = true;
        }

        public boolean getIsActive() {
            return isActive;
        }
    }
