package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Employee;
import com.maztech.fleet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class EmployeeController {

    @Autowired EmployeeService employeeService;
    @Autowired JobTitleService jobTitleService;
    @Autowired EmployeeTypeService employeeTypeService;
    @Autowired CountryService countryService;
    @Autowired StateService stateService;

    //return list of employees
    @GetMapping("/employee")
    public String getEmployees(Model model, String keyword) {

        model.addAttribute("countries",countryService.getCountries());
        model.addAttribute("states",stateService.getStates());
        model.addAttribute("jobTitles",jobTitleService.getJobTitles());
        model.addAttribute("employeeTypes",employeeTypeService.getEmployeeTypes());

        if (keyword != null) {
            model.addAttribute("employees", employeeService.findByKeyword(keyword));
        } else {
            model.addAttribute("employees", employeeService.getEmployees());
        }

        return "employee";
    }

    //Save new employee
    @PostMapping("/employees/addNew")
    public String addEmployee(Employee employee, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        employeeService.saveEmployee(employee);
        String baseDirectory = "C:\\Users\\maztech\\eclipse-workspace-2020\\fleet\\src\\main\\resources\\static\\img\\employeePhotos\\";
        file.transferTo(new File(baseDirectory + employee.getId() + ".jpg"));
        employee.setPhoto(employee.getFirstname() + " " + employee.getLastname());


        return "redirect:/employee";
    }

    //Trouver un employee par ID
    @GetMapping("employees/find")
    @ResponseBody
    public Employee findEmployeeById(@RequestParam("id") int id){

        return employeeService.findEmployeeById(id);
    }


    // Supprimer employee
    @RequestMapping(value = "/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmployee(int id) {
        employeeService.deleteEmployee(id);

        return "redirect:/employee";
    }


    // ajouter un username à un employee
    @GetMapping(value = "/employee/assignUsername")
    public String assignUsername(int id) {
        employeeService.assignUsername(id);
        return "redirect:/employee";
    }
}
