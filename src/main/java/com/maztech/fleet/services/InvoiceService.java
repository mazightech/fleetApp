package com.maztech.fleet.services;

import com.maztech.fleet.entities.Invoice;
import com.maztech.fleet.repos.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    //return list of invoices
    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    //Save new invoice
    public void saveInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public Invoice findInvoiceById(int id){
        return invoiceRepository.findById(id).get();
    }


    public void deleteInvoice(int id) {
        invoiceRepository.deleteById(id);
    }

    public void deleteAllByClientid(int id) {
        invoiceRepository.deleteAllByClientid(id);
    }
    
}
