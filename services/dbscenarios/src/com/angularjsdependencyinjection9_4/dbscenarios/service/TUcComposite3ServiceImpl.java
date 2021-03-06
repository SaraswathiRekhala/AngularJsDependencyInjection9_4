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

import com.angularjsdependencyinjection9_4.dbscenarios.TUcComposite3;
import com.angularjsdependencyinjection9_4.dbscenarios.TUcComposite3Id;


/**
 * ServiceImpl object for domain model class TUcComposite3.
 *
 * @see TUcComposite3
 */
@Service("dbscenarios.TUcComposite3Service")
@Validated
public class TUcComposite3ServiceImpl implements TUcComposite3Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(TUcComposite3ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.TUcComposite3Dao")
    private WMGenericDao<TUcComposite3, TUcComposite3Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TUcComposite3, TUcComposite3Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public TUcComposite3 create(TUcComposite3 tucComposite3) {
        LOGGER.debug("Creating a new TUcComposite3 with information: {}", tucComposite3);

        TUcComposite3 tucComposite3Created = this.wmGenericDao.create(tucComposite3);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tucComposite3Created);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public TUcComposite3 getById(TUcComposite3Id tuccomposite3Id) {
        LOGGER.debug("Finding TUcComposite3 by id: {}", tuccomposite3Id);
        return this.wmGenericDao.findById(tuccomposite3Id);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public TUcComposite3 findById(TUcComposite3Id tuccomposite3Id) {
        LOGGER.debug("Finding TUcComposite3 by id: {}", tuccomposite3Id);
        try {
            return this.wmGenericDao.findById(tuccomposite3Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No TUcComposite3 found with id: {}", tuccomposite3Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public List<TUcComposite3> findByMultipleIds(List<TUcComposite3Id> tuccomposite3Ids, boolean orderedReturn) {
        LOGGER.debug("Finding TUcComposite3s by ids: {}", tuccomposite3Ids);

        return this.wmGenericDao.findByMultipleIds(tuccomposite3Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
    @Override
    public TUcComposite3 update(TUcComposite3 tucComposite3) {
        LOGGER.debug("Updating TUcComposite3 with information: {}", tucComposite3);

        this.wmGenericDao.update(tucComposite3);
        this.wmGenericDao.refresh(tucComposite3);

        return tucComposite3;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public TUcComposite3 delete(TUcComposite3Id tuccomposite3Id) {
        LOGGER.debug("Deleting TUcComposite3 with id: {}", tuccomposite3Id);
        TUcComposite3 deleted = this.wmGenericDao.findById(tuccomposite3Id);
        if (deleted == null) {
            LOGGER.debug("No TUcComposite3 found with id: {}", tuccomposite3Id);
            throw new EntityNotFoundException(String.valueOf(tuccomposite3Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public void delete(TUcComposite3 tucComposite3) {
        LOGGER.debug("Deleting TUcComposite3 with {}", tucComposite3);
        this.wmGenericDao.delete(tucComposite3);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<TUcComposite3> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TUcComposite3s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<TUcComposite3> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TUcComposite3s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table TUcComposite3 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios for table TUcComposite3 to {} format", options.getExportType());
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