/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.angularjsdependencyinjection9_4.dbscenarios.VirtualOne2one;
import com.angularjsdependencyinjection9_4.dbscenarios.VirtualOne2oneId;

/**
 * Specifies methods used to obtain and modify VirtualOne2one related information
 * which is stored in the database.
 */
@Repository("dbscenarios.VirtualOne2oneDao")
public class VirtualOne2oneDao extends WMGenericDaoImpl<VirtualOne2one, VirtualOne2oneId> {

    @Autowired
    @Qualifier("dbscenariosTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}