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

import com.angularjsdependencyinjection9_4.dbscenarios1.SampleTable2;


/**
 * ServiceImpl object for domain model class SampleTable2.
 *
 * @see SampleTable2
 */
@Service("dbscenarios1.SampleTable2Service")
@Validated
public class SampleTable2ServiceImpl implements SampleTable2Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleTable2ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.SampleTable2Dao")
    private WMGenericDao<SampleTable2, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SampleTable2, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable2 create(SampleTable2 sampleTable2) {
        LOGGER.debug("Creating a new SampleTable2 with information: {}", sampleTable2);

        SampleTable2 sampleTable2Created = this.wmGenericDao.create(sampleTable2);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(sampleTable2Created);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable2 getById(Integer sampletable2Id) {
        LOGGER.debug("Finding SampleTable2 by id: {}", sampletable2Id);
        return this.wmGenericDao.findById(sampletable2Id);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable2 findById(Integer sampletable2Id) {
        LOGGER.debug("Finding SampleTable2 by id: {}", sampletable2Id);
        try {
            return this.wmGenericDao.findById(sampletable2Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No SampleTable2 found with id: {}", sampletable2Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<SampleTable2> findByMultipleIds(List<Integer> sampletable2Ids, boolean orderedReturn) {
        LOGGER.debug("Finding SampleTable2s by ids: {}", sampletable2Ids);

        return this.wmGenericDao.findByMultipleIds(sampletable2Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable2 update(SampleTable2 sampleTable2) {
        LOGGER.debug("Updating SampleTable2 with information: {}", sampleTable2);

        this.wmGenericDao.update(sampleTable2);
        this.wmGenericDao.refresh(sampleTable2);

        return sampleTable2;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public SampleTable2 delete(Integer sampletable2Id) {
        LOGGER.debug("Deleting SampleTable2 with id: {}", sampletable2Id);
        SampleTable2 deleted = this.wmGenericDao.findById(sampletable2Id);
        if (deleted == null) {
            LOGGER.debug("No SampleTable2 found with id: {}", sampletable2Id);
            throw new EntityNotFoundException(String.valueOf(sampletable2Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(SampleTable2 sampleTable2) {
        LOGGER.debug("Deleting SampleTable2 with {}", sampleTable2);
        this.wmGenericDao.delete(sampleTable2);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<SampleTable2> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SampleTable2s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<SampleTable2> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SampleTable2s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table SampleTable2 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table SampleTable2 to {} format", options.getExportType());
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