/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

/**
 * Uniquegrouping generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`UNIQUEGROUPING`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_UNIQUEGROUPING_DATECOzvYyZ`", columnNames = {"`DATECOL`", "`CHARCOL`"}),
            @UniqueConstraint(name = "`UK_UNIQUEGROUPING_STRINGCOL`", columnNames = {"`STRINGCOL`"}),
            @UniqueConstraint(name = "`UK_UNIQUEGROUPING_DATECO6lngI`", columnNames = {"`DATECOL`", "`CHARCOL`", "`DATETIMECOL`"})})
public class Uniquegrouping implements Serializable {

    private Integer id;
    private Date datecol;
    private Time timecol;
    private LocalDateTime datetimecol;
    private Timestamp timestampcol;
    private String charcol;
    private String stringcol;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`DATECOL`", nullable = true)
    public Date getDatecol() {
        return this.datecol;
    }

    public void setDatecol(Date datecol) {
        this.datecol = datecol;
    }

    @Column(name = "`TIMECOL`", nullable = true)
    public Time getTimecol() {
        return this.timecol;
    }

    public void setTimecol(Time timecol) {
        this.timecol = timecol;
    }

    @Column(name = "`DATETIMECOL`", nullable = true)
    public LocalDateTime getDatetimecol() {
        return this.datetimecol;
    }

    public void setDatetimecol(LocalDateTime datetimecol) {
        this.datetimecol = datetimecol;
    }

    @Column(name = "`TIMESTAMPCOL`", nullable = false)
    public Timestamp getTimestampcol() {
        return this.timestampcol;
    }

    public void setTimestampcol(Timestamp timestampcol) {
        this.timestampcol = timestampcol;
    }

    @Column(name = "`CHARCOL`", nullable = true, length = 1)
    public String getCharcol() {
        return this.charcol;
    }

    public void setCharcol(String charcol) {
        this.charcol = charcol;
    }

    @Column(name = "`STRINGCOL`", nullable = true, length = 255)
    public String getStringcol() {
        return this.stringcol;
    }

    public void setStringcol(String stringcol) {
        this.stringcol = stringcol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uniquegrouping)) return false;
        final Uniquegrouping uniquegrouping = (Uniquegrouping) o;
        return Objects.equals(getId(), uniquegrouping.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}