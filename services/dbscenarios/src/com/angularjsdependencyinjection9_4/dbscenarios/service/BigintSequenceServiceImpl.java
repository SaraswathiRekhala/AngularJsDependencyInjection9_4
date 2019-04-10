/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios.service;

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

import com.angularjsdependencyinjection9_4.dbscenarios.BigintSequence;


/**
 * ServiceImpl object for domain model class BigintSequence.
 *
 * @see BigintSequence
 */
@Service("dbscenarios.BigintSequenceService")
@Validated
public class BigintSequenceServiceImpl implements BigintSequenceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BigintSequenceServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.BigintSequenceDao")
    private WMGenericDao<BigintSequence, Long> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<BigintSequence, Long> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public BigintSequence create(BigintSequence bigintSequence) {
        LOGGER.debug("Creating a new BigintSequence with information: {}", bigintSequence);

        BigintSequence bigintSequenceCreated = this.wmGenericDao.create(bigintSequence);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(bigintSequenceCreated);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public BigintSequence getById(Long bigintsequenceId) {
        LOGGER.debug("Finding BigintSequence by id: {}", bigintsequenceId);
        return this.wmGenericDao.findById(bigintsequenceId);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public BigintSequence findById(Long bigintsequenceId) {
        LOGGER.debug("Finding BigintSequence by id: {}", bigintsequenceId);
        try {
            return this.wmGenericDao.findById(bigintsequenceId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No BigintSequence found with id: {}", bigintsequenceId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public List<BigintSequence> findByMultipleIds(List<Long> bigintsequenceIds, boolean orderedReturn) {
        LOGGER.debug("Finding BigintSequences by ids: {}", bigintsequenceIds);

        return this.wmGenericDao.findByMultipleIds(bigintsequenceIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
    @Override
    public BigintSequence update(BigintSequence bigintSequence) {
        LOGGER.debug("Updating BigintSequence with information: {}", bigintSequence);

        this.wmGenericDao.update(bigintSequence);
        this.wmGenericDao.refresh(bigintSequence);

        return bigintSequence;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public BigintSequence delete(Long bigintsequenceId) {
        LOGGER.debug("Deleting BigintSequence with id: {}", bigintsequenceId);
        BigintSequence deleted = this.wmGenericDao.findById(bigintsequenceId);
        if (deleted == null) {
            LOGGER.debug("No BigintSequence found with id: {}", bigintsequenceId);
            throw new EntityNotFoundException(String.valueOf(bigintsequenceId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public void delete(BigintSequence bigintSequence) {
        LOGGER.debug("Deleting BigintSequence with {}", bigintSequence);
        this.wmGenericDao.delete(bigintSequence);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<BigintSequence> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all BigintSequences");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<BigintSequence> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all BigintSequences");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table BigintSequence to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios for table BigintSequence to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}