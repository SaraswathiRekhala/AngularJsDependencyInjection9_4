/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * VirtualTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`VIRTUAL_TABLE`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_VIRTUAL_TABLE_STRING_DZEdf`", columnNames = {"`STRING COL`", "`DATE COL`"}),
            @UniqueConstraint(name = "`UK_VIRTUAL_TABLE_CHAR_COL`", columnNames = {"`CHAR COL`"})})
@IdClass(VirtualTableId.class)
public class VirtualTable implements Serializable {

    private String charCol;
    private Date dateCol;
    private BigDecimal doubleCol;
    private BigDecimal bigdecCol;
    private String stringCol;
    private Short shortcol;

    @Id
    @Column(name = "`CHAR COL`", nullable = true, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Id
    @Column(name = "`DATE COL`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Id
    @Column(name = "`DOUBLE COL`", nullable = false, scale = 8, precision = 18)
    public BigDecimal getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(BigDecimal doubleCol) {
        this.doubleCol = doubleCol;
    }

    @Id
    @Column(name = "`BIGDEC COL`", nullable = true, scale = 15, precision = 35)
    public BigDecimal getBigdecCol() {
        return this.bigdecCol;
    }

    public void setBigdecCol(BigDecimal bigdecCol) {
        this.bigdecCol = bigdecCol;
    }

    @Id
    @Column(name = "`STRING COL`", nullable = true, length = 1)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Id
    @Column(name = "`SHORTCOL`", nullable = true, scale = 0, precision = 5)
    public Short getShortcol() {
        return this.shortcol;
    }

    public void setShortcol(Short shortcol) {
        this.shortcol = shortcol;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualTable)) return false;
        final VirtualTable virtualTable = (VirtualTable) o;
        return Objects.equals(getCharCol(), virtualTable.getCharCol()) &&
                Objects.equals(getDateCol(), virtualTable.getDateCol()) &&
                Objects.equals(getDoubleCol(), virtualTable.getDoubleCol()) &&
                Objects.equals(getBigdecCol(), virtualTable.getBigdecCol()) &&
                Objects.equals(getStringCol(), virtualTable.getStringCol()) &&
                Objects.equals(getShortcol(), virtualTable.getShortcol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharCol(),
                getDateCol(),
                getDoubleCol(),
                getBigdecCol(),
                getStringCol(),
                getShortcol());
    }
}