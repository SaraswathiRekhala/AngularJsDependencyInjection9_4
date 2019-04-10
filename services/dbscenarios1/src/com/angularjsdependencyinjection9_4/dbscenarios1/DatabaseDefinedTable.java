/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DatabaseDefinedTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`DatabaseDefinedTable`")
public class DatabaseDefinedTable implements Serializable {

    private Integer integerCol;
    private Timestamp timestampcoldbdefined;
    private String column2;

    @Id
    @Column(name = "`integer col`", nullable = false, scale = 0, precision = 10)
    public Integer getIntegerCol() {
        return this.integerCol;
    }

    public void setIntegerCol(Integer integerCol) {
        this.integerCol = integerCol;
    }

    @Column(name = "`timestampcoldbdefined`", nullable = false)
    public Timestamp getTimestampcoldbdefined() {
        return this.timestampcoldbdefined;
    }

    public void setTimestampcoldbdefined(Timestamp timestampcoldbdefined) {
        this.timestampcoldbdefined = timestampcoldbdefined;
    }

    @Column(name = "`COLUMN2`", nullable = true, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatabaseDefinedTable)) return false;
        final DatabaseDefinedTable databaseDefinedTable = (DatabaseDefinedTable) o;
        return Objects.equals(getIntegerCol(), databaseDefinedTable.getIntegerCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIntegerCol());
    }
}