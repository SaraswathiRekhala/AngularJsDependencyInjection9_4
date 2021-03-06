/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.schooldb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class AcademictestsubjectsId implements Serializable {

    private String academicyear;
    private Integer standardid;
    private Integer subjectid;
    private Integer testid;

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

    public Integer getSubjectid() {
        return this.subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getTestid() {
        return this.testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Academictestsubjects)) return false;
        final Academictestsubjects academictestsubjects = (Academictestsubjects) o;
        return Objects.equals(getAcademicyear(), academictestsubjects.getAcademicyear()) &&
                Objects.equals(getStandardid(), academictestsubjects.getStandardid()) &&
                Objects.equals(getSubjectid(), academictestsubjects.getSubjectid()) &&
                Objects.equals(getTestid(), academictestsubjects.getTestid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcademicyear(),
                getStandardid(),
                getSubjectid(),
                getTestid());
    }
}