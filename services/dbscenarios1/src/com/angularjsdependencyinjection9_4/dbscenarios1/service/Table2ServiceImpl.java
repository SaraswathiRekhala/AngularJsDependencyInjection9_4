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

import com.angularjsdependencyinjection9_4.dbscenarios1.Table2;


/**
 * ServiceImpl object for domain model class Table2.
 *
 * @see Table2
 */
@Service("dbscenarios1.Table2Service")
@Validated
public class Table2ServiceImpl implements Table2Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table2ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.Table2Dao")
    private WMGenericDao<Table2, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table2, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Table2 create(Table2 table2) {
        LOGGER.debug("Creating a new Table2 with information: {}", table2);

        Table2 table2Created = this.wmGenericDao.create(table2);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table2Created);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Table2 getById(Integer table2Id) {
        LOGGER.debug("Finding Table2 by id: {}", table2Id);
        return this.wmGenericDao.findById(table2Id);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Table2 findById(Integer table2Id) {
        LOGGER.debug("Finding Table2 by id: {}", table2Id);
        try {
            return this.wmGenericDao.findById(table2Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table2 found with id: {}", table2Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<Table2> findByMultipleIds(List<Integer> table2Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table2s by ids: {}", table2Ids);

        return this.wmGenericDao.findByMultipleIds(table2Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public Table2 update(Table2 table2) {
        LOGGER.debug("Updating Table2 with information: {}", table2);

        this.wmGenericDao.update(table2);
        this.wmGenericDao.refresh(table2);

        return table2;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Table2 delete(Integer table2Id) {
        LOGGER.debug("Deleting Table2 with id: {}", table2Id);
        Table2 deleted = this.wmGenericDao.findById(table2Id);
        if (deleted == null) {
            LOGGER.debug("No Table2 found with id: {}", table2Id);
            throw new EntityNotFoundException(String.valueOf(table2Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(Table2 table2) {
        LOGGER.debug("Deleting Table2 with {}", table2);
        this.wmGenericDao.delete(table2);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Table2> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table2s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Table2> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table2s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Table2 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Table2 to {} format", options.getExportType());
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