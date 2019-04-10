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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * TUcOne2oneP generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`T_UC_ONE2ONE_P`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_T_UC_ONE2ONE_P_COLUMN2`", columnNames = {"`STRING COL`"})})
public class TUcOne2oneP implements Serializable {

    private Integer id;
    private String stringCol;
    private Long longCol;
    private Long bigintCol;
    private Boolean booleanCol;
    private TUcOne2oneC tucOne2oneC;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`T_UC_ONE2ONE_P_ID_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`STRING COL`", nullable = false, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
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

    @Column(name = "`BOOLEAN COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`STRING COL`", referencedColumnName = "`STRING ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_T_UC_ONE2ONE_P_TO_T_UEBr10`"))
    @Fetch(FetchMode.JOIN)
    public TUcOne2oneC getTucOne2oneC() {
        return this.tucOne2oneC;
    }

    public void setTucOne2oneC(TUcOne2oneC tucOne2oneC) {
        if(tucOne2oneC != null) {
            this.stringCol = tucOne2oneC.getStringId();
        }

        this.tucOne2oneC = tucOne2oneC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TUcOne2oneP)) return false;
        final TUcOne2oneP tucOne2oneP = (TUcOne2oneP) o;
        return Objects.equals(getId(), tucOne2oneP.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}