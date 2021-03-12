package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Contact;
import com.maztech.fleet.services.ContactService;
import com.maztech.fleet.services.CountryService;
import com.maztech.fleet.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;
    @Autowired
    CountryService countryService;
    @Autowired
    StateService stateService;

    //return list of contacts
    @GetMapping("/contacts")
    public String getContacts(Model model){

        model.addAttribute("contacts",contactService.getContacts());
        model.addAttribute("countries",countryService.getCountries());
        model.addAttribute("states",stateService.getStates());

        return "contacts";
    }

    //Save new contact
    @PostMapping("/contacts/addNew")
    public String addContact(Contact contact) {
        contactService.saveContact(contact);

        return "redirect:/contacts";
    }

    @GetMapping("contacts/find")
    @ResponseBody
    public Contact findContactById(@RequestParam("id") int id){

        return contactService.findContactById(id);
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateContact(Contact contact) {
        contactService.saveContact(contact);

        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteContact(int id) {
        contactService.deleteContact(id);

        return "redirect:/contacts";
    }
}
