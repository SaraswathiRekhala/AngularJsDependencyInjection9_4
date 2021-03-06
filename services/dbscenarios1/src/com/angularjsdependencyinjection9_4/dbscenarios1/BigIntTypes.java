/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BigIntTypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`bigIntTypes`")
public class BigIntTypes implements Serializable {

    private Long signedDefault;
    private Long unsignedBigint;

    @Id
    @Column(name = "`signed_default`", nullable = false, scale = 0, precision = 19)
    public Long getSignedDefault() {
        return this.signedDefault;
    }

    public void setSignedDefault(Long signedDefault) {
        this.signedDefault = signedDefault;
    }

    @Column(name = "`unsigned_bigint`", nullable = true, scale = 0, precision = 19)
    public Long getUnsignedBigint() {
        return this.unsignedBigint;
    }

    public void setUnsignedBigint(Long unsignedBigint) {
        this.unsignedBigint = unsignedBigint;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BigIntTypes)) return false;
        final BigIntTypes bigIntTypes = (BigIntTypes) o;
        return Objects.equals(getSignedDefault(), bigIntTypes.getSignedDefault());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSignedDefault());
    }
}