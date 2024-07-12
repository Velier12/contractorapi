package ru.fiarr4ik.contractorapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiarr4ik.contractorapi.models.OrgForm;

    public interface OrgFormRepository extends JpaRepository<OrgForm, Integer> {

    }
