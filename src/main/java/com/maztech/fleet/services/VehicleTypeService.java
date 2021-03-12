package com.maztech.fleet.services;

import com.maztech.fleet.entities.VehicleType;
import com.maztech.fleet.repos.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    //return list of countries
    public List<VehicleType> getVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    //Save new vehicleType
    public void saveVehicleType(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }

    public VehicleType findVehicleTypeById(int id){
        return vehicleTypeRepository.findById(id).get();
    }


    public void deleteVehicleType(int id) {
        vehicleTypeRepository.deleteById(id);
    }
    
}
