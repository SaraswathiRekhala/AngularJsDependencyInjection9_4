/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class TUcComposite2Id implements Serializable {

    private Long bigintCol;
    private Long longId;
    private String charCol;

    public Long getBigintCol() {
        return this.bigintCol;
    }

    public void setBigintCol(Long bigintCol) {
        this.bigintCol = bigintCol;
    }

    public Long getLongId() {
        return this.longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
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
        if (!(o instanceof TUcComposite2)) return false;
        final TUcComposite2 tucComposite2 = (TUcComposite2) o;
        return Objects.equals(getBigintCol(), tucComposite2.getBigintCol()) &&
                Objects.equals(getLongId(), tucComposite2.getLongId()) &&
                Objects.equals(getCharCol(), tucComposite2.getCharCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBigintCol(),
                getLongId(),
                getCharCol());
    }
}