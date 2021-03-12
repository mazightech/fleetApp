package com.maztech.fleet.services;

import com.maztech.fleet.entities.InvoiceStatus;
import com.maztech.fleet.repos.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceStatusService {

    @Autowired
    InvoiceStatusRepository invoiceStatusRepository;

    //return list of invoiceStatus
    public List<InvoiceStatus> getInvoiceStatus() {
        return invoiceStatusRepository.findAll();
    }

    //Save new invoiceStatus
    public void saveInvoiceStatus(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
    }

    public InvoiceStatus findInvoiceStatusById(int id){
        return invoiceStatusRepository.findById(id).get();
    }


    public void deleteInvoiceStatus(int id) {
        invoiceStatusRepository.deleteById(id);
    }
    
}
