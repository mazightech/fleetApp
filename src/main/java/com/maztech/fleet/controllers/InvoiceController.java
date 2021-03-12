package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.Invoice;
import com.maztech.fleet.services.ClientService;
import com.maztech.fleet.services.InvoiceService;
import com.maztech.fleet.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;
    @Autowired
    ClientService clientService;
    @Autowired
    InvoiceStatusService invoiceStatusService;

    //return list of invoices
    @GetMapping("/invoices")
    public String getInvoices(Model model){

        model.addAttribute("invoices",invoiceService.getInvoices());
        model.addAttribute("clients",clientService.getClients());
        model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatus());

        return "invoice";
    }

    //Save new invoice
    @PostMapping("/invoices/addNew")
    public String addInvoice(Invoice invoice) {
        invoiceService.saveInvoice(invoice);

        return "redirect:/invoices";
    }

    @GetMapping("invoices/find")
    @ResponseBody
    public Invoice findInvoiceById(@RequestParam("id") int id){

        return invoiceService.findInvoiceById(id);
    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateInvoice(Invoice invoice) {
        invoiceService.saveInvoice(invoice);

        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteInvoice(int id) {
        invoiceService.deleteInvoice(id);

        return "redirect:/invoices";
    }
}
