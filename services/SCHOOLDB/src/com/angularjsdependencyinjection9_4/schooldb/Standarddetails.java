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
 * Standarddetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`STANDARDDETAILS`", uniqueConstraints = {
            @UniqueConstraint(name = "`SQL170810084201180`", columnNames = {"`STANDARDCODE`"})})
public class Standarddetails implements Serializable {

    private Integer standardid;
    private String standardcode;
    private String standardname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`STANDARDID`", nullable = false, scale = 0, precision = 10)
    public Integer getStandardid() {
        return this.standardid;
    }

    public void setStandardid(Integer standardid) {
        this.standardid = standardid;
    }

    @Column(name = "`STANDARDCODE`", nullable = false, length = 255)
    public String getStandardcode() {
        return this.standardcode;
    }

    public void setStandardcode(String standardcode) {
        this.standardcode = standardcode;
    }

    @Column(name = "`STANDARDNAME`", nullable = false, length = 255)
    public String getStandardname() {
        return this.standardname;
    }

    public void setStandardname(String standardname) {
        this.standardname = standardname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Standarddetails)) return false;
        final Standarddetails standarddetails = (Standarddetails) o;
        return Objects.equals(getStandardid(), standarddetails.getStandardid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStandardid());
    }
}