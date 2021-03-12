package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Country;
import com.maztech.fleet.entities.VehicleStatus;
import com.maztech.fleet.entities.State;
import com.maztech.fleet.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleStatusController {

    @Autowired
    VehicleStatusService vehicleStatusService;

    //return list of vehicleStatus
    @GetMapping("/vehiclestatus")
    public String getVehicleStatus(Model model){
        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();

        model.addAttribute("vehicleStatus",vehicleStatusList);

        return "vehicleStatus";
    }

    //Save new vehicleStatus
    @PostMapping("/vehicleStatus/addNew")
    public String addVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusService.saveVehicleStatus(vehicleStatus);

        return "redirect:/vehiclestatus";
    }

    @GetMapping("vehicleStatus/find")
    @ResponseBody
    public VehicleStatus findVehicleStatusById(@RequestParam("id") int id){

        return vehicleStatusService.findVehicleStatusById(id);
    }

    @RequestMapping(value = "/vehicleStatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusService.saveVehicleStatus(vehicleStatus);

        return "redirect:/vehiclestatus";
    }

    @RequestMapping(value = "/vehicleStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleStatus(int id) {
        vehicleStatusService.deleteVehicleStatus(id);

        return "redirect:/vehiclestatus";
    }
}
