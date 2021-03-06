/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * TCrOne2one2 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`T_CR_ONE2ONE2`")
@IdClass(TCrOne2one2Id.class)
public class TCrOne2one2 implements Serializable {

    private BigDecimal bigdecCol;
    private String stringCol;
    private Integer intId;
    private String charCol;
    private LocalDateTime datetimeCol;
    private Time timeCol;

    @Id
    @Column(name = "`BIGDEC-COL`", nullable = false, scale = 15, precision = 35)
    public BigDecimal getBigdecCol() {
        return this.bigdecCol;
    }

    public void setBigdecCol(BigDecimal bigdecCol) {
        this.bigdecCol = bigdecCol;
    }

    @Id
    @Column(name = "`STRING-COL`", nullable = false, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Id
    @Column(name = "`INT-ID`", nullable = false, scale = 0, precision = 10)
    public Integer getIntId() {
        return this.intId;
    }

    public void setIntId(Integer intId) {
        this.intId = intId;
    }

    @Id
    @Column(name = "`CHAR-COL`", nullable = false, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TCrOne2one2)) return false;
        final TCrOne2one2 tcrOne2one2 = (TCrOne2one2) o;
        return Objects.equals(getBigdecCol(), tcrOne2one2.getBigdecCol()) &&
                Objects.equals(getStringCol(), tcrOne2one2.getStringCol()) &&
                Objects.equals(getIntId(), tcrOne2one2.getIntId()) &&
                Objects.equals(getCharCol(), tcrOne2one2.getCharCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBigdecCol(),
                getStringCol(),
                getIntId(),
                getCharCol());
    }
}