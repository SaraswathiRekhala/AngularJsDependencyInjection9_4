/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class TOne2oneComposites1Id implements Serializable {

    private Short shortId;
    private String stringId;
    private Short byteId;
    private String charId;

    public Short getShortId() {
        return this.shortId;
    }

    public void setShortId(Short shortId) {
        this.shortId = shortId;
    }

    public String getStringId() {
        return this.stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
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
        if (!(o instanceof TOne2oneComposites1)) return false;
        final TOne2oneComposites1 tone2oneComposites1 = (TOne2oneComposites1) o;
        return Objects.equals(getShortId(), tone2oneComposites1.getShortId()) &&
                Objects.equals(getStringId(), tone2oneComposites1.getStringId()) &&
                Objects.equals(getByteId(), tone2oneComposites1.getByteId()) &&
                Objects.equals(getCharId(), tone2oneComposites1.getCharId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShortId(),
                getStringId(),
                getByteId(),
                getCharId());
    }
}