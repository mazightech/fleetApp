package com.maztech.fleet.repos;

import com.maztech.fleet.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {

}
