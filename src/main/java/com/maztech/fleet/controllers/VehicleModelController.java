package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.VehicleModel;
import com.maztech.fleet.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleModelController {

    @Autowired
    VehicleModelService vehicleModelService;

    //return list of vehicleModels
    @GetMapping("/vehiclemodels")
    public String getVehicleModels(Model model){
        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();

        model.addAttribute("vehicleModels",vehicleModelList);

        return "vehicleModel";
    }

    //Save new vehicleModel
    @PostMapping("/vehicleModels/addNew")
    public String addVehicleModel(VehicleModel vehicleModel) {
        vehicleModelService.saveVehicleModel(vehicleModel);

        return "redirect:/vehiclemodels";
    }

    @GetMapping("vehicleModels/find")
    @ResponseBody
    public VehicleModel findVehicleModelById(@RequestParam("id") int id){

        return vehicleModelService.findVehicleModelById(id);
    }

    @RequestMapping(value = "/vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleModel(VehicleModel vehicleModel) {
        vehicleModelService.saveVehicleModel(vehicleModel);

        return "redirect:/vehiclemodels";
    }

    @RequestMapping(value = "/vehicleModels/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleModel(int id) {
        vehicleModelService.deleteVehicleModel(id);

        return "redirect:/vehiclemodels";
    }

}
