package com.maztech.fleet.services;

import com.maztech.fleet.entities.Vehicle;
import com.maztech.fleet.repos.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    //return list of Vehicles
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    //Save new vehicle
    public void saveVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public Vehicle findVehicleById(int id){
        return vehicleRepository.findById(id).get();
    }


    public void deleteVehicle(int id) {
        vehicleRepository.deleteById(id);
    }
    
}
