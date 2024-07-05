package ru.fiarr4ik.contractorapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiarr4ik.contractorapi.entityes.Industry;

    public interface IndustryRepository extends JpaRepository<Industry, Integer> {

    }
