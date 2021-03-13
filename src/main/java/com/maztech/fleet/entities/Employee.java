package com.maztech.fleet.entities;

import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
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


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getEmployeetypeid() {
        return employeetypeid;
    }

    public void setEmployeetypeid(Integer employeetypeid) {
        this.employeetypeid = employeetypeid;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getJobtitleid() {
        return jobtitleid;
    }

    public void setJobtitleid(Integer jobtitleid) {
        this.jobtitleid = jobtitleid;
    }
}
