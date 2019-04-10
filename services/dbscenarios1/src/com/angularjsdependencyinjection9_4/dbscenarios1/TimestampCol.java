/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TimestampCol generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TIMESTAMP_COL`")
public class TimestampCol implements Serializable {

    private Integer id;
    private Timestamp timestampcol1;
    private Timestamp timestampcol2;
    private Timestamp timestampcol3;
    private Timestamp timestampcol;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`TIMESTAMPCOL1`", nullable = false)
    public Timestamp getTimestampcol1() {
        return this.timestampcol1;
    }

    public void setTimestampcol1(Timestamp timestampcol1) {
        this.timestampcol1 = timestampcol1;
    }

    @Column(name = "`TIMESTAMPCOL2`", nullable = false)
    public Timestamp getTimestampcol2() {
        return this.timestampcol2;
    }

    public void setTimestampcol2(Timestamp timestampcol2) {
        this.timestampcol2 = timestampcol2;
    }

    @Column(name = "`TIMESTAMPCOL3`", nullable = false)
    public Timestamp getTimestampcol3() {
        return this.timestampcol3;
    }

    public void setTimestampcol3(Timestamp timestampcol3) {
        this.timestampcol3 = timestampcol3;
    }

    @Column(name = "`TIMESTAMPCOL`", nullable = false)
    public Timestamp getTimestampcol() {
        return this.timestampcol;
    }

    public void setTimestampcol(Timestamp timestampcol) {
        this.timestampcol = timestampcol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimestampCol)) return false;
        final TimestampCol timestampCol = (TimestampCol) o;
        return Objects.equals(getId(), timestampCol.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}