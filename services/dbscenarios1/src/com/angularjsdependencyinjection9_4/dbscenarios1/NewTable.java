/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * NewTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`new_table$`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_new_table$_id`", columnNames = {"`id`"})})
@IdClass(NewTableId.class)
public class NewTable implements Serializable {

    private Integer id;
    private String stringcol_45_;
    private Date datecol1;

    @Id
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "`stringcol(45)`", nullable = true, length = 45)
    public String getStringcol_45_() {
        return this.stringcol_45_;
    }

    public void setStringcol_45_(String stringcol_45_) {
        this.stringcol_45_ = stringcol_45_;
    }

    @Id
    @Column(name = "`datecol1`", nullable = true)
    public Date getDatecol1() {
        return this.datecol1;
    }

    public void setDatecol1(Date datecol1) {
        this.datecol1 = datecol1;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewTable)) return false;
        final NewTable newTable = (NewTable) o;
        return Objects.equals(getId(), newTable.getId()) &&
                Objects.equals(getStringcol_45_(), newTable.getStringcol_45_()) &&
                Objects.equals(getDatecol1(), newTable.getDatecol1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getStringcol_45_(),
                getDatecol1());
    }
}