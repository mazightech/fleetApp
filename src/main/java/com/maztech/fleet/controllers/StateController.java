package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Country;
import com.maztech.fleet.entities.State;
import com.maztech.fleet.services.CountryService;
import com.maztech.fleet.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {

    @Autowired
    StateService stateService;
    @Autowired
    CountryService countryService;

    //return list of states
    @GetMapping("/states")
    public String getStates(Model model){
        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();

        model.addAttribute("states",stateList);
        model.addAttribute("countries",countryList);

        return "state";
    }

    //Save new state
    @PostMapping("/states/addNew")
    public String addState(State state) {
        stateService.saveState(state);

        return "redirect:/states";
    }

    @GetMapping("states/find")
    @ResponseBody
    public State findStateById(@RequestParam("id") int id){

        return stateService.findStateById(id);
    }

    @RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateState(State state) {
        stateService.saveState(state);

        return "redirect:/states";
    }

    @RequestMapping(value = "/states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteState(int id) {
        stateService.deleteState(id);

        return "redirect:/states";
    }
}
