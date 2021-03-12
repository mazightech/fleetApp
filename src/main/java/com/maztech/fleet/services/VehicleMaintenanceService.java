package com.maztech.fleet.services;

import com.maztech.fleet.entities.VehicleMaintenance;
import com.maztech.fleet.repos.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMaintenanceService {

    @Autowired
    VehicleMaintenanceRepository vehicleMaintenanceRepository;

    //return list of VehicleMaintenances
    public List<VehicleMaintenance> getVehicleMaintenances() {
        return vehicleMaintenanceRepository.findAll();
    }

    //Save new vehicleMaintenance
    public void saveVehicleMaintenance(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public VehicleMaintenance findVehicleMaintenanceById(int id){
        return vehicleMaintenanceRepository.findById(id).get();
    }


    public void deleteVehicleMaintenance(int id) {
        vehicleMaintenanceRepository.deleteById(id);
    }
}
