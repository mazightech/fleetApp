package com.maztech.fleet.repos;

import com.maztech.fleet.entities.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleMovementRepository extends JpaRepository<VehicleMovement,Integer> {

}
