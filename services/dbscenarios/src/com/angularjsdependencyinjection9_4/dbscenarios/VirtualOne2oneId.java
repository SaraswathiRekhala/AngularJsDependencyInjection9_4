/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class VirtualOne2oneId implements Serializable {

    private Integer virtualPk;
    private Long bigserialColumn;
    private Long bigintColumn;
    private byte[] byteaColumn;
    private String characterVaryingColumn;
    private Date dateColumn;
    private String charColumnDoublequotesChar;
    private Short smallintColumn;
    private byte[] name1Column;
    private String textColumn;

    public Integer getVirtualPk() {
        return this.virtualPk;
    }

    public void setVirtualPk(Integer virtualPk) {
        this.virtualPk = virtualPk;
    }

    public Long getBigserialColumn() {
        return this.bigserialColumn;
    }

    public void setBigserialColumn(Long bigserialColumn) {
        this.bigserialColumn = bigserialColumn;
    }

    public Long getBigintColumn() {
        return this.bigintColumn;
    }

    public void setBigintColumn(Long bigintColumn) {
        this.bigintColumn = bigintColumn;
    }

    public byte[] getByteaColumn() {
        return this.byteaColumn;
    }

    public void setByteaColumn(byte[] byteaColumn) {
        this.byteaColumn = byteaColumn;
    }

    public String getCharacterVaryingColumn() {
        return this.characterVaryingColumn;
    }

    public void setCharacterVaryingColumn(String characterVaryingColumn) {
        this.characterVaryingColumn = characterVaryingColumn;
    }

    public Date getDateColumn() {
        return this.dateColumn;
    }

    public void setDateColumn(Date dateColumn) {
        this.dateColumn = dateColumn;
    }

    public String getCharColumnDoublequotesChar() {
        return this.charColumnDoublequotesChar;
    }

    public void setCharColumnDoublequotesChar(String charColumnDoublequotesChar) {
        this.charColumnDoublequotesChar = charColumnDoublequotesChar;
    }

    public Short getSmallintColumn() {
        return this.smallintColumn;
    }

    public void setSmallintColumn(Short smallintColumn) {
        this.smallintColumn = smallintColumn;
    }

    public byte[] getName1Column() {
        return this.name1Column;
    }

    public void setName1Column(byte[] name1Column) {
        this.name1Column = name1Column;
    }

    public String getTextColumn() {
        return this.textColumn;
    }

    public void setTextColumn(String textColumn) {
        this.textColumn = textColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualOne2one)) return false;
        final VirtualOne2one virtualOne2one = (VirtualOne2one) o;
        return Objects.equals(getVirtualPk(), virtualOne2one.getVirtualPk()) &&
                Objects.equals(getBigserialColumn(), virtualOne2one.getBigserialColumn()) &&
                Objects.equals(getBigintColumn(), virtualOne2one.getBigintColumn()) &&
                Objects.equals(getByteaColumn(), virtualOne2one.getByteaColumn()) &&
                Objects.equals(getCharacterVaryingColumn(), virtualOne2one.getCharacterVaryingColumn()) &&
                Objects.equals(getDateColumn(), virtualOne2one.getDateColumn()) &&
                Objects.equals(getCharColumnDoublequotesChar(), virtualOne2one.getCharColumnDoublequotesChar()) &&
                Objects.equals(getSmallintColumn(), virtualOne2one.getSmallintColumn()) &&
                Objects.equals(getName1Column(), virtualOne2one.getName1Column()) &&
                Objects.equals(getTextColumn(), virtualOne2one.getTextColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVirtualPk(),
                getBigserialColumn(),
                getBigintColumn(),
                getByteaColumn(),
                getCharacterVaryingColumn(),
                getDateColumn(),
                getCharColumnDoublequotesChar(),
                getSmallintColumn(),
                getName1Column(),
                getTextColumn());
    }
}