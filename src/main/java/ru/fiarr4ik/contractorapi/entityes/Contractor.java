package ru.fiarr4ik.contractorapi.entityes;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.security.Timestamp;

    @Entity
    @Table(name = "contractor")
    @Data
    public class Contractor {
        @Id
        private String id;
        private String parentId;

        @Column(nullable = false)
        private String name;
        private String nameFull;
        private String inn;
        private String ogrn;

        @ManyToOne
        @JoinColumn(name = "country", referencedColumnName = "id")
        private Country country;

        @ManyToOne
        @JoinColumn(name = "industry", referencedColumnName = "id")
        private Industry industry;

        @ManyToOne
        @JoinColumn(name = "org_form", referencedColumnName = "id")
        private OrgForm orgForm;

        @Column(name = "is_active", nullable = false)
        private boolean isActive;

        public Contractor(OrgForm orgForm, Industry industry, Country country, String ogrn, String inn, String nameFull, String name, String parentId, String id) {
            this.orgForm = orgForm;
            this.industry = industry;
            this.country = country;
            this.ogrn = ogrn;
            this.inn = inn;
            this.nameFull = nameFull;
            this.name = name;
            this.parentId = parentId;
            this.id = id;
            this.isActive = true;
        }

        public Contractor() {
            this.isActive = true;
        }

        @Column(name = "create_date", nullable = false, updatable = false)
        @CreationTimestamp
        private Timestamp createDate;

        @Column(name = "modify_date")
        @UpdateTimestamp
        private Timestamp modifyDate;
    }
