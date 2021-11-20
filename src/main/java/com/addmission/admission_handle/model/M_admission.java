package com.addmission.admission_handle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "imsadmission")
public class M_admission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long rollno;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Phone_no", nullable = false)
    private int phoneno;

    @Column(name = "Course_id", nullable = false)
    private String courseid;

    @Column(name = "Date_of_admission", nullable = false)//this what i use to get date
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateofadmission;

    @Column(name = "Remark", nullable = false)
    private String remark;

    //default constructor
    public M_admission()
    {

    }

    //parameterised constructor
    public M_admission(Long rollno, String name, String address, int phoneno, String courseid, LocalDate dateofadmission, String remark) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
        this.courseid = courseid;
        this.dateofadmission = dateofadmission;
        this.remark = remark;
    }


    //getter setter


    public Long getRollno() {
        return rollno;
    }

    public void setRollno(Long rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public LocalDate getDateofadmission() {
        return dateofadmission;
    }

    public void setDateofadmission(LocalDate dateofadmission) {
        this.dateofadmission = dateofadmission;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
