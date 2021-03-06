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
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * PersonBackup1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PersonBackup1`")
@IdClass(PersonBackup1Id.class)
public class PersonBackup1 implements Serializable {

    private Integer pid;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] column6;
    private String column7;
    private Boolean column8;
    private String column9;

    @Id
    @Column(name = "`P_Id`", nullable = false, scale = 0, precision = 10)
    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Id
    @Column(name = "`LastName`", nullable = false, length = 255)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    @Column(name = "`FirstName`", nullable = true, length = 255)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Id
    @Column(name = "`Address`", nullable = true, length = 255)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @Column(name = "`City`", nullable = true, length = 255)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Id
    @Column(name = "`COLUMN6`", nullable = true)
    public byte[] getColumn6() {
        return this.column6;
    }

    public void setColumn6(byte[] column6) {
        this.column6 = column6;
    }

    @Id
    @Column(name = "`COLUMN7`", nullable = true, length = 255)
    public String getColumn7() {
        return this.column7;
    }

    public void setColumn7(String column7) {
        this.column7 = column7;
    }

    @Id
    @Column(name = "`COLUMN8`", nullable = true)
    public Boolean getColumn8() {
        return this.column8;
    }

    public void setColumn8(Boolean column8) {
        this.column8 = column8;
    }

    @Id
    @Column(name = "`COLUMN9`", nullable = true, length = 255)
    public String getColumn9() {
        return this.column9;
    }

    public void setColumn9(String column9) {
        this.column9 = column9;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonBackup1)) return false;
        final PersonBackup1 personBackup1 = (PersonBackup1) o;
        return Objects.equals(getPid(), personBackup1.getPid()) &&
                Objects.equals(getLastName(), personBackup1.getLastName()) &&
                Objects.equals(getFirstName(), personBackup1.getFirstName()) &&
                Objects.equals(getAddress(), personBackup1.getAddress()) &&
                Objects.equals(getCity(), personBackup1.getCity()) &&
                Objects.equals(getColumn6(), personBackup1.getColumn6()) &&
                Objects.equals(getColumn7(), personBackup1.getColumn7()) &&
                Objects.equals(getColumn8(), personBackup1.getColumn8()) &&
                Objects.equals(getColumn9(), personBackup1.getColumn9());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPid(),
                getLastName(),
                getFirstName(),
                getAddress(),
                getCity(),
                getColumn6(),
                getColumn7(),
                getColumn8(),
                getColumn9());
    }
}