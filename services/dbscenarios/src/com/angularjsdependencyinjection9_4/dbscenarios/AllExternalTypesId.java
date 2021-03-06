/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class AllExternalTypesId implements Serializable {

    private Integer serialType;
    private Long bigserialType;
    private Long bigintType;
    private Boolean bitType;
    private Boolean booleanType;
    private byte[] byteaBlobType;
    private String charDoubleQuotes;
    private String characterType;
    private String characterVaryingType;
    private Date dateType;
    private Integer integerType;
    private BigDecimal numericType;
    private Short smallIntType;
    private String textType;
    private LocalDateTime timestampWithoutTimeZone;
    private Timestamp timestampWithTimeZone;
    private Time timeWithoutTimeZone;
    private Time timeWithTimeZone;
    private String uuidType;
    private BigDecimal doublePrecisionCol;

    public Integer getSerialType() {
        return this.serialType;
    }

    public void setSerialType(Integer serialType) {
        this.serialType = serialType;
    }

    public Long getBigserialType() {
        return this.bigserialType;
    }

    public void setBigserialType(Long bigserialType) {
        this.bigserialType = bigserialType;
    }

    public Long getBigintType() {
        return this.bigintType;
    }

    public void setBigintType(Long bigintType) {
        this.bigintType = bigintType;
    }

    public Boolean getBitType() {
        return this.bitType;
    }

    public void setBitType(Boolean bitType) {
        this.bitType = bitType;
    }

    public Boolean getBooleanType() {
        return this.booleanType;
    }

    public void setBooleanType(Boolean booleanType) {
        this.booleanType = booleanType;
    }

    public byte[] getByteaBlobType() {
        return this.byteaBlobType;
    }

    public void setByteaBlobType(byte[] byteaBlobType) {
        this.byteaBlobType = byteaBlobType;
    }

    public String getCharDoubleQuotes() {
        return this.charDoubleQuotes;
    }

    public void setCharDoubleQuotes(String charDoubleQuotes) {
        this.charDoubleQuotes = charDoubleQuotes;
    }

    public String getCharacterType() {
        return this.characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public String getCharacterVaryingType() {
        return this.characterVaryingType;
    }

    public void setCharacterVaryingType(String characterVaryingType) {
        this.characterVaryingType = characterVaryingType;
    }

    public Date getDateType() {
        return this.dateType;
    }

    public void setDateType(Date dateType) {
        this.dateType = dateType;
    }

    public Integer getIntegerType() {
        return this.integerType;
    }

    public void setIntegerType(Integer integerType) {
        this.integerType = integerType;
    }

    public BigDecimal getNumericType() {
        return this.numericType;
    }

    public void setNumericType(BigDecimal numericType) {
        this.numericType = numericType;
    }

    public Short getSmallIntType() {
        return this.smallIntType;
    }

    public void setSmallIntType(Short smallIntType) {
        this.smallIntType = smallIntType;
    }

    public String getTextType() {
        return this.textType;
    }

    public void setTextType(String textType) {
        this.textType = textType;
    }

    public LocalDateTime getTimestampWithoutTimeZone() {
        return this.timestampWithoutTimeZone;
    }

    public void setTimestampWithoutTimeZone(LocalDateTime timestampWithoutTimeZone) {
        this.timestampWithoutTimeZone = timestampWithoutTimeZone;
    }

    public Timestamp getTimestampWithTimeZone() {
        return this.timestampWithTimeZone;
    }

    public void setTimestampWithTimeZone(Timestamp timestampWithTimeZone) {
        this.timestampWithTimeZone = timestampWithTimeZone;
    }

    public Time getTimeWithoutTimeZone() {
        return this.timeWithoutTimeZone;
    }

    public void setTimeWithoutTimeZone(Time timeWithoutTimeZone) {
        this.timeWithoutTimeZone = timeWithoutTimeZone;
    }

    public Time getTimeWithTimeZone() {
        return this.timeWithTimeZone;
    }

    public void setTimeWithTimeZone(Time timeWithTimeZone) {
        this.timeWithTimeZone = timeWithTimeZone;
    }

    public String getUuidType() {
        return this.uuidType;
    }

    public void setUuidType(String uuidType) {
        this.uuidType = uuidType;
    }

    public BigDecimal getDoublePrecisionCol() {
        return this.doublePrecisionCol;
    }

    public void setDoublePrecisionCol(BigDecimal doublePrecisionCol) {
        this.doublePrecisionCol = doublePrecisionCol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllExternalTypes)) return false;
        final AllExternalTypes allExternalTypes = (AllExternalTypes) o;
        return Objects.equals(getSerialType(), allExternalTypes.getSerialType()) &&
                Objects.equals(getBigserialType(), allExternalTypes.getBigserialType()) &&
                Objects.equals(getBigintType(), allExternalTypes.getBigintType()) &&
                Objects.equals(getBitType(), allExternalTypes.getBitType()) &&
                Objects.equals(getBooleanType(), allExternalTypes.getBooleanType()) &&
                Objects.equals(getByteaBlobType(), allExternalTypes.getByteaBlobType()) &&
                Objects.equals(getCharDoubleQuotes(), allExternalTypes.getCharDoubleQuotes()) &&
                Objects.equals(getCharacterType(), allExternalTypes.getCharacterType()) &&
                Objects.equals(getCharacterVaryingType(), allExternalTypes.getCharacterVaryingType()) &&
                Objects.equals(getDateType(), allExternalTypes.getDateType()) &&
                Objects.equals(getIntegerType(), allExternalTypes.getIntegerType()) &&
                Objects.equals(getNumericType(), allExternalTypes.getNumericType()) &&
                Objects.equals(getSmallIntType(), allExternalTypes.getSmallIntType()) &&
                Objects.equals(getTextType(), allExternalTypes.getTextType()) &&
                Objects.equals(getTimestampWithoutTimeZone(), allExternalTypes.getTimestampWithoutTimeZone()) &&
                Objects.equals(getTimestampWithTimeZone(), allExternalTypes.getTimestampWithTimeZone()) &&
                Objects.equals(getTimeWithoutTimeZone(), allExternalTypes.getTimeWithoutTimeZone()) &&
                Objects.equals(getTimeWithTimeZone(), allExternalTypes.getTimeWithTimeZone()) &&
                Objects.equals(getUuidType(), allExternalTypes.getUuidType()) &&
                Objects.equals(getDoublePrecisionCol(), allExternalTypes.getDoublePrecisionCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialType(),
                getBigserialType(),
                getBigintType(),
                getBitType(),
                getBooleanType(),
                getByteaBlobType(),
                getCharDoubleQuotes(),
                getCharacterType(),
                getCharacterVaryingType(),
                getDateType(),
                getIntegerType(),
                getNumericType(),
                getSmallIntType(),
                getTextType(),
                getTimestampWithoutTimeZone(),
                getTimestampWithTimeZone(),
                getTimeWithoutTimeZone(),
                getTimeWithTimeZone(),
                getUuidType(),
                getDoublePrecisionCol());
    }
}