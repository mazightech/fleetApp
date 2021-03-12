package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.VehicleMovement;
import com.maztech.fleet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VehicleMovementController {

    @Autowired
    VehicleMovementService vehicleMovementService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    LocationService locationService;

    //return list of vehicleMovements
    @GetMapping("/vehiclemovements")
    public String getVehicleMovements(Model model){

        model.addAttribute("vehicleMovements",vehicleMovementService.getVehicleMovements());
        model.addAttribute("vehicles",vehicleService.getVehicles());
        model.addAttribute("locations",locationService.getLocations());

        return "vehicleMovement";
    }

    //Save new vehicleMovement
    @PostMapping("/vehicleMovements/addNew")
    public String addVehicleMovement(VehicleMovement vehicleMovement) {
        vehicleMovementService.saveVehicleMovement(vehicleMovement);

        return "redirect:/vehiclemovements";
    }

    @GetMapping("vehicleMovements/find")
    @ResponseBody
    public VehicleMovement findVehicleMovementById(@RequestParam("id") int id){

        return vehicleMovementService.findVehicleMovementById(id);
    }

    @RequestMapping(value = "/vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleMovement(VehicleMovement vehicleMovement) {
        vehicleMovementService.saveVehicleMovement(vehicleMovement);

        return "redirect:/vehiclemovements";
    }

    @RequestMapping(value = "/vehicleMovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMovement(int id) {
        vehicleMovementService.deleteVehicleMovement(id);

        return "redirect:/vehiclemovements";
    }
}
