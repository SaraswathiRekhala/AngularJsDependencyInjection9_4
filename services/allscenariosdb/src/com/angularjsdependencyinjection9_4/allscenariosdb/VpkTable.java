/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.allscenariosdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * VpkTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`VPK_TABLE`")
@IdClass(VpkTableId.class)
public class VpkTable implements Serializable {

    private Integer vpkId;
    private Boolean booleanCol;

    @Id
    @Column(name = "`VPK_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getVpkId() {
        return this.vpkId;
    }

    public void setVpkId(Integer vpkId) {
        this.vpkId = vpkId;
    }

    @Id
    @Column(name = "`BOOLEAN_COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VpkTable)) return false;
        final VpkTable vpkTable = (VpkTable) o;
        return Objects.equals(getVpkId(), vpkTable.getVpkId()) &&
                Objects.equals(getBooleanCol(), vpkTable.getBooleanCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVpkId(),
                getBooleanCol());
    }
}