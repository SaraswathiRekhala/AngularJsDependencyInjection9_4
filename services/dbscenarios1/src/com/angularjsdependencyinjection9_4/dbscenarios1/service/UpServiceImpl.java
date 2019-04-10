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

import com.angularjsdependencyinjection9_4.dbscenarios1.Up;


/**
 * ServiceImpl object for domain model class Up.
 *
 * @see Up
 */
@Service("dbscenarios1.UpService")
@Validated
public class UpServiceImpl implements UpService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.UpDao")
    private WMGenericDao<Up, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Up, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Up create(Up up) {
        LOGGER.debug("Creating a new Up with information: {}", up);

        Up upCreated = this.wmGenericDao.create(up);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(upCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Up getById(Integer upId) {
        LOGGER.debug("Finding Up by id: {}", upId);
        return this.wmGenericDao.findById(upId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Up findById(Integer upId) {
        LOGGER.debug("Finding Up by id: {}", upId);
        try {
            return this.wmGenericDao.findById(upId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Up found with id: {}", upId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<Up> findByMultipleIds(List<Integer> upIds, boolean orderedReturn) {
        LOGGER.debug("Finding Ups by ids: {}", upIds);

        return this.wmGenericDao.findByMultipleIds(upIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public Up update(Up up) {
        LOGGER.debug("Updating Up with information: {}", up);

        this.wmGenericDao.update(up);
        this.wmGenericDao.refresh(up);

        return up;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Up delete(Integer upId) {
        LOGGER.debug("Deleting Up with id: {}", upId);
        Up deleted = this.wmGenericDao.findById(upId);
        if (deleted == null) {
            LOGGER.debug("No Up found with id: {}", upId);
            throw new EntityNotFoundException(String.valueOf(upId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(Up up) {
        LOGGER.debug("Deleting Up with {}", up);
        this.wmGenericDao.delete(up);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Up> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Ups");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Up> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Ups");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Up to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Up to {} format", options.getExportType());
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