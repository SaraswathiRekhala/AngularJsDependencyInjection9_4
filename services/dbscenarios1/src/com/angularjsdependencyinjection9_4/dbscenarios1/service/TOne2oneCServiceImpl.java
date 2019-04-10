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

import com.angularjsdependencyinjection9_4.dbscenarios1.TOne2oneC;


/**
 * ServiceImpl object for domain model class TOne2oneC.
 *
 * @see TOne2oneC
 */
@Service("dbscenarios1.TOne2oneCService")
@Validated
public class TOne2oneCServiceImpl implements TOne2oneCService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TOne2oneCServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.TOne2oneCDao")
    private WMGenericDao<TOne2oneC, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TOne2oneC, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneC create(TOne2oneC tone2oneC) {
        LOGGER.debug("Creating a new TOne2oneC with information: {}", tone2oneC);

        TOne2oneC tone2oneCCreated = this.wmGenericDao.create(tone2oneC);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tone2oneCCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneC getById(Short tone2onecId) {
        LOGGER.debug("Finding TOne2oneC by id: {}", tone2onecId);
        return this.wmGenericDao.findById(tone2onecId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneC findById(Short tone2onecId) {
        LOGGER.debug("Finding TOne2oneC by id: {}", tone2onecId);
        try {
            return this.wmGenericDao.findById(tone2onecId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No TOne2oneC found with id: {}", tone2onecId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<TOne2oneC> findByMultipleIds(List<Short> tone2onecIds, boolean orderedReturn) {
        LOGGER.debug("Finding TOne2oneCs by ids: {}", tone2onecIds);

        return this.wmGenericDao.findByMultipleIds(tone2onecIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneC update(TOne2oneC tone2oneC) {
        LOGGER.debug("Updating TOne2oneC with information: {}", tone2oneC);

        this.wmGenericDao.update(tone2oneC);
        this.wmGenericDao.refresh(tone2oneC);

        return tone2oneC;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public TOne2oneC delete(Short tone2onecId) {
        LOGGER.debug("Deleting TOne2oneC with id: {}", tone2onecId);
        TOne2oneC deleted = this.wmGenericDao.findById(tone2onecId);
        if (deleted == null) {
            LOGGER.debug("No TOne2oneC found with id: {}", tone2onecId);
            throw new EntityNotFoundException(String.valueOf(tone2onecId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(TOne2oneC tone2oneC) {
        LOGGER.debug("Deleting TOne2oneC with {}", tone2oneC);
        this.wmGenericDao.delete(tone2oneC);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<TOne2oneC> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TOne2oneCs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<TOne2oneC> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TOne2oneCs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table TOne2oneC to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table TOne2oneC to {} format", options.getExportType());
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