package com.maztech.fleet.repos;

import com.maztech.fleet.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

    @Transactional
    void deleteAllByClientid(int id);

}
