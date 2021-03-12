package com.maztech.fleet.services;

import com.maztech.fleet.entities.Location;
import com.maztech.fleet.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    //return list of countries
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    //Save new location
    public void saveLocation(Location location){
        locationRepository.save(location);
    }

    public Location findLocationById(int id){
        return locationRepository.findById(id).get();
    }


    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }
    
}
