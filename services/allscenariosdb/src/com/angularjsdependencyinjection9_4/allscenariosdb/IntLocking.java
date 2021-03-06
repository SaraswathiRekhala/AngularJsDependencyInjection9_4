/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.allscenariosdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * IntLocking generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`INT LOCKING`", schema = "`dbo`")
public class IntLocking implements Serializable {

    private Integer pkId;
    private Boolean booleanCol;
    private Date dateCol;
    private Byte intVersion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`PK ID`", nullable = false, scale = 0, precision = 10)
    public Integer getPkId() {
        return this.pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    @Column(name = "`BOOLEAN COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`DATE COL`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Column(name = "`INT VERSION`", nullable = true, scale = 0, precision = 2)
    public Byte getIntVersion() {
        return this.intVersion;
    }

    public void setIntVersion(Byte intVersion) {
        this.intVersion = intVersion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntLocking)) return false;
        final IntLocking intLocking = (IntLocking) o;
        return Objects.equals(getPkId(), intLocking.getPkId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkId());
    }
}