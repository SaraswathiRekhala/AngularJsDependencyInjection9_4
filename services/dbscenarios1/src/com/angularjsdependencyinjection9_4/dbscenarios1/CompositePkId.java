/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CompositePkId implements Serializable {

    private Integer intid;
    private Date dateid;

    public Integer getIntid() {
        return this.intid;
    }

    public void setIntid(Integer intid) {
        this.intid = intid;
    }

    public Date getDateid() {
        return this.dateid;
    }

    public void setDateid(Date dateid) {
        this.dateid = dateid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositePk)) return false;
        final CompositePk compositePk = (CompositePk) o;
        return Objects.equals(getIntid(), compositePk.getIntid()) &&
                Objects.equals(getDateid(), compositePk.getDateid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIntid(),
                getDateid());
    }
}