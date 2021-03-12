package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Country;
import com.maztech.fleet.entities.Location;
import com.maztech.fleet.entities.State;
import com.maztech.fleet.services.CountryService;
import com.maztech.fleet.services.LocationService;
import com.maztech.fleet.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    StateService stateService;
    @Autowired
    CountryService countryService;
    @Autowired
    LocationService locationService;

    //return list of locations
    @GetMapping("/locations")
    public String getLocations(Model model){
        List<Location> locationList = locationService.getLocations();
        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();

        model.addAttribute("locations",locationList);
        model.addAttribute("states",stateList);
        model.addAttribute("countries",countryList);

        return "location";
    }

    //Save new location
    @PostMapping("/locations/addNew")
    public String addLocation(Location location) {
        locationService.saveLocation(location);

        return "redirect:/locations";
    }

    @GetMapping("locations/find")
    @ResponseBody
    public Location findLocationById(@RequestParam("id") int id){

        return locationService.findLocationById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateLocation(Location location) {
        locationService.saveLocation(location);

        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteLocation(int id) {
        locationService.deleteLocation(id);

        return "redirect:/locations";
    }
}
