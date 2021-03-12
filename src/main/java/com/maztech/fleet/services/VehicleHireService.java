package com.maztech.fleet.services;

import com.maztech.fleet.entities.VehicleHire;
import com.maztech.fleet.repos.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleHireService {

    @Autowired
    VehicleHireRepository vehicleHireRepository;

    //return list of VehicleHires
    public List<VehicleHire> getVehicleHires() {
        return vehicleHireRepository.findAll();
    }

    //Save new vehicleHire
    public void saveVehicleHire(VehicleHire vehicleHire){
        vehicleHireRepository.save(vehicleHire);
    }

    public VehicleHire findVehicleHireById(int id){
        return vehicleHireRepository.findById(id).get();
    }


    public void deleteVehicleHire(int id) {
        vehicleHireRepository.deleteById(id);
    }
    
}
