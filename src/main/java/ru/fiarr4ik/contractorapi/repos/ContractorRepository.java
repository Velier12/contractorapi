package ru.fiarr4ik.contractorapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiarr4ik.contractorapi.entityes.Contractor;

    public interface ContractorRepository extends JpaRepository<Contractor, String> {

    }
