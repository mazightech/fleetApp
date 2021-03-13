package com.maztech.fleet.services;

import com.maztech.fleet.entities.Employee;
import com.maztech.fleet.entities.User;
import com.maztech.fleet.repos.EmployeeRepository;
import com.maztech.fleet.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    UserRepository userRepository;

    //return list of Employees
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    //Save new employee
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    //Find by ID
    public Employee findEmployeeById(int id){
        return employeeRepository.findById(id).get();
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    //Find by Username
    public Employee findEmployeeByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    //Get by Keyword
    public List<Employee> findByKeyword(String keyword) {
        return employeeRepository.findbyKeywords(keyword);
    }

    // Affecter un nom d'utilisateur à un employee récupéré par User par son nom et prénom.
    public void assignUsername(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstnameAndLastname(employee.getFirstname(), employee.getLastname());
        employee.setUsername(user.getUsername());
        employeeRepository.save(employee);
    }
}
