/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.schooldb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Studentidentification generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`STUDENTIDENTIFICATION`", uniqueConstraints = {
            @UniqueConstraint(name = "`SQL170810101928780`", columnNames = {"`IDENTIFICATIONNUMBER`"})})
public class Studentidentification implements Serializable {

    private Integer identificationid;
    private String identificationtype;
    private String identificationnumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IDENTIFICATIONID`", nullable = false, scale = 0, precision = 10)
    public Integer getIdentificationid() {
        return this.identificationid;
    }

    public void setIdentificationid(Integer identificationid) {
        this.identificationid = identificationid;
    }

    @Column(name = "`IDENTIFICATIONTYPE`", nullable = true, length = 255)
    public String getIdentificationtype() {
        return this.identificationtype;
    }

    public void setIdentificationtype(String identificationtype) {
        this.identificationtype = identificationtype;
    }

    @Column(name = "`IDENTIFICATIONNUMBER`", nullable = false, length = 255)
    public String getIdentificationnumber() {
        return this.identificationnumber;
    }

    public void setIdentificationnumber(String identificationnumber) {
        this.identificationnumber = identificationnumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Studentidentification)) return false;
        final Studentidentification studentidentification = (Studentidentification) o;
        return Objects.equals(getIdentificationid(), studentidentification.getIdentificationid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentificationid());
    }
}