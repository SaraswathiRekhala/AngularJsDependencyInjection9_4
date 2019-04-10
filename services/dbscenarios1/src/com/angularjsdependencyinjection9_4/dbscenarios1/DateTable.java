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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DateTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`DATE_TABLE`")
public class DateTable implements Serializable {

    private Integer id;
    private Date datecol1;
    private Date datecol2;
    private Date datecol3;
    private Date datecol4;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`DATECOL1`", nullable = true)
    public Date getDatecol1() {
        return this.datecol1;
    }

    public void setDatecol1(Date datecol1) {
        this.datecol1 = datecol1;
    }

    @Column(name = "`DATECOL2`", nullable = true)
    public Date getDatecol2() {
        return this.datecol2;
    }

    public void setDatecol2(Date datecol2) {
        this.datecol2 = datecol2;
    }

    @Column(name = "`DATECOL3`", nullable = true)
    public Date getDatecol3() {
        return this.datecol3;
    }

    public void setDatecol3(Date datecol3) {
        this.datecol3 = datecol3;
    }

    @Column(name = "`DATECOL4`", nullable = true)
    public Date getDatecol4() {
        return this.datecol4;
    }

    public void setDatecol4(Date datecol4) {
        this.datecol4 = datecol4;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateTable)) return false;
        final DateTable dateTable = (DateTable) o;
        return Objects.equals(getId(), dateTable.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}