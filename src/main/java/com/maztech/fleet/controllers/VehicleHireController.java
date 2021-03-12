package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.VehicleHire;
import com.maztech.fleet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VehicleHireController {

    @Autowired
    VehicleHireService vehicleHireService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    LocationService locationService;
    @Autowired
    ClientService clientService;

    //return list of vehicleHires
    @GetMapping("/vehiclehires")
    public String getVehicleHires(Model model){

        model.addAttribute("vehicleHires",vehicleHireService.getVehicleHires());
        model.addAttribute("vehicles",vehicleService.getVehicles());
        model.addAttribute("locations",locationService.getLocations());
        model.addAttribute("clients",clientService.getClients());

        return "vehicleHire";
    }

    //Save new vehicleHire
    @PostMapping("/vehicleHires/addNew")
    public String addVehicleHire(VehicleHire vehicleHire) {
        vehicleHireService.saveVehicleHire(vehicleHire);

        return "redirect:/vehiclehires";
    }

    @GetMapping("vehicleHires/find")
    @ResponseBody
    public VehicleHire findVehicleHireById(@RequestParam("id") int id){

        return vehicleHireService.findVehicleHireById(id);
    }

    @RequestMapping(value = "/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleHire(VehicleHire vehicleHire) {
        vehicleHireService.saveVehicleHire(vehicleHire);

        return "redirect:/vehiclehires";
    }

    @RequestMapping(value = "/vehicleHires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleHire(int id) {
        vehicleHireService.deleteVehicleHire(id);

        return "redirect:/vehiclehires";
    }
    
}
