/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.schooldb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class AcademicsId implements Serializable {

    private String academicyear;
    private Integer standardid;

    public String getAcademicyear() {
        return this.academicyear;
    }

    public void setAcademicyear(String academicyear) {
        this.academicyear = academicyear;
    }

    public Integer getStandardid() {
        return this.standardid;
    }

    public void setStandardid(Integer standardid) {
        this.standardid = standardid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Academics)) return false;
        final Academics academics = (Academics) o;
        return Objects.equals(getAcademicyear(), academics.getAcademicyear()) &&
                Objects.equals(getStandardid(), academics.getStandardid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcademicyear(),
                getStandardid());
    }
}