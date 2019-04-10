/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * TUcComposite3 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`T_UC_COMPOSITE3`")
@IdClass(TUcComposite3Id.class)
public class TUcComposite3 implements Serializable {

    private Short byteId;
    private String stringCol;
    private Boolean booleanCol;

    @Id
    @Column(name = "`BYTE ID`", nullable = false, scale = 0, precision = 5)
    public Short getByteId() {
        return this.byteId;
    }

    public void setByteId(Short byteId) {
        this.byteId = byteId;
    }

    @Id
    @Column(name = "`STRING COL`", nullable = false, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Column(name = "`BOOLEAN COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TUcComposite3)) return false;
        final TUcComposite3 tucComposite3 = (TUcComposite3) o;
        return Objects.equals(getByteId(), tucComposite3.getByteId()) &&
                Objects.equals(getStringCol(), tucComposite3.getStringCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getByteId(),
                getStringCol());
    }
}