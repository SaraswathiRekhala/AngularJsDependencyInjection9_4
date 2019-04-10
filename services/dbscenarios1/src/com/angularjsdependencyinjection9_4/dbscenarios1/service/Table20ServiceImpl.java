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

import com.angularjsdependencyinjection9_4.dbscenarios1.Table20;


/**
 * ServiceImpl object for domain model class Table20.
 *
 * @see Table20
 */
@Service("dbscenarios1.Table20Service")
@Validated
public class Table20ServiceImpl implements Table20Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table20ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.Table20Dao")
    private WMGenericDao<Table20, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table20, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Table20 create(Table20 table20) {
        LOGGER.debug("Creating a new Table20 with information: {}", table20);

        Table20 table20Created = this.wmGenericDao.create(table20);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table20Created);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Table20 getById(Integer table20Id) {
        LOGGER.debug("Finding Table20 by id: {}", table20Id);
        return this.wmGenericDao.findById(table20Id);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Table20 findById(Integer table20Id) {
        LOGGER.debug("Finding Table20 by id: {}", table20Id);
        try {
            return this.wmGenericDao.findById(table20Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table20 found with id: {}", table20Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<Table20> findByMultipleIds(List<Integer> table20Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table20s by ids: {}", table20Ids);

        return this.wmGenericDao.findByMultipleIds(table20Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public Table20 update(Table20 table20) {
        LOGGER.debug("Updating Table20 with information: {}", table20);

        this.wmGenericDao.update(table20);
        this.wmGenericDao.refresh(table20);

        return table20;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Table20 delete(Integer table20Id) {
        LOGGER.debug("Deleting Table20 with id: {}", table20Id);
        Table20 deleted = this.wmGenericDao.findById(table20Id);
        if (deleted == null) {
            LOGGER.debug("No Table20 found with id: {}", table20Id);
            throw new EntityNotFoundException(String.valueOf(table20Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(Table20 table20) {
        LOGGER.debug("Deleting Table20 with {}", table20);
        this.wmGenericDao.delete(table20);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Table20> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table20s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Table20> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table20s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Table20 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Table20 to {} format", options.getExportType());
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

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Table20> findAssociatedTable20sForColumn3(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated table20sForColumn3");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("table20ByColumn3.id = '" + id + "'");

        return findAll(queryBuilder.toString(), pageable);
    }


}