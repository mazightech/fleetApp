package com.maztech.fleet.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class VehicleModel extends CommonObject {

}
