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

import com.angularjsdependencyinjection9_4.dbscenarios1.TOne2oneP;


/**
 * ServiceImpl object for domain model class TOne2oneP.
 *
 * @see TOne2oneP
 */
@Service("dbscenarios1.TOne2onePService")
@Validated
public class TOne2onePServiceImpl implements TOne2onePService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TOne2onePServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.TOne2onePDao")
    private WMGenericDao<TOne2oneP, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TOne2oneP, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneP create(TOne2oneP tone2oneP) {
        LOGGER.debug("Creating a new TOne2oneP with information: {}", tone2oneP);

        TOne2oneP tone2onePCreated = this.wmGenericDao.create(tone2oneP);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tone2onePCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneP getById(Short tone2onepId) {
        LOGGER.debug("Finding TOne2oneP by id: {}", tone2onepId);
        return this.wmGenericDao.findById(tone2onepId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneP findById(Short tone2onepId) {
        LOGGER.debug("Finding TOne2oneP by id: {}", tone2onepId);
        try {
            return this.wmGenericDao.findById(tone2onepId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No TOne2oneP found with id: {}", tone2onepId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<TOne2oneP> findByMultipleIds(List<Short> tone2onepIds, boolean orderedReturn) {
        LOGGER.debug("Finding TOne2onePs by ids: {}", tone2onepIds);

        return this.wmGenericDao.findByMultipleIds(tone2onepIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneP getBySerialCol(long serialCol) {
        Map<String, Object> serialColMap = new HashMap<>();
        serialColMap.put("serialCol", serialCol);

        LOGGER.debug("Finding TOne2oneP by unique keys: {}", serialColMap);
        return this.wmGenericDao.findByUniqueKey(serialColMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneP update(TOne2oneP tone2oneP) {
        LOGGER.debug("Updating TOne2oneP with information: {}", tone2oneP);

        this.wmGenericDao.update(tone2oneP);
        this.wmGenericDao.refresh(tone2oneP);

        return tone2oneP;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneP delete(Short tone2onepId) {
        LOGGER.debug("Deleting TOne2oneP with id: {}", tone2onepId);
        TOne2oneP deleted = this.wmGenericDao.findById(tone2onepId);
        if (deleted == null) {
            LOGGER.debug("No TOne2oneP found with id: {}", tone2onepId);
            throw new EntityNotFoundException(String.valueOf(tone2onepId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(TOne2oneP tone2oneP) {
        LOGGER.debug("Deleting TOne2oneP with {}", tone2oneP);
        this.wmGenericDao.delete(tone2oneP);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<TOne2oneP> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TOne2onePs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<TOne2oneP> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TOne2onePs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table TOne2oneP to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table TOne2oneP to {} format", options.getExportType());
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