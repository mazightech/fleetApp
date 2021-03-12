package com.maztech.fleet.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleHire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String timeOut;
    private String timeIn;
    private String price;
    private String remarks;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;

    @ManyToOne
    @JoinColumn(name="vehicleid", insertable = false, updatable= false)
    private Vehicle vehicle;
    private Integer vehicleid;

    @ManyToOne
    @JoinColumn(name="clientid", insertable = false, updatable= false)
    private Client client;
    private Integer clientid;

    @ManyToOne
    @JoinColumn(name="locationid", insertable = false, updatable= false)
    private Location location;
    private Integer locationid;
}
