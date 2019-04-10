/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TCompositesMany2oneId implements Serializable {

    private BigDecimal bigdecId;
    private Short shortId;
    private Short byteId;
    private String charId;

    public BigDecimal getBigdecId() {
        return this.bigdecId;
    }

    public void setBigdecId(BigDecimal bigdecId) {
        this.bigdecId = bigdecId;
    }

    public Short getShortId() {
        return this.shortId;
    }

    public void setShortId(Short shortId) {
        this.shortId = shortId;
    }

    public Short getByteId() {
        return this.byteId;
    }

    public void setByteId(Short byteId) {
        this.byteId = byteId;
    }

    public String getCharId() {
        return this.charId;
    }

    public void setCharId(String charId) {
        this.charId = charId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TCompositesMany2one)) return false;
        final TCompositesMany2one tcompositesMany2one = (TCompositesMany2one) o;
        return Objects.equals(getBigdecId(), tcompositesMany2one.getBigdecId()) &&
                Objects.equals(getShortId(), tcompositesMany2one.getShortId()) &&
                Objects.equals(getByteId(), tcompositesMany2one.getByteId()) &&
                Objects.equals(getCharId(), tcompositesMany2one.getCharId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBigdecId(),
                getShortId(),
                getByteId(),
                getCharId());
    }
}