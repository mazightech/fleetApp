package com.maztech.fleet.repos;

import com.maztech.fleet.entities.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus,Integer> {

}
