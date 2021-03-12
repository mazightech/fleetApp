package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Country;
import com.maztech.fleet.entities.EmployeeType;
import com.maztech.fleet.entities.State;
import com.maztech.fleet.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeTypeController {

    @Autowired
    EmployeeTypeService employeeTypeService;

    //return list of employeeTypes
    @GetMapping("/employeetype")
    public String getEmployeeTypes(Model model){
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();

        model.addAttribute("employeeTypes",employeeTypeList);

        return "employeeType";
    }

    //Save new employeeType
    @PostMapping("/employeeTypes/addNew")
    public String addEmployeeType(EmployeeType employeeType) {
        employeeTypeService.saveEmployeeType(employeeType);

        return "redirect:/employeetype";
    }

    @GetMapping("employeeTypes/find")
    @ResponseBody
    public EmployeeType findEmployeeTypeById(@RequestParam("id") int id){

        return employeeTypeService.findEmployeeTypeById(id);
    }

    @RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployeeType(EmployeeType employeeType) {
        employeeTypeService.saveEmployeeType(employeeType);

        return "redirect:/employeetype";
    }

    @RequestMapping(value = "/employeeTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmployeeType(int id) {
        employeeTypeService.deleteEmployeeType(id);

        return "redirect:/employeetype";
    }
}
