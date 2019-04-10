/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
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

import com.angularjsdependencyinjection9_4.dbscenarios1.TUcComposites1;


/**
 * ServiceImpl object for domain model class TUcComposites1.
 *
 * @see TUcComposites1
 */
@Service("dbscenarios1.TUcComposites1Service")
@Validated
public class TUcComposites1ServiceImpl implements TUcComposites1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(TUcComposites1ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.TUcComposites1Dao")
    private WMGenericDao<TUcComposites1, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TUcComposites1, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public TUcComposites1 create(TUcComposites1 tucComposites1) {
        LOGGER.debug("Creating a new TUcComposites1 with information: {}", tucComposites1);

        TUcComposites1 tucComposites1Created = this.wmGenericDao.create(tucComposites1);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tucComposites1Created);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public TUcComposites1 getById(Integer tuccomposites1Id) {
        LOGGER.debug("Finding TUcComposites1 by id: {}", tuccomposites1Id);
        return this.wmGenericDao.findById(tuccomposites1Id);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public TUcComposites1 findById(Integer tuccomposites1Id) {
        LOGGER.debug("Finding TUcComposites1 by id: {}", tuccomposites1Id);
        try {
            return this.wmGenericDao.findById(tuccomposites1Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No TUcComposites1 found with id: {}", tuccomposites1Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<TUcComposites1> findByMultipleIds(List<Integer> tuccomposites1Ids, boolean orderedReturn) {
        LOGGER.debug("Finding TUcComposites1s by ids: {}", tuccomposites1Ids);

        return this.wmGenericDao.findByMultipleIds(tuccomposites1Ids, orderedReturn);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public TUcComposites1 getByByteColAndCharColAndShortColAndStringCol(Short byteCol, String charCol, Short shortCol, String stringCol) {
        Map<String, Object> byteColAndCharColAndShortColAndStringColMap = new HashMap<>();
        byteColAndCharColAndShortColAndStringColMap.put("byteCol", byteCol);
        byteColAndCharColAndShortColAndStringColMap.put("charCol", charCol);
        byteColAndCharColAndShortColAndStringColMap.put("shortCol", shortCol);
        byteColAndCharColAndShortColAndStringColMap.put("stringCol", stringCol);

        LOGGER.debug("Finding TUcComposites1 by unique keys: {}", byteColAndCharColAndShortColAndStringColMap);
        return this.wmGenericDao.findByUniqueKey(byteColAndCharColAndShortColAndStringColMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public TUcComposites1 update(TUcComposites1 tucComposites1) {
        LOGGER.debug("Updating TUcComposites1 with information: {}", tucComposites1);

        this.wmGenericDao.update(tucComposites1);
        this.wmGenericDao.refresh(tucComposites1);

        return tucComposites1;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public TUcComposites1 delete(Integer tuccomposites1Id) {
        LOGGER.debug("Deleting TUcComposites1 with id: {}", tuccomposites1Id);
        TUcComposites1 deleted = this.wmGenericDao.findById(tuccomposites1Id);
        if (deleted == null) {
            LOGGER.debug("No TUcComposites1 found with id: {}", tuccomposites1Id);
            throw new EntityNotFoundException(String.valueOf(tuccomposites1Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(TUcComposites1 tucComposites1) {
        LOGGER.debug("Deleting TUcComposites1 with {}", tucComposites1);
        this.wmGenericDao.delete(tucComposites1);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<TUcComposites1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TUcComposites1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<TUcComposites1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TUcComposites1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table TUcComposites1 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table TUcComposites1 to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}