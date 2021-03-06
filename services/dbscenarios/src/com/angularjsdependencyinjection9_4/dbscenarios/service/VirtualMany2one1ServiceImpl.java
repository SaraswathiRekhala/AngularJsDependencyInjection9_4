/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.angularjsdependencyinjection9_4.dbscenarios.VirtualMany2one1;
import com.angularjsdependencyinjection9_4.dbscenarios.VirtualMany2one1Id;


/**
 * ServiceImpl object for domain model class VirtualMany2one1.
 *
 * @see VirtualMany2one1
 */
@Service("dbscenarios.VirtualMany2one1Service")
@Validated
public class VirtualMany2one1ServiceImpl implements VirtualMany2one1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(VirtualMany2one1ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.VirtualMany2one1Dao")
    private WMGenericDao<VirtualMany2one1, VirtualMany2one1Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VirtualMany2one1, VirtualMany2one1Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public VirtualMany2one1 create(VirtualMany2one1 virtualMany2one1) {
        LOGGER.debug("Creating a new VirtualMany2one1 with information: {}", virtualMany2one1);

        VirtualMany2one1 virtualMany2one1Created = this.wmGenericDao.create(virtualMany2one1);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(virtualMany2one1Created);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public VirtualMany2one1 getById(VirtualMany2one1Id virtualmany2one1Id) {
        LOGGER.debug("Finding VirtualMany2one1 by id: {}", virtualmany2one1Id);
        return this.wmGenericDao.findById(virtualmany2one1Id);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public VirtualMany2one1 findById(VirtualMany2one1Id virtualmany2one1Id) {
        LOGGER.debug("Finding VirtualMany2one1 by id: {}", virtualmany2one1Id);
        try {
            return this.wmGenericDao.findById(virtualmany2one1Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No VirtualMany2one1 found with id: {}", virtualmany2one1Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public List<VirtualMany2one1> findByMultipleIds(List<VirtualMany2one1Id> virtualmany2one1Ids, boolean orderedReturn) {
        LOGGER.debug("Finding VirtualMany2one1s by ids: {}", virtualmany2one1Ids);

        return this.wmGenericDao.findByMultipleIds(virtualmany2one1Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
    @Override
    public VirtualMany2one1 update(VirtualMany2one1 virtualMany2one1) {
        LOGGER.debug("Updating VirtualMany2one1 with information: {}", virtualMany2one1);

        this.wmGenericDao.update(virtualMany2one1);
        this.wmGenericDao.refresh(virtualMany2one1);

        return virtualMany2one1;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public VirtualMany2one1 delete(VirtualMany2one1Id virtualmany2one1Id) {
        LOGGER.debug("Deleting VirtualMany2one1 with id: {}", virtualmany2one1Id);
        VirtualMany2one1 deleted = this.wmGenericDao.findById(virtualmany2one1Id);
        if (deleted == null) {
            LOGGER.debug("No VirtualMany2one1 found with id: {}", virtualmany2one1Id);
            throw new EntityNotFoundException(String.valueOf(virtualmany2one1Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public void delete(VirtualMany2one1 virtualMany2one1) {
        LOGGER.debug("Deleting VirtualMany2one1 with {}", virtualMany2one1);
        this.wmGenericDao.delete(virtualMany2one1);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<VirtualMany2one1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all VirtualMany2one1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<VirtualMany2one1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all VirtualMany2one1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table VirtualMany2one1 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios for table VirtualMany2one1 to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}