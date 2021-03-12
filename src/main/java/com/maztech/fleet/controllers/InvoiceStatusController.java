package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.InvoiceStatus;
import com.maztech.fleet.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceStatusController {

    @Autowired
    InvoiceStatusService invoiceStatusService;

    //return list of invoiceStatuses
    @GetMapping("/invoiceStatus")
    public String getInvoiceStatus(Model model){
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();
        model.addAttribute("invoiceStatuses",invoiceStatusList);

        return "invoiceStatus";
    }

    //Save new invoiceStatus
    @PostMapping("/invoiceStatuses/addNew")
    public String addInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusService.saveInvoiceStatus(invoiceStatus);

        return "redirect:/invoiceStatus";
    }

    @GetMapping("invoiceStatuses/find")
    @ResponseBody
    public InvoiceStatus findInvoiceStatusById(@RequestParam("id") int id){

        return invoiceStatusService.findInvoiceStatusById(id);
    }

    @RequestMapping(value = "/invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusService.saveInvoiceStatus(invoiceStatus);

        return "redirect:/invoiceStatus";
    }

    @RequestMapping(value = "/invoiceStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteInvoiceStatus(int id) {
        invoiceStatusService.deleteInvoiceStatus(id);

        return "redirect:/invoiceStatus";
    }
}
