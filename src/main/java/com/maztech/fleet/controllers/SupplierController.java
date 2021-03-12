package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Supplier;
import com.maztech.fleet.services.SupplierService;
import com.maztech.fleet.services.CountryService;
import com.maztech.fleet.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;
    @Autowired
    CountryService countryService;
    @Autowired
    StateService stateService;

    //return list of suppliers
    @GetMapping("/suppliers")
    public String getSuppliers(Model model){

        model.addAttribute("suppliers",supplierService.getSuppliers());
        model.addAttribute("countries",countryService.getCountries());
        model.addAttribute("states",stateService.getStates());

        return "supplier";
    }

    //Save new supplier
    @PostMapping("/suppliers/addNew")
    public String addSupplier(Supplier supplier) {
        supplierService.saveSupplier(supplier);

        return "redirect:/suppliers";
    }

    @GetMapping("suppliers/find")
    @ResponseBody
    public Supplier findSupplierById(@RequestParam("id") int id){

        return supplierService.findSupplierById(id);
    }

    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateSupplier(Supplier supplier) {
        supplierService.saveSupplier(supplier);

        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteSupplier(int id) {
        supplierService.deleteSupplier(id);

        return "redirect:/suppliers";
    }
}
