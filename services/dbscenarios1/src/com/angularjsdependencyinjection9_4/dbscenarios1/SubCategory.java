/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * SubCategory generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SUB_CATEGORY`")
public class SubCategory implements Serializable {

    private String subcategory;
    private String category;
    private Category categoryByCategory;

    @Id
    @Column(name = "`SUBCATEGORY`", nullable = false, length = 255)
    public String getSubcategory() {
        return this.subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    @Column(name = "`CATEGORY`", nullable = true, length = 255)
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`CATEGORY`", referencedColumnName = "`CATRGORY`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_SUB_CATEGORY_TO_CATEGbjJma`"))
    @Fetch(FetchMode.JOIN)
    public Category getCategoryByCategory() {
        return this.categoryByCategory;
    }

    public void setCategoryByCategory(Category categoryByCategory) {
        if(categoryByCategory != null) {
            this.category = categoryByCategory.getCatrgory();
        }

        this.categoryByCategory = categoryByCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubCategory)) return false;
        final SubCategory subCategory = (SubCategory) o;
        return Objects.equals(getSubcategory(), subCategory.getSubcategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubcategory());
    }
}