package com.maztech.fleet.services;

import com.maztech.fleet.entities.VehicleStatus;
import com.maztech.fleet.repos.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleStatusService {

    @Autowired
    VehicleStatusRepository vehicleStatusRepository;

    //return list of vehicleStatus
    public List<VehicleStatus> getVehicleStatus() {
        return vehicleStatusRepository.findAll();
    }

    //Save new vehicleStatus
    public void saveVehicleStatus(VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }

    public VehicleStatus findVehicleStatusById(int id){
        return vehicleStatusRepository.findById(id).get();
    }


    public void deleteVehicleStatus(int id) {
        vehicleStatusRepository.deleteById(id);
    }
}
