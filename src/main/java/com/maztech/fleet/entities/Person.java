package com.maztech.fleet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String othername;
    private String title;
    private String initials;
    private String socialSecurityNumber;
    private String gender;
    private String matrialStatus;

    private String city;
    private String address;
    private String phone;
    private String mobile;
    private String email;
    private String photo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;


    @ManyToOne
    @JoinColumn(name="countryid", insertable = false, updatable = false)
    private Country country;
    private Integer countryid;

    @ManyToOne
    @JoinColumn(name="stateid", insertable = false, updatable = false)
    private State state;
    private Integer stateid;

}
