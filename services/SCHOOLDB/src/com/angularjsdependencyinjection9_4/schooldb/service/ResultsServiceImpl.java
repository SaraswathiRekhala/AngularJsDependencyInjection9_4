/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.schooldb.service;

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

import com.angularjsdependencyinjection9_4.schooldb.Results;
import com.angularjsdependencyinjection9_4.schooldb.ResultsId;


/**
 * ServiceImpl object for domain model class Results.
 *
 * @see Results
 */
@Service("SCHOOLDB.ResultsService")
@Validated
public class ResultsServiceImpl implements ResultsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultsServiceImpl.class);


    @Autowired
    @Qualifier("SCHOOLDB.ResultsDao")
    private WMGenericDao<Results, ResultsId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Results, ResultsId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Results create(Results results) {
        LOGGER.debug("Creating a new Results with information: {}", results);

        Results resultsCreated = this.wmGenericDao.create(results);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(resultsCreated);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Results getById(ResultsId resultsId) {
        LOGGER.debug("Finding Results by id: {}", resultsId);
        return this.wmGenericDao.findById(resultsId);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Results findById(ResultsId resultsId) {
        LOGGER.debug("Finding Results by id: {}", resultsId);
        try {
            return this.wmGenericDao.findById(resultsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Results found with id: {}", resultsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public List<Results> findByMultipleIds(List<ResultsId> resultsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Results by ids: {}", resultsIds);

        return this.wmGenericDao.findByMultipleIds(resultsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SCHOOLDBTransactionManager")
    @Override
    public Results update(Results results) {
        LOGGER.debug("Updating Results with information: {}", results);

        this.wmGenericDao.update(results);
        this.wmGenericDao.refresh(results);

        return results;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Results delete(ResultsId resultsId) {
        LOGGER.debug("Deleting Results with id: {}", resultsId);
        Results deleted = this.wmGenericDao.findById(resultsId);
        if (deleted == null) {
            LOGGER.debug("No Results found with id: {}", resultsId);
            throw new EntityNotFoundException(String.valueOf(resultsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public void delete(Results results) {
        LOGGER.debug("Deleting Results with {}", results);
        this.wmGenericDao.delete(results);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Results> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Results");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Results> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Results");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Results to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Results to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}