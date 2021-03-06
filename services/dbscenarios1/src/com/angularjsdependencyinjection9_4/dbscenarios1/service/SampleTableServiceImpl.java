/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1.service;

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

import com.angularjsdependencyinjection9_4.dbscenarios1.SampleTable;
import com.angularjsdependencyinjection9_4.dbscenarios1.SampleTableId;


/**
 * ServiceImpl object for domain model class SampleTable.
 *
 * @see SampleTable
 */
@Service("dbscenarios1.SampleTableService")
@Validated
public class SampleTableServiceImpl implements SampleTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleTableServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.SampleTableDao")
    private WMGenericDao<SampleTable, SampleTableId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SampleTable, SampleTableId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable create(SampleTable sampleTable) {
        LOGGER.debug("Creating a new SampleTable with information: {}", sampleTable);

        SampleTable sampleTableCreated = this.wmGenericDao.create(sampleTable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(sampleTableCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable getById(SampleTableId sampletableId) {
        LOGGER.debug("Finding SampleTable by id: {}", sampletableId);
        return this.wmGenericDao.findById(sampletableId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable findById(SampleTableId sampletableId) {
        LOGGER.debug("Finding SampleTable by id: {}", sampletableId);
        try {
            return this.wmGenericDao.findById(sampletableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No SampleTable found with id: {}", sampletableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<SampleTable> findByMultipleIds(List<SampleTableId> sampletableIds, boolean orderedReturn) {
        LOGGER.debug("Finding SampleTables by ids: {}", sampletableIds);

        return this.wmGenericDao.findByMultipleIds(sampletableIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable update(SampleTable sampleTable) {
        LOGGER.debug("Updating SampleTable with information: {}", sampleTable);

        this.wmGenericDao.update(sampleTable);
        this.wmGenericDao.refresh(sampleTable);

        return sampleTable;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable delete(SampleTableId sampletableId) {
        LOGGER.debug("Deleting SampleTable with id: {}", sampletableId);
        SampleTable deleted = this.wmGenericDao.findById(sampletableId);
        if (deleted == null) {
            LOGGER.debug("No SampleTable found with id: {}", sampletableId);
            throw new EntityNotFoundException(String.valueOf(sampletableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(SampleTable sampleTable) {
        LOGGER.debug("Deleting SampleTable with {}", sampleTable);
        this.wmGenericDao.delete(sampleTable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<SampleTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SampleTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<SampleTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SampleTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table SampleTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table SampleTable to {} format", options.getExportType());
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