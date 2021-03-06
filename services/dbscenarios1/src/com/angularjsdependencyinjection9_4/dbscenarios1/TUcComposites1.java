/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * TUcComposites1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`T UC COMPOSITES1`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_T_UC_COMPOSITES1_BYTEurb4u`", columnNames = {"`BYTE COL`", "`CHAR COL`", "`SHORT COL`", "`STRING COL`"})})
public class TUcComposites1 implements Serializable {

    private Integer id;
    private Short byteCol;
    private String charCol;
    private Short shortCol;
    private String stringCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] column6;
    private TUcComposites2 tucComposites2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`BYTE COL`", nullable = true, scale = 0, precision = 3)
    public Short getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(Short byteCol) {
        this.byteCol = byteCol;
    }

    @Column(name = "`CHAR COL`", nullable = true, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Column(name = "`SHORT COL`", nullable = true, scale = 0, precision = 5)
    public Short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    @Column(name = "`STRING COL`", nullable = true, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Column(name = "`COLUMN6`", nullable = true)
    public byte[] getColumn6() {
        return this.column6;
    }

    public void setColumn6(byte[] column6) {
        this.column6 = column6;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "`BYTE COL`", referencedColumnName = "`BYTE ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`CHAR COL`", referencedColumnName = "`CHAR COL`", insertable = false, updatable = false),
            @JoinColumn(name = "`SHORT COL`", referencedColumnName = "`SHORT COL`", insertable = false, updatable = false),
            @JoinColumn(name = "`STRING COL`", referencedColumnName = "`STRING COL`", insertable = false, updatable = false)},
        foreignKey = @ForeignKey(name = "`FK_T_UC_COMPOSITES1_TO_TWuwTo`"))
    @Fetch(FetchMode.JOIN)
    public TUcComposites2 getTucComposites2() {
        return this.tucComposites2;
    }

    public void setTucComposites2(TUcComposites2 tucComposites2) {
        if(tucComposites2 != null) {
            this.byteCol = tucComposites2.getByteId();
            this.charCol = tucComposites2.getCharCol();
            this.shortCol = tucComposites2.getShortCol();
            this.stringCol = tucComposites2.getStringCol();
        }

        this.tucComposites2 = tucComposites2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TUcComposites1)) return false;
        final TUcComposites1 tucComposites1 = (TUcComposites1) o;
        return Objects.equals(getId(), tucComposites1.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}