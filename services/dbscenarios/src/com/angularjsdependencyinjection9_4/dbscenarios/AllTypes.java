/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios;

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * AllTypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ALL TYPES`")
public class AllTypes implements Serializable {

    private Integer pkId;
    private Short byteCol;
    private Short shortCol;
    private Double floatCol;
    private Integer intCol;
    private Long longCol;
    private Long bigintCol;
    private BigDecimal doubleCol;
    private BigDecimal bigdecCol;
    private String charCol;
    private String stringCol;
    private String textCol;
    private String clobCol;
    private Date dateCol;
    private LocalDateTime datetimeCol;
    private Time timeCol;
    private Timestamp timestampCol;
    private Boolean booleanCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] column19;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`ALL TYPES_PK-ID_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`PK-ID`", nullable = false, scale = 0, precision = 10)
    public Integer getPkId() {
        return this.pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    @Column(name = "`BYTE COL`", nullable = true, scale = 0, precision = 5)
    public Short getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(Short byteCol) {
        this.byteCol = byteCol;
    }

    @Column(name = "`SHORT COL`", nullable = true, scale = 0, precision = 5)
    public Short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    @Column(name = "`FLOAT COL`", nullable = true, scale = 4, precision = 8)
    public Double getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Double floatCol) {
        this.floatCol = floatCol;
    }

    @Column(name = "`INT COL`", nullable = true, scale = 0, precision = 10)
    public Integer getIntCol() {
        return this.intCol;
    }

    public void setIntCol(Integer intCol) {
        this.intCol = intCol;
    }

    @Column(name = "`LONG COL`", nullable = true, scale = 0, precision = 19)
    public Long getLongCol() {
        return this.longCol;
    }

    public void setLongCol(Long longCol) {
        this.longCol = longCol;
    }

    @Column(name = "`BIGINT COL`", nullable = true, scale = 0, precision = 19)
    public Long getBigintCol() {
        return this.bigintCol;
    }

    public void setBigintCol(Long bigintCol) {
        this.bigintCol = bigintCol;
    }

    @Column(name = "`DOUBLE COL`", nullable = true, scale = 8, precision = 18)
    public BigDecimal getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(BigDecimal doubleCol) {
        this.doubleCol = doubleCol;
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

    @Column(name = "`STRING COL`", nullable = true, length = 255)
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

    @Column(name = "`CLOB COL`", nullable = true, length = 222555)
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

    @Column(name = "`DATETIME COL`", nullable = true)
    public LocalDateTime getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(LocalDateTime datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    @Column(name = "`TIME COL`", nullable = true)
    public Time getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Time timeCol) {
        this.timeCol = timeCol;
    }

    @Column(name = "`TIMESTAMP COL`", nullable = true)
    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @Column(name = "`BOOLEAN COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`COLUMN19`", nullable = true)
    public byte[] getColumn19() {
        return this.column19;
    }

    public void setColumn19(byte[] column19) {
        this.column19 = column19;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllTypes)) return false;
        final AllTypes allTypes = (AllTypes) o;
        return Objects.equals(getPkId(), allTypes.getPkId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkId());
    }
}