package com.maztech.fleet.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;
    private String address;
    private String description;
    private String details;

    @ManyToOne
    @JoinColumn(name="stateid", insertable = false, updatable = false)
    private State state;
    private Integer stateid;

    @ManyToOne
    @JoinColumn(name="countryid", insertable = false, updatable = false)
    private Country country;
    private Integer countryid;



}
