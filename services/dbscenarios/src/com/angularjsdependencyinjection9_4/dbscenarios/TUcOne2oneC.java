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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * TUcOne2oneC generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`T_UC_ONE2ONE_C`")
public class TUcOne2oneC implements Serializable {

    private String stringId;
    private short byteCol;
    private String charCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobCol;

    @Id
    @Column(name = "`STRING ID`", nullable = false, length = 255)
    public String getStringId() {
        return this.stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    @Column(name = "`BYTE COL`", nullable = false, scale = 0, precision = 5)
    public short getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(short byteCol) {
        this.byteCol = byteCol;
    }

    @Column(name = "`CHAR COL`", nullable = false, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Column(name = "`BLOB COL`", nullable = true)
    public byte[] getBlobCol() {
        return this.blobCol;
    }

    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TUcOne2oneC)) return false;
        final TUcOne2oneC tucOne2oneC = (TUcOne2oneC) o;
        return Objects.equals(getStringId(), tucOne2oneC.getStringId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStringId());
    }
}