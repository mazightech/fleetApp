package com.maztech.fleet.services;

import com.maztech.fleet.entities.Country;
import com.maztech.fleet.repos.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    //return list of countries
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    //Save new country
    public void saveCountry(Country country){
         countryRepository.save(country);
    }

    public Country findCountryById(int id){
        return countryRepository.findById(id).get();
    }


    public void deleteCountry(int id) {
        countryRepository.deleteById(id);
    }
}
