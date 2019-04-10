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

/**
 * Table10 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE10`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_TABLE10_COLUMN2_COLUMN3`", columnNames = {"`COLUMN2`", "`COLUMN3`"})})
public class Table10 implements Serializable {

    private Integer id;
    private String column2;
    private String column3;
    private Table11 table11;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`COLUMN2`", nullable = true, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3`", nullable = true, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "`COLUMN2`", referencedColumnName = "`ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`COLUMN3`", referencedColumnName = "`COLUMN2`", insertable = false, updatable = false)},
        foreignKey = @ForeignKey(name = "`FK_TABLE10_TO_TABLE11_COrCLnc`"))
    @Fetch(FetchMode.JOIN)
    public Table11 getTable11() {
        return this.table11;
    }

    public void setTable11(Table11 table11) {
        if(table11 != null) {
            this.column2 = table11.getId();
            this.column3 = table11.getColumn2();
        }

        this.table11 = table11;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table10)) return false;
        final Table10 table10 = (Table10) o;
        return Objects.equals(getId(), table10.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}