/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * ViewAlltypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`VIEW_ALLTYPES`")
@IdClass(ViewAlltypesId.class)
public class ViewAlltypes implements Serializable {

    private Integer pkId = 0;
    private Short byteCol;
    private Short shortCol;
    private Integer intCol;
    private Long longCol;
    private Double floatCol;
    private BigDecimal doubleCol;
    private BigDecimal bigdecCol;
    private Long bigintCol;
    private String charCol;
    private String stringCol;
    private String textCol;
    private String clobCol;
    private Date dateCol;
    private Time timeCol;
    private LocalDateTime datetimeCol;
    private Timestamp timestampCol;
    private Boolean booleanCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobCol;

    @Id
    @Column(name = "`PK ID`", nullable = false, scale = 0, precision = 10)
    public Integer getPkId() {
        return this.pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    @Id
    @Column(name = "`BYTE COL`", nullable = true, scale = 0, precision = 5)
    public Short getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(Short byteCol) {
        this.byteCol = byteCol;
    }

    @Id
    @Column(name = "`SHORT COL`", nullable = true, scale = 0, precision = 5)
    public Short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    @Id
    @Column(name = "`INT COL`", nullable = true, scale = 0, precision = 10)
    public Integer getIntCol() {
        return this.intCol;
    }

    public void setIntCol(Integer intCol) {
        this.intCol = intCol;
    }

    @Id
    @Column(name = "`LONG COL`", nullable = true, scale = 0, precision = 19)
    public Long getLongCol() {
        return this.longCol;
    }

    public void setLongCol(Long longCol) {
        this.longCol = longCol;
    }

    @Id
    @Column(name = "`FLOAT COL`", nullable = true, scale = 4, precision = 8)
    public Double getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Double floatCol) {
        this.floatCol = floatCol;
    }

    @Id
    @Column(name = "`DOUBLE COL`", nullable = true, scale = 8, precision = 18)
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
    @Column(name = "`BIGINT COL`", nullable = true, scale = 0, precision = 19)
    public Long getBigintCol() {
        return this.bigintCol;
    }

    public void setBigintCol(Long bigintCol) {
        this.bigintCol = bigintCol;
    }

    @Id
    @Column(name = "`CHAR COL`", nullable = true, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Id
    @Column(name = "`STRING COL`", nullable = true, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Id
    @Column(name = "`TEXT COL`", nullable = true, length = 2147483647)
    public String getTextCol() {
        return this.textCol;
    }

    public void setTextCol(String textCol) {
        this.textCol = textCol;
    }

    @Id
    @Column(name = "`CLOB COL`", nullable = true, length = 2147483647)
    public String getClobCol() {
        return this.clobCol;
    }

    public void setClobCol(String clobCol) {
        this.clobCol = clobCol;
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
    @Column(name = "`TIME COL`", nullable = true)
    public Time getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Time timeCol) {
        this.timeCol = timeCol;
    }

    @Id
    @Column(name = "`DATETIME COL`", nullable = true)
    public LocalDateTime getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(LocalDateTime datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    @Id
    @Column(name = "`TIMESTAMP COL`", nullable = false)
    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @Id
    @Column(name = "`BOOLEAN COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Id
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
        if (!(o instanceof ViewAlltypes)) return false;
        final ViewAlltypes viewAlltypes = (ViewAlltypes) o;
        return Objects.equals(getPkId(), viewAlltypes.getPkId()) &&
                Objects.equals(getByteCol(), viewAlltypes.getByteCol()) &&
                Objects.equals(getShortCol(), viewAlltypes.getShortCol()) &&
                Objects.equals(getIntCol(), viewAlltypes.getIntCol()) &&
                Objects.equals(getLongCol(), viewAlltypes.getLongCol()) &&
                Objects.equals(getFloatCol(), viewAlltypes.getFloatCol()) &&
                Objects.equals(getDoubleCol(), viewAlltypes.getDoubleCol()) &&
                Objects.equals(getBigdecCol(), viewAlltypes.getBigdecCol()) &&
                Objects.equals(getBigintCol(), viewAlltypes.getBigintCol()) &&
                Objects.equals(getCharCol(), viewAlltypes.getCharCol()) &&
                Objects.equals(getStringCol(), viewAlltypes.getStringCol()) &&
                Objects.equals(getTextCol(), viewAlltypes.getTextCol()) &&
                Objects.equals(getClobCol(), viewAlltypes.getClobCol()) &&
                Objects.equals(getDateCol(), viewAlltypes.getDateCol()) &&
                Objects.equals(getTimeCol(), viewAlltypes.getTimeCol()) &&
                Objects.equals(getDatetimeCol(), viewAlltypes.getDatetimeCol()) &&
                Objects.equals(getTimestampCol(), viewAlltypes.getTimestampCol()) &&
                Objects.equals(getBooleanCol(), viewAlltypes.getBooleanCol()) &&
                Objects.equals(getBlobCol(), viewAlltypes.getBlobCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkId(),
                getByteCol(),
                getShortCol(),
                getIntCol(),
                getLongCol(),
                getFloatCol(),
                getDoubleCol(),
                getBigdecCol(),
                getBigintCol(),
                getCharCol(),
                getStringCol(),
                getTextCol(),
                getClobCol(),
                getDateCol(),
                getTimeCol(),
                getDatetimeCol(),
                getTimestampCol(),
                getBooleanCol(),
                getBlobCol());
    }
}