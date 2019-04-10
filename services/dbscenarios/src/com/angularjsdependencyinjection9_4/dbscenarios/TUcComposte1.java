/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * TUcComposte1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`T_UC_COMPOSTE1`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_T_UC_COMPOSTE1_COLUMN6VCFT`", columnNames = {"`BYTE COL`", "`STRING COL`"}),
            @UniqueConstraint(name = "`UK_T_UC_COMPOSTE1_COLUMNcVFco`", columnNames = {"`LONG COL`", "`BIGINT COL`", "`CHAR COL`"})})
public class TUcComposte1 implements Serializable {

    private Integer shortId;
    private Long longCol;
    private Long bigintCol;
    private String charCol;
    private String stringCol;
    private Short byteCol;
    private TUcComposite3 tucComposite3;
    private TUcComposite2 tucComposite2;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`T_UC_COMPOSTE1_SHORT ID_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`SHORT ID`", nullable = false, scale = 0, precision = 10)
    public Integer getShortId() {
        return this.shortId;
    }

    public void setShortId(Integer shortId) {
        this.shortId = shortId;
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

    @Column(name = "`BYTE COL`", nullable = true, scale = 0, precision = 5)
    public Short getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(Short byteCol) {
        this.byteCol = byteCol;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "`BYTE COL`", referencedColumnName = "`BYTE ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`STRING COL`", referencedColumnName = "`STRING COL`", insertable = false, updatable = false)},
        foreignKey = @ForeignKey(name = "`FK_T_UC_COMPOSTE1_TO_TABiOVeM`"))
    @Fetch(FetchMode.JOIN)
    public TUcComposite3 getTucComposite3() {
        return this.tucComposite3;
    }

    public void setTucComposite3(TUcComposite3 tucComposite3) {
        if(tucComposite3 != null) {
            this.byteCol = tucComposite3.getByteId();
            this.stringCol = tucComposite3.getStringCol();
        }

        this.tucComposite3 = tucComposite3;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "`LONG COL`", referencedColumnName = "`LONG ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`BIGINT COL`", referencedColumnName = "`BIGINT COL`", insertable = false, updatable = false),
            @JoinColumn(name = "`CHAR COL`", referencedColumnName = "`CHAR COL`", insertable = false, updatable = false)},
        foreignKey = @ForeignKey(name = "`FK_T_UC_COMPOSTE1_TO_T_UXuRlP`"))
    @Fetch(FetchMode.JOIN)
    public TUcComposite2 getTucComposite2() {
        return this.tucComposite2;
    }

    public void setTucComposite2(TUcComposite2 tucComposite2) {
        if(tucComposite2 != null) {
            this.longCol = tucComposite2.getLongId();
            this.bigintCol = tucComposite2.getBigintCol();
            this.charCol = tucComposite2.getCharCol();
        }

        this.tucComposite2 = tucComposite2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TUcComposte1)) return false;
        final TUcComposte1 tucComposte1 = (TUcComposte1) o;
        return Objects.equals(getShortId(), tucComposte1.getShortId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShortId());
    }
}