/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.allscenariosdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * DefaultValues generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`DEFAULT VALUES`")
public class DefaultValues implements Serializable {

    private Integer pkId;
    private Byte byteCol = 11;
    private Short shortCol = 110;
    private Integer intCol = 120;
    private Double floatCol = 110.124D;
    private BigDecimal doubleCol;
    private Long longCol = 12345L;
    private BigInteger bigintCol;
    private BigDecimal bigdecCol;
    private String charCol = "S";
    private String stringCol = "STRING VALUE";
    private String textCol;
    private String clobCol;
    private Date dateCol;
    private Time timeCol;
    private LocalDateTime datetimeCol;
    private Boolean booleanCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobCol;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`PK ID`", nullable = false, scale = 0, precision = 10)
    public Integer getPkId() {
        return this.pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    @Column(name = "`BYTE COL`", nullable = true, scale = 0, precision = 2)
    public Byte getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(Byte byteCol) {
        this.byteCol = byteCol;
    }

    @Column(name = "`SHORT COL`", nullable = true, scale = 0, precision = 5)
    public Short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    @Column(name = "`INT COL`", nullable = true, scale = 0, precision = 10)
    public Integer getIntCol() {
        return this.intCol;
    }

    public void setIntCol(Integer intCol) {
        this.intCol = intCol;
    }

    @Column(name = "`FLOAT COL`", nullable = true, scale = 4, precision = 8)
    public Double getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Double floatCol) {
        this.floatCol = floatCol;
    }

    @Column(name = "`DOUBLE COL`", nullable = true, scale = 8, precision = 18)
    public BigDecimal getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(BigDecimal doubleCol) {
        this.doubleCol = doubleCol;
    }

    @Column(name = "`LONG COL`", nullable = true, scale = 0, precision = 18)
    public Long getLongCol() {
        return this.longCol;
    }

    public void setLongCol(Long longCol) {
        this.longCol = longCol;
    }

    @Column(name = "`BIGINT COL`", nullable = true, scale = 0, precision = 35)
    public BigInteger getBigintCol() {
        return this.bigintCol;
    }

    public void setBigintCol(BigInteger bigintCol) {
        this.bigintCol = bigintCol;
    }

    @Column(name = "`BIGDEC COL`", nullable = true, scale = 15, precision = 35)
    public BigDecimal getBigdecCol() {
        return this.bigdecCol;
    }

    public void setBigdecCol(BigDecimal bigdecCol) {
        this.bigdecCol = bigdecCol;
    }

    @Column(name = "`CHAR COL`", nullable = true, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Column(name = "`STRING COL`", nullable = true, length = 50)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Column(name = "`TEXT COL`", nullable = true, length = 2255)
    public String getTextCol() {
        return this.textCol;
    }

    public void setTextCol(String textCol) {
        this.textCol = textCol;
    }

    @Column(name = "`CLOB COL`", nullable = true, length = 2147483647)
    public String getClobCol() {
        return this.clobCol;
    }

    public void setClobCol(String clobCol) {
        this.clobCol = clobCol;
    }

    @Column(name = "`DATE COL`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Column(name = "`TIME COL`", nullable = true)
    public Time getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Time timeCol) {
        this.timeCol = timeCol;
    }

    @Column(name = "`DATETIME COL`", nullable = true)
    public LocalDateTime getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(LocalDateTime datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    @Column(name = "`BOOLEAN COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
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
        if (!(o instanceof DefaultValues)) return false;
        final DefaultValues defaultValues = (DefaultValues) o;
        return Objects.equals(getPkId(), defaultValues.getPkId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkId());
    }
}