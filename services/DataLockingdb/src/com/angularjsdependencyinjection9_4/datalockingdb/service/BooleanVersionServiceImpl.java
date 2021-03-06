/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.datalockingdb.service;

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

import com.angularjsdependencyinjection9_4.datalockingdb.BooleanVersion;


/**
 * ServiceImpl object for domain model class BooleanVersion.
 *
 * @see BooleanVersion
 */
@Service("DataLockingdb.BooleanVersionService")
@Validated
public class BooleanVersionServiceImpl implements BooleanVersionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooleanVersionServiceImpl.class);


    @Autowired
    @Qualifier("DataLockingdb.BooleanVersionDao")
    private WMGenericDao<BooleanVersion, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<BooleanVersion, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DataLockingdbTransactionManager")
    @Override
    public BooleanVersion create(BooleanVersion booleanVersion) {
        LOGGER.debug("Creating a new BooleanVersion with information: {}", booleanVersion);

        BooleanVersion booleanVersionCreated = this.wmGenericDao.create(booleanVersion);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(booleanVersionCreated);
    }

    @Transactional(readOnly = true, value = "DataLockingdbTransactionManager")
    @Override
    public BooleanVersion getById(Integer booleanversionId) {
        LOGGER.debug("Finding BooleanVersion by id: {}", booleanversionId);
        return this.wmGenericDao.findById(booleanversionId);
    }

    @Transactional(readOnly = true, value = "DataLockingdbTransactionManager")
    @Override
    public BooleanVersion findById(Integer booleanversionId) {
        LOGGER.debug("Finding BooleanVersion by id: {}", booleanversionId);
        try {
            return this.wmGenericDao.findById(booleanversionId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No BooleanVersion found with id: {}", booleanversionId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "DataLockingdbTransactionManager")
    @Override
    public List<BooleanVersion> findByMultipleIds(List<Integer> booleanversionIds, boolean orderedReturn) {
        LOGGER.debug("Finding BooleanVersions by ids: {}", booleanversionIds);

        return this.wmGenericDao.findByMultipleIds(booleanversionIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "DataLockingdbTransactionManager")
    @Override
    public BooleanVersion update(BooleanVersion booleanVersion) {
        LOGGER.debug("Updating BooleanVersion with information: {}", booleanVersion);

        this.wmGenericDao.update(booleanVersion);
        this.wmGenericDao.refresh(booleanVersion);

        return booleanVersion;
    }

    @Transactional(value = "DataLockingdbTransactionManager")
    @Override
    public BooleanVersion delete(Integer booleanversionId) {
        LOGGER.debug("Deleting BooleanVersion with id: {}", booleanversionId);
        BooleanVersion deleted = this.wmGenericDao.findById(booleanversionId);
        if (deleted == null) {
            LOGGER.debug("No BooleanVersion found with id: {}", booleanversionId);
            throw new EntityNotFoundException(String.valueOf(booleanversionId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "DataLockingdbTransactionManager")
    @Override
    public void delete(BooleanVersion booleanVersion) {
        LOGGER.debug("Deleting BooleanVersion with {}", booleanVersion);
        this.wmGenericDao.delete(booleanVersion);
    }

    @Transactional(readOnly = true, value = "DataLockingdbTransactionManager")
    @Override
    public Page<BooleanVersion> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all BooleanVersions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DataLockingdbTransactionManager")
    @Override
    public Page<BooleanVersion> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all BooleanVersions");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DataLockingdbTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DataLockingdb for table BooleanVersion to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "DataLockingdbTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service DataLockingdb for table BooleanVersion to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "DataLockingdbTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "DataLockingdbTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}