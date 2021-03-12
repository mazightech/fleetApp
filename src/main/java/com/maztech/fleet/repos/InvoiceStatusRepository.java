package com.maztech.fleet.repos;

import com.maztech.fleet.entities.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus,Integer> {

}
