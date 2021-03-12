package com.maztech.fleet.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends Person {

    private String photo;
    private String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name="employeetypeid", insertable = false, updatable = false)
    private EmployeeType employeeType;
    private Integer employeetypeid;

    @ManyToOne
    @JoinColumn(name="jobtitleid", insertable = false, updatable = false)
    private JobTitle jobTitle;
    private Integer jobtitleid;




}
