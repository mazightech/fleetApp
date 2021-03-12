package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.VehicleMake;
import com.maztech.fleet.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleMakeController {

    @Autowired
    VehicleMakeService vehicleMakeService;

    //return list of vehicleMakes
    @GetMapping("/vehiclemakes")
    public String getVehicleMakes(Model model){
        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();

        model.addAttribute("vehicleMakes",vehicleMakeList);
        return "vehicleMake";
    }

    //Save new vehicleMake
    @PostMapping("/vehicleMakes/addNew")
    public String addVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeService.saveVehicleMake(vehicleMake);

        return "redirect:/vehiclemakes";
    }

    @GetMapping("vehicleMakes/find")
    @ResponseBody
    public VehicleMake findVehicleMakeById(@RequestParam("id") int id){

        return vehicleMakeService.findVehicleMakeById(id);
    }

    @RequestMapping(value = "/vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeService.saveVehicleMake(vehicleMake);

        return "redirect:/vehiclemakes";
    }

    @RequestMapping(value = "/vehicleMakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMake(int id) {
        vehicleMakeService.deleteVehicleMake(id);

        return "redirect:/vehiclemakes";
    }
}
