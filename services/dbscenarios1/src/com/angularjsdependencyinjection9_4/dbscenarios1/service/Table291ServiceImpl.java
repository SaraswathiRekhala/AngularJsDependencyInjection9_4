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

import com.angularjsdependencyinjection9_4.dbscenarios1.Table291;
import com.angularjsdependencyinjection9_4.dbscenarios1.Table291Id;


/**
 * ServiceImpl object for domain model class Table291.
 *
 * @see Table291
 */
@Service("dbscenarios1.Table291Service")
@Validated
public class Table291ServiceImpl implements Table291Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table291ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.Table291Dao")
    private WMGenericDao<Table291, Table291Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table291, Table291Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Table291 create(Table291 table291) {
        LOGGER.debug("Creating a new Table291 with information: {}", table291);

        Table291 table291Created = this.wmGenericDao.create(table291);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table291Created);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Table291 getById(Table291Id table291Id) {
        LOGGER.debug("Finding Table291 by id: {}", table291Id);
        return this.wmGenericDao.findById(table291Id);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Table291 findById(Table291Id table291Id) {
        LOGGER.debug("Finding Table291 by id: {}", table291Id);
        try {
            return this.wmGenericDao.findById(table291Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table291 found with id: {}", table291Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<Table291> findByMultipleIds(List<Table291Id> table291Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table291s by ids: {}", table291Ids);

        return this.wmGenericDao.findByMultipleIds(table291Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public Table291 update(Table291 table291) {
        LOGGER.debug("Updating Table291 with information: {}", table291);

        this.wmGenericDao.update(table291);
        this.wmGenericDao.refresh(table291);

        return table291;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Table291 delete(Table291Id table291Id) {
        LOGGER.debug("Deleting Table291 with id: {}", table291Id);
        Table291 deleted = this.wmGenericDao.findById(table291Id);
        if (deleted == null) {
            LOGGER.debug("No Table291 found with id: {}", table291Id);
            throw new EntityNotFoundException(String.valueOf(table291Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(Table291 table291) {
        LOGGER.debug("Deleting Table291 with {}", table291);
        this.wmGenericDao.delete(table291);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Table291> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table291s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Table291> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table291s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Table291 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Table291 to {} format", options.getExportType());
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