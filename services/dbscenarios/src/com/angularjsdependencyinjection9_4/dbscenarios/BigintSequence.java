/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BigintSequence generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`BIGINT SEQUENCE`")
public class BigintSequence implements Serializable {

    private Long bigintId;
    private Date dateCol;
    private Boolean booleanCol;
    private String stringCol;

    @Id
    @Column(name = "`BIGINT ID`", nullable = false, scale = 0, precision = 19)
    public Long getBigintId() {
        return this.bigintId;
    }

    public void setBigintId(Long bigintId) {
        this.bigintId = bigintId;
    }

    @Column(name = "`DATE COL`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Column(name = "`BOOLEAN COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`STRING COL`", nullable = true, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BigintSequence)) return false;
        final BigintSequence bigintSequence = (BigintSequence) o;
        return Objects.equals(getBigintId(), bigintSequence.getBigintId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBigintId());
    }
}