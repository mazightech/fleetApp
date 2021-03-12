package com.maztech.fleet.services;

import com.maztech.fleet.entities.EmployeeType;
import com.maztech.fleet.repos.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypeService {

    @Autowired
    EmployeeTypeRepository employeeTypeRepository;

    //return list of employeeType
    public List<EmployeeType> getEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    //Save new employeeType
    public void saveEmployeeType(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    public EmployeeType findEmployeeTypeById(int id){
        return employeeTypeRepository.findById(id).get();
    }


    public void deleteEmployeeType(int id) {
        employeeTypeRepository.deleteById(id);
    }
    
}
