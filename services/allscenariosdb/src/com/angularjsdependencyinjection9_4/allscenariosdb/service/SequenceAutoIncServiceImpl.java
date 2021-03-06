/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.allscenariosdb.service;

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

import com.angularjsdependencyinjection9_4.allscenariosdb.SequenceAutoInc;


/**
 * ServiceImpl object for domain model class SequenceAutoInc.
 *
 * @see SequenceAutoInc
 */
@Service("allscenariosdb.SequenceAutoIncService")
@Validated
public class SequenceAutoIncServiceImpl implements SequenceAutoIncService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SequenceAutoIncServiceImpl.class);


    @Autowired
    @Qualifier("allscenariosdb.SequenceAutoIncDao")
    private WMGenericDao<SequenceAutoInc, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SequenceAutoInc, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public SequenceAutoInc create(SequenceAutoInc sequenceAutoInc) {
        LOGGER.debug("Creating a new SequenceAutoInc with information: {}", sequenceAutoInc);

        SequenceAutoInc sequenceAutoIncCreated = this.wmGenericDao.create(sequenceAutoInc);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(sequenceAutoIncCreated);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public SequenceAutoInc getById(Integer sequenceautoincId) {
        LOGGER.debug("Finding SequenceAutoInc by id: {}", sequenceautoincId);
        return this.wmGenericDao.findById(sequenceautoincId);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public SequenceAutoInc findById(Integer sequenceautoincId) {
        LOGGER.debug("Finding SequenceAutoInc by id: {}", sequenceautoincId);
        try {
            return this.wmGenericDao.findById(sequenceautoincId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No SequenceAutoInc found with id: {}", sequenceautoincId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public List<SequenceAutoInc> findByMultipleIds(List<Integer> sequenceautoincIds, boolean orderedReturn) {
        LOGGER.debug("Finding SequenceAutoIncs by ids: {}", sequenceautoincIds);

        return this.wmGenericDao.findByMultipleIds(sequenceautoincIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "allscenariosdbTransactionManager")
    @Override
    public SequenceAutoInc update(SequenceAutoInc sequenceAutoInc) {
        LOGGER.debug("Updating SequenceAutoInc with information: {}", sequenceAutoInc);

        this.wmGenericDao.update(sequenceAutoInc);
        this.wmGenericDao.refresh(sequenceAutoInc);

        return sequenceAutoInc;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public SequenceAutoInc delete(Integer sequenceautoincId) {
        LOGGER.debug("Deleting SequenceAutoInc with id: {}", sequenceautoincId);
        SequenceAutoInc deleted = this.wmGenericDao.findById(sequenceautoincId);
        if (deleted == null) {
            LOGGER.debug("No SequenceAutoInc found with id: {}", sequenceautoincId);
            throw new EntityNotFoundException(String.valueOf(sequenceautoincId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public void delete(SequenceAutoInc sequenceAutoInc) {
        LOGGER.debug("Deleting SequenceAutoInc with {}", sequenceAutoInc);
        this.wmGenericDao.delete(sequenceAutoInc);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<SequenceAutoInc> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SequenceAutoIncs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<SequenceAutoInc> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SequenceAutoIncs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service allscenariosdb for table SequenceAutoInc to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service allscenariosdb for table SequenceAutoInc to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}