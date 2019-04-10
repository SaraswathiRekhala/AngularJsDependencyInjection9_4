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

import com.angularjsdependencyinjection9_4.dbscenarios1.NewTable;
import com.angularjsdependencyinjection9_4.dbscenarios1.NewTableId;


/**
 * ServiceImpl object for domain model class NewTable.
 *
 * @see NewTable
 */
@Service("dbscenarios1.NewTableService")
@Validated
public class NewTableServiceImpl implements NewTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewTableServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.NewTableDao")
    private WMGenericDao<NewTable, NewTableId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<NewTable, NewTableId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public NewTable create(NewTable newTable) {
        LOGGER.debug("Creating a new NewTable with information: {}", newTable);

        NewTable newTableCreated = this.wmGenericDao.create(newTable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(newTableCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public NewTable getById(NewTableId newtableId) {
        LOGGER.debug("Finding NewTable by id: {}", newtableId);
        return this.wmGenericDao.findById(newtableId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public NewTable findById(NewTableId newtableId) {
        LOGGER.debug("Finding NewTable by id: {}", newtableId);
        try {
            return this.wmGenericDao.findById(newtableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No NewTable found with id: {}", newtableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<NewTable> findByMultipleIds(List<NewTableId> newtableIds, boolean orderedReturn) {
        LOGGER.debug("Finding NewTables by ids: {}", newtableIds);

        return this.wmGenericDao.findByMultipleIds(newtableIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public NewTable getByUniqueKeyId(int id) {
        Map<String, Object> uniqueKeyIdMap = new HashMap<>();
        uniqueKeyIdMap.put("id", id);

        LOGGER.debug("Finding NewTable by unique keys: {}", uniqueKeyIdMap);
        return this.wmGenericDao.findByUniqueKey(uniqueKeyIdMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public NewTable update(NewTable newTable) {
        LOGGER.debug("Updating NewTable with information: {}", newTable);

        this.wmGenericDao.update(newTable);
        this.wmGenericDao.refresh(newTable);

        return newTable;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public NewTable delete(NewTableId newtableId) {
        LOGGER.debug("Deleting NewTable with id: {}", newtableId);
        NewTable deleted = this.wmGenericDao.findById(newtableId);
        if (deleted == null) {
            LOGGER.debug("No NewTable found with id: {}", newtableId);
            throw new EntityNotFoundException(String.valueOf(newtableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(NewTable newTable) {
        LOGGER.debug("Deleting NewTable with {}", newTable);
        this.wmGenericDao.delete(newTable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<NewTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all NewTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<NewTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all NewTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table NewTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table NewTable to {} format", options.getExportType());
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