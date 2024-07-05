package ru.fiarr4ik.contractorapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiarr4ik.contractorapi.entityes.Country;

    public interface CountryRepository extends JpaRepository<Country, String> {

    }
