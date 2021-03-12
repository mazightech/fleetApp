package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Vehicle;
import com.maztech.fleet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VehicleController {

    //Vehicles
    @Autowired private VehicleService vehicleService;
    //Location
    @Autowired private LocationService locationService;
    //Employee
    @Autowired private EmployeeService employeeService;
    //VehicleMake
    @Autowired private VehicleMakeService vehicleMakeService;
    //VehicleStatus
    @Autowired private VehicleStatusService vehicleStatusService;
    //VehicleType
    @Autowired private VehicleTypeService vehicleTypeService;
    //VehicleModel
    @Autowired private VehicleModelService vehicleModelService;

    //return list of vehicles
    @GetMapping("/vehicles")
    public String getVehicles(Model model){

        model.addAttribute("vehicles",vehicleService.getVehicles());
        model.addAttribute("locations",locationService.getLocations());
        model.addAttribute("employees",employeeService.getEmployees());
        model.addAttribute("vehicleMakes",vehicleMakeService.getVehicleMakes());
        model.addAttribute("vehicleStatuses",vehicleStatusService.getVehicleStatus());
        model.addAttribute("vehicleTypes",vehicleTypeService.getVehicleTypes());
        model.addAttribute("vehicleModels",vehicleModelService.getVehicleModels());

        return "vehicle";
    }

    //Save new vehicle
    @PostMapping("/vehicles/addNew")
    public String addVehicle(Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);

        return "redirect:/vehicles";
    }

    @GetMapping("vehicles/find")
    @ResponseBody
    public Vehicle findVehicleById(@RequestParam("id") int id){

        return vehicleService.findVehicleById(id);
    }

    @RequestMapping(value = "/vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicle(Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);

        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicle(int id) {
        vehicleService.deleteVehicle(id);

        return "redirect:/vehicles";
    }
    
}
