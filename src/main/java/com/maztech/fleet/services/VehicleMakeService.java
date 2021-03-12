package com.maztech.fleet.services;

import com.maztech.fleet.entities.VehicleMake;
import com.maztech.fleet.repos.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMakeService {
    @Autowired
    VehicleMakeRepository vehicleMakeRepository;

    //return list of countries
    public List<VehicleMake> getVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    //Save new vehicleMake
    public void saveVehicleMake(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }

    public VehicleMake findVehicleMakeById(int id){
        return vehicleMakeRepository.findById(id).get();
    }


    public void deleteVehicleMake(int id) {
        vehicleMakeRepository.deleteById(id);
    }
}
