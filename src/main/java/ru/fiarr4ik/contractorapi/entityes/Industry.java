package ru.fiarr4ik.contractorapi.entityes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.Data;

    @Entity
    @Data
    @Table(name = "industry")
    public class Industry {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "is_active")
        private boolean isActive;

        public Industry(String name) {
            this.name = name;
            this.isActive = true;
        }

        public Industry() {
            this.isActive = true;
        }

        public boolean getIsActive() {
            return isActive;
        }
    }
