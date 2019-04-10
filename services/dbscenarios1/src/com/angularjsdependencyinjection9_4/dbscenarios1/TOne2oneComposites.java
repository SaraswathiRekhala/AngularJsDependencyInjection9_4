/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * TOne2oneComposites generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`T_ONE2ONE_COMPOSITES`")
@IdClass(TOne2oneComposites1Id.class)
public class TOne2oneComposites implements Serializable {

    private Short shortId;
    private String stringId;
    private Short byteId;
    private String charId;
    private LocalDateTime datetimeCol;
    private TOne2oneComposites1 tone2oneComposites1;

    @Id
    @Column(name = "`SHORT ID`", nullable = false, scale = 0, precision = 5)
    public Short getShortId() {
        return this.shortId;
    }

    public void setShortId(Short shortId) {
        this.shortId = shortId;
    }

    @Id
    @Column(name = "`STRING ID`", nullable = false, length = 255)
    public String getStringId() {
        return this.stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    @Id
    @Column(name = "`BYTE ID`", nullable = false, scale = 0, precision = 3)
    public Short getByteId() {
        return this.byteId;
    }

    public void setByteId(Short byteId) {
        this.byteId = byteId;
    }

    @Id
    @Column(name = "`CHAR ID`", nullable = false, length = 1)
    public String getCharId() {
        return this.charId;
    }

    public void setCharId(String charId) {
        this.charId = charId;
    }

    @Column(name = "`DATETIME COL`", nullable = true)
    public LocalDateTime getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(LocalDateTime datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "`BYTE ID`", referencedColumnName = "`BYTE ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`SHORT ID`", referencedColumnName = "`SHORT ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`CHAR ID`", referencedColumnName = "`CHAR ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`STRING ID`", referencedColumnName = "`STRING ID`", insertable = false, updatable = false)},
        foreignKey = @ForeignKey(name = "`FK_T_ONE2ONE_COMPOSITES_36kkV`"))
    @Fetch(FetchMode.JOIN)
    public TOne2oneComposites1 getTone2oneComposites1() {
        return this.tone2oneComposites1;
    }

    public void setTone2oneComposites1(TOne2oneComposites1 tone2oneComposites1) {
        if(tone2oneComposites1 != null) {
            this.byteId = tone2oneComposites1.getByteId();
            this.shortId = tone2oneComposites1.getShortId();
            this.charId = tone2oneComposites1.getCharId();
            this.stringId = tone2oneComposites1.getStringId();
        }

        this.tone2oneComposites1 = tone2oneComposites1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TOne2oneComposites)) return false;
        final TOne2oneComposites tone2oneComposites = (TOne2oneComposites) o;
        return Objects.equals(getShortId(), tone2oneComposites.getShortId()) &&
                Objects.equals(getStringId(), tone2oneComposites.getStringId()) &&
                Objects.equals(getByteId(), tone2oneComposites.getByteId()) &&
                Objects.equals(getCharId(), tone2oneComposites.getCharId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShortId(),
                getStringId(),
                getByteId(),
                getCharId());
    }
}