package com.maztech.fleet.services;

import com.maztech.fleet.entities.Employee;
import com.maztech.fleet.entities.Employee;
import com.maztech.fleet.repos.EmployeeRepository;
import com.maztech.fleet.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //return list of Employees
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    //Save new employee
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee findEmployeeById(int id){
        return employeeRepository.findById(id).get();
    }


    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
    
}
