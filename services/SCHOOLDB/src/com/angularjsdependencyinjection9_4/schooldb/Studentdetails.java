/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.schooldb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Studentdetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`STUDENTDETAILS`", uniqueConstraints = {
            @UniqueConstraint(name = "`SQL170810101628360`", columnNames = {"`STUDENTIDENTIFICATIONID`"})})
public class Studentdetails implements Serializable {

    private Integer studentid;
    private String studentname;
    private Date dateofbirth;
    private String fathername;
    private String address;
    private Date joiningdate;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] profilepic;
    private String status;
    private String contactnumber;
    private String gender;
    private int studentidentificationid;
    private Studentidentification studentidentification;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`STUDENTID`", nullable = false, scale = 0, precision = 10)
    public Integer getStudentid() {
        return this.studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    @Column(name = "`STUDENTNAME`", nullable = false, length = 255)
    public String getStudentname() {
        return this.studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    @Column(name = "`DATEOFBIRTH`", nullable = false)
    public Date getDateofbirth() {
        return this.dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    @Column(name = "`FATHERNAME`", nullable = false, length = 255)
    public String getFathername() {
        return this.fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Column(name = "`ADDRESS`", nullable = false, length = 255)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "`JOININGDATE`", nullable = false)
    public Date getJoiningdate() {
        return this.joiningdate;
    }

    public void setJoiningdate(Date joiningdate) {
        this.joiningdate = joiningdate;
    }

    @Column(name = "`PROFILEPIC`", nullable = true)
    public byte[] getProfilepic() {
        return this.profilepic;
    }

    public void setProfilepic(byte[] profilepic) {
        this.profilepic = profilepic;
    }

    @Column(name = "`STATUS`", nullable = false, length = 255)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "`CONTACTNUMBER`", nullable = false, length = 10)
    public String getContactnumber() {
        return this.contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    @Column(name = "`GENDER`", nullable = true, length = 6)
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "`STUDENTIDENTIFICATIONID`", nullable = false, scale = 0, precision = 10)
    public int getStudentidentificationid() {
        return this.studentidentificationid;
    }

    public void setStudentidentificationid(int studentidentificationid) {
        this.studentidentificationid = studentidentificationid;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`STUDENTIDENTIFICATIONID`", referencedColumnName = "`IDENTIFICATIONID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FKSTUDENTDETAILSTOSTMYTTN`"))
    @Fetch(FetchMode.JOIN)
    public Studentidentification getStudentidentification() {
        return this.studentidentification;
    }

    public void setStudentidentification(Studentidentification studentidentification) {
        if(studentidentification != null) {
            this.studentidentificationid = studentidentification.getIdentificationid();
        }

        this.studentidentification = studentidentification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Studentdetails)) return false;
        final Studentdetails studentdetails = (Studentdetails) o;
        return Objects.equals(getStudentid(), studentdetails.getStudentid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentid());
    }
}