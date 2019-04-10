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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * AllExternalTypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ALL EXTERNAL TYPES`")
public class AllExternalTypes implements Serializable {

    private Integer intCol;
    private short tinyIntCol;
    private short smallIntCol;
    private int mediumIntCol;
    private long bigintCol;
    private int decimalCol;
    private double floatCol;
    private BigDecimal doubleCol;
    private boolean bitCol;
    private boolean booleanCol;
    private long serialCol;
    private Date dateCol;
    private LocalDateTime datetimeCol;
    private Timestamp timestampCol;
    private Time timeCol;
    private String charCol;
    private String varcharCol;
    private String tinytextCol;
    private String textCol;
    private String mediumTextCol;
    private String longtextCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] longblobCol;
    private String column24;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`INT COL`", nullable = false, scale = 0, precision = 10)
    public Integer getIntCol() {
        return this.intCol;
    }

    public void setIntCol(Integer intCol) {
        this.intCol = intCol;
    }

    @Column(name = "`TINY INT COL`", nullable = false, scale = 0, precision = 5)
    public short getTinyIntCol() {
        return this.tinyIntCol;
    }

    public void setTinyIntCol(short tinyIntCol) {
        this.tinyIntCol = tinyIntCol;
    }

    @Column(name = "`SMALL INT COL`", nullable = false, scale = 0, precision = 5)
    public short getSmallIntCol() {
        return this.smallIntCol;
    }

    public void setSmallIntCol(short smallIntCol) {
        this.smallIntCol = smallIntCol;
    }

    @Column(name = "`MEDIUM INT COL`", nullable = false, scale = 0, precision = 10)
    public int getMediumIntCol() {
        return this.mediumIntCol;
    }

    public void setMediumIntCol(int mediumIntCol) {
        this.mediumIntCol = mediumIntCol;
    }

    @Column(name = "`BIGINT COL`", nullable = false, scale = 0, precision = 19)
    public long getBigintCol() {
        return this.bigintCol;
    }

    public void setBigintCol(long bigintCol) {
        this.bigintCol = bigintCol;
    }

    @Column(name = "`DECIMAL COL`", nullable = false, scale = 0, precision = 10)
    public int getDecimalCol() {
        return this.decimalCol;
    }

    public void setDecimalCol(int decimalCol) {
        this.decimalCol = decimalCol;
    }

    @Column(name = "`FLOAT COL`", nullable = false, scale = 4, precision = 12)
    public double getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(double floatCol) {
        this.floatCol = floatCol;
    }

    @Column(name = "`DOUBLE COL`", nullable = false, scale = 9, precision = 22)
    public BigDecimal getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(BigDecimal doubleCol) {
        this.doubleCol = doubleCol;
    }

    @Column(name = "`BIT COL`", nullable = false)
    public boolean isBitCol() {
        return this.bitCol;
    }

    public void setBitCol(boolean bitCol) {
        this.bitCol = bitCol;
    }

    @Column(name = "`BOOLEAN COL`", nullable = false)
    public boolean isBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`SERIAL COL`", nullable = false, scale = 0, precision = 19)
    public long getSerialCol() {
        return this.serialCol;
    }

    public void setSerialCol(long serialCol) {
        this.serialCol = serialCol;
    }

    @Column(name = "`DATE COL`", nullable = false)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Column(name = "`DATETIME COL`", nullable = false)
    public LocalDateTime getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(LocalDateTime datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    @Column(name = "`TIMESTAMP COL`", nullable = false)
    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @Column(name = "`TIME COL`", nullable = false)
    public Time getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Time timeCol) {
        this.timeCol = timeCol;
    }

    @Column(name = "`CHAR COL`", nullable = false, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Column(name = "`VARCHAR COL`", nullable = true, length = 255)
    public String getVarcharCol() {
        return this.varcharCol;
    }

    public void setVarcharCol(String varcharCol) {
        this.varcharCol = varcharCol;
    }

    @Column(name = "`TINYTEXT COL`", nullable = true, length = 255)
    public String getTinytextCol() {
        return this.tinytextCol;
    }

    public void setTinytextCol(String tinytextCol) {
        this.tinytextCol = tinytextCol;
    }

    @Column(name = "`TEXT COL`", nullable = false, length = 2147483647)
    public String getTextCol() {
        return this.textCol;
    }

    public void setTextCol(String textCol) {
        this.textCol = textCol;
    }

    @Column(name = "`MEDIUM TEXT COL`", nullable = false, length = 2147483647)
    public String getMediumTextCol() {
        return this.mediumTextCol;
    }

    public void setMediumTextCol(String mediumTextCol) {
        this.mediumTextCol = mediumTextCol;
    }

    @Column(name = "`LONGTEXT COL`", nullable = false, length = 2147483647)
    public String getLongtextCol() {
        return this.longtextCol;
    }

    public void setLongtextCol(String longtextCol) {
        this.longtextCol = longtextCol;
    }

    @Column(name = "`BLOB COL`", nullable = true)
    public byte[] getBlobCol() {
        return this.blobCol;
    }

    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }

    @Column(name = "`LONGBLOB COL`", nullable = true)
    public byte[] getLongblobCol() {
        return this.longblobCol;
    }

    public void setLongblobCol(byte[] longblobCol) {
        this.longblobCol = longblobCol;
    }

    @Column(name = "`COLUMN24`", nullable = true, length = 255)
    public String getColumn24() {
        return this.column24;
    }

    public void setColumn24(String column24) {
        this.column24 = column24;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllExternalTypes)) return false;
        final AllExternalTypes allExternalTypes = (AllExternalTypes) o;
        return Objects.equals(getIntCol(), allExternalTypes.getIntCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIntCol());
    }
}