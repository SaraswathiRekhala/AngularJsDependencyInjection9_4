/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TCrOne2one2Id implements Serializable {

    private BigDecimal bigdecCol;
    private String stringCol;
    private Integer intId;
    private String charCol;

    public BigDecimal getBigdecCol() {
        return this.bigdecCol;
    }

    public void setBigdecCol(BigDecimal bigdecCol) {
        this.bigdecCol = bigdecCol;
    }

    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    public Integer getIntId() {
        return this.intId;
    }

    public void setIntId(Integer intId) {
        this.intId = intId;
    }

    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TCrOne2one2)) return false;
        final TCrOne2one2 tcrOne2one2 = (TCrOne2one2) o;
        return Objects.equals(getBigdecCol(), tcrOne2one2.getBigdecCol()) &&
                Objects.equals(getStringCol(), tcrOne2one2.getStringCol()) &&
                Objects.equals(getIntId(), tcrOne2one2.getIntId()) &&
                Objects.equals(getCharCol(), tcrOne2one2.getCharCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBigdecCol(),
                getStringCol(),
                getIntId(),
                getCharCol());
    }
}