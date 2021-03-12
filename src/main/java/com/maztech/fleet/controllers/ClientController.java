package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Client;
import com.maztech.fleet.entities.Country;
import com.maztech.fleet.entities.State;
import com.maztech.fleet.services.ClientService;
import com.maztech.fleet.services.CountryService;
import com.maztech.fleet.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    CountryService countryService;
    @Autowired
    StateService stateService;

    //return list of clients
    @GetMapping("/clients")
    public String getClients(Model model){

        model.addAttribute("clients",clientService.getClients());
        model.addAttribute("countries",countryService.getCountries());
        model.addAttribute("states",stateService.getStates());

        return "client";
    }

    //Save new client
    @PostMapping("/clients/addNew")
    public String addClient(Client client) {
        clientService.saveClient(client);

        return "redirect:/clients";
    }

    @GetMapping("clients/find")
    @ResponseBody
    public Client findClientById(@RequestParam("id") int id){

        return clientService.findClientById(id);
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateClient(Client client) {
        clientService.saveClient(client);

        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteClient(int id) {
        clientService.deleteClient(id);

        return "redirect:/clients";
    }
}
