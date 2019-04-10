/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.angularjsdependencyinjection9_4.dbscenarios1.AutoWireProcedure1000nullTitles;

/**
 * Specifies methods used to obtain and modify AutoWireProcedure1000nullTitles related information
 * which is stored in the database.
 */
@Repository("dbscenarios1.AutoWireProcedure1000nullTitlesDao")
public class AutoWireProcedure1000nullTitlesDao extends WMGenericDaoImpl<AutoWireProcedure1000nullTitles, Integer> {

    @Autowired
    @Qualifier("dbscenarios1Template")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}