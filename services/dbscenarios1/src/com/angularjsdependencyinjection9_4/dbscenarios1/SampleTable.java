/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * SampleTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SampleTable`")
@IdClass(SampleTableId.class)
public class SampleTable implements Serializable {

    private Integer intId;
    private Date dateId;
    private String stringCol1;
    private String stringCol2;

    @Id
    @Column(name = "`IntId`", nullable = false, scale = 0, precision = 10)
    public Integer getIntId() {
        return this.intId;
    }

    public void setIntId(Integer intId) {
        this.intId = intId;
    }

    @Id
    @Column(name = "`DateId`", nullable = false)
    public Date getDateId() {
        return this.dateId;
    }

    public void setDateId(Date dateId) {
        this.dateId = dateId;
    }

    @Column(name = "`StringCol1`", nullable = true, length = 255)
    public String getStringCol1() {
        return this.stringCol1;
    }

    public void setStringCol1(String stringCol1) {
        this.stringCol1 = stringCol1;
    }

    @Column(name = "`StringCol2`", nullable = true, length = 255)
    public String getStringCol2() {
        return this.stringCol2;
    }

    public void setStringCol2(String stringCol2) {
        this.stringCol2 = stringCol2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SampleTable)) return false;
        final SampleTable sampleTable = (SampleTable) o;
        return Objects.equals(getIntId(), sampleTable.getIntId()) &&
                Objects.equals(getDateId(), sampleTable.getDateId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIntId(),
                getDateId());
    }
}