package com.maztech.fleet.services;

import com.maztech.fleet.entities.VehicleModel;
import com.maztech.fleet.repos.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleModelService {

    @Autowired
    VehicleModelRepository vehicleModelRepository;

    //return list of vehiclemodels
    public List<VehicleModel> getVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    //Save new vehicleModel
    public void saveVehicleModel(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }

    public VehicleModel findVehicleModelById(int id){
        return vehicleModelRepository.findById(id).get();
    }


    public void deleteVehicleModel(int id) {
        vehicleModelRepository.deleteById(id);
    }
    
}
