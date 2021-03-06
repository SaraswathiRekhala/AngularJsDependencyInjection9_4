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

import com.angularjsdependencyinjection9_4.dbscenarios1.Table20Entity;


/**
 * ServiceImpl object for domain model class Table20Entity.
 *
 * @see Table20Entity
 */
@Service("dbscenarios1.Table20EntityService")
@Validated
public class Table20EntityServiceImpl implements Table20EntityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table20EntityServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.Table20EntityDao")
    private WMGenericDao<Table20Entity, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table20Entity, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Table20Entity create(Table20Entity table20entity) {
        LOGGER.debug("Creating a new Table20Entity with information: {}", table20entity);

        Table20Entity table20entityCreated = this.wmGenericDao.create(table20entity);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table20entityCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Table20Entity getById(Integer table20entityId) {
        LOGGER.debug("Finding Table20Entity by id: {}", table20entityId);
        return this.wmGenericDao.findById(table20entityId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Table20Entity findById(Integer table20entityId) {
        LOGGER.debug("Finding Table20Entity by id: {}", table20entityId);
        try {
            return this.wmGenericDao.findById(table20entityId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table20Entity found with id: {}", table20entityId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<Table20Entity> findByMultipleIds(List<Integer> table20entityIds, boolean orderedReturn) {
        LOGGER.debug("Finding Table20Entities by ids: {}", table20entityIds);

        return this.wmGenericDao.findByMultipleIds(table20entityIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Table20Entity getByLastName(String lastName) {
        Map<String, Object> lastNameMap = new HashMap<>();
        lastNameMap.put("lastName", lastName);

        LOGGER.debug("Finding Table20Entity by unique keys: {}", lastNameMap);
        return this.wmGenericDao.findByUniqueKey(lastNameMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public Table20Entity update(Table20Entity table20entity) {
        LOGGER.debug("Updating Table20Entity with information: {}", table20entity);

        this.wmGenericDao.update(table20entity);
        this.wmGenericDao.refresh(table20entity);

        return table20entity;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Table20Entity delete(Integer table20entityId) {
        LOGGER.debug("Deleting Table20Entity with id: {}", table20entityId);
        Table20Entity deleted = this.wmGenericDao.findById(table20entityId);
        if (deleted == null) {
            LOGGER.debug("No Table20Entity found with id: {}", table20entityId);
            throw new EntityNotFoundException(String.valueOf(table20entityId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(Table20Entity table20entity) {
        LOGGER.debug("Deleting Table20Entity with {}", table20entity);
        this.wmGenericDao.delete(table20entity);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Table20Entity> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table20Entities");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Table20Entity> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table20Entities");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Table20Entity to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Table20Entity to {} format", options.getExportType());
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