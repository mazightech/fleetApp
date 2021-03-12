package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.VehicleType;
import com.maztech.fleet.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleTypeController {

    @Autowired
    VehicleTypeService vehicleTypeService;

    //return list of vehicleTypes
    @GetMapping("/vehicletypes")
    public String getVehicleTypes(Model model){
        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();

        model.addAttribute("vehicleTypes",vehicleTypeList);

        return "vehicleType";
    }

    //Save new vehicleType
    @PostMapping("/vehicleTypes/addNew")
    public String addVehicleType(VehicleType vehicleType) {
        vehicleTypeService.saveVehicleType(vehicleType);

        return "redirect:/vehicletypes";
    }

    @GetMapping("vehicleTypes/find")
    @ResponseBody
    public VehicleType findVehicleTypeById(@RequestParam("id") int id){

        return vehicleTypeService.findVehicleTypeById(id);
    }

    @RequestMapping(value = "/vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleType(VehicleType vehicleType) {
        vehicleTypeService.saveVehicleType(vehicleType);

        return "redirect:/vehicletypes";
    }

    @RequestMapping(value = "/vehicleTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleType(int id) {
        vehicleTypeService.deleteVehicleType(id);

        return "redirect:/vehicletypes";
    }
    
}
