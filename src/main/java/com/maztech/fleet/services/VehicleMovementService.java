package com.maztech.fleet.services;

import com.maztech.fleet.entities.VehicleMovement;
import com.maztech.fleet.repos.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMovementService {

    @Autowired
    VehicleMovementRepository vehicleMovementRepository;

    //return list of VehicleMovements
    public List<VehicleMovement> getVehicleMovements() {
        return vehicleMovementRepository.findAll();
    }

    //Save new vehicleMovement
    public void saveVehicleMovement(VehicleMovement vehicleMovement){
        vehicleMovementRepository.save(vehicleMovement);
    }

    public VehicleMovement findVehicleMovementById(int id){
        return vehicleMovementRepository.findById(id).get();
    }


    public void deleteVehicleMovement(int id) {
        vehicleMovementRepository.deleteById(id);
    }
    
}
