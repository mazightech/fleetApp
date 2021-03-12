package com.maztech.fleet.services;

import com.maztech.fleet.entities.Supplier;
import com.maztech.fleet.repos.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    //return list of Suppliers
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    //Save new supplier
    public void saveSupplier(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public Supplier findSupplierById(int id){
        return supplierRepository.findById(id).get();
    }


    public void deleteSupplier(int id) {
        supplierRepository.deleteById(id);
    }
    
}
