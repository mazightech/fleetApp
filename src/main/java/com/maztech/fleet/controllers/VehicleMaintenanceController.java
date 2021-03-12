package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.VehicleMaintenance;
import com.maztech.fleet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    SupplierService supplierService;

    //return list of vehicleMaintenances
    @GetMapping("/vehiclemaintenance")
    public String getVehicleMaintenances(Model model){

        model.addAttribute("vehicleMaintenances",vehicleMaintenanceService.getVehicleMaintenances());
        model.addAttribute("vehicles",vehicleService.getVehicles());
        model.addAttribute("suppliers",supplierService.getSuppliers());

        return "vehicleMaintenance";
    }

    //Save new vehicleMaintenance
    @PostMapping("/vehicleMaintenances/addNew")
    public String addVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.saveVehicleMaintenance(vehicleMaintenance);

        return "redirect:/vehiclemaintenance";
    }

    @GetMapping("vehicleMaintenances/find")
    @ResponseBody
    public VehicleMaintenance findVehicleMaintenanceById(@RequestParam("id") int id){

        return vehicleMaintenanceService.findVehicleMaintenanceById(id);
    }

    @RequestMapping(value = "/vehicleMaintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.saveVehicleMaintenance(vehicleMaintenance);

        return "redirect:/vehiclemaintenance";
    }

    @RequestMapping(value = "/vehicleMaintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMaintenance(int id) {
        vehicleMaintenanceService.deleteVehicleMaintenance(id);

        return "redirect:/vehiclemaintenance";
    }
}
