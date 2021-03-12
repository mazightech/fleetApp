package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Country;
import com.maztech.fleet.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    CountryService countryService;

    //return list of countries
    @GetMapping("/countries")
    public String getCountries(Model model){
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries",countryList);

        return "country";
    }

    //Save new country
    @PostMapping("/countries/addNew")
    public String addCountry(Country country) {
        countryService.saveCountry(country);

        return "redirect:/countries";
    }

    @GetMapping("countries/find")
    @ResponseBody
    public Country findCountryById(@RequestParam("id") int id){

        return countryService.findCountryById(id);
    }

    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateCountry(Country country) {
        countryService.saveCountry(country);

        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteCountry(int id) {
        countryService.deleteCountry(id);

        return "redirect:/countries";
    }
}
