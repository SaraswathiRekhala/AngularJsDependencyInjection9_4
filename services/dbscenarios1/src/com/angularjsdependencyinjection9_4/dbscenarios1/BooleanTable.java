/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BooleanTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`BooleanTable`")
public class BooleanTable implements Serializable {

    private Integer pkid;
    private String stringCol;
    private Boolean booleanCol;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`PKID`", nullable = false, scale = 0, precision = 10)
    public Integer getPkid() {
        return this.pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    @Column(name = "`StringCol`", nullable = true, length = 25)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Column(name = "`BooleanCol`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BooleanTable)) return false;
        final BooleanTable booleanTable = (BooleanTable) o;
        return Objects.equals(getPkid(), booleanTable.getPkid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkid());
    }
}