/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.sql.Time;
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

import com.angularjsdependencyinjection9_4.dbscenarios.TCrOne2one1;
import com.angularjsdependencyinjection9_4.dbscenarios.TCrOne2one1Id;


/**
 * ServiceImpl object for domain model class TCrOne2one1.
 *
 * @see TCrOne2one1
 */
@Service("dbscenarios.TCrOne2one1Service")
@Validated
public class TCrOne2one1ServiceImpl implements TCrOne2one1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCrOne2one1ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.TCrOne2one1Dao")
    private WMGenericDao<TCrOne2one1, TCrOne2one1Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TCrOne2one1, TCrOne2one1Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public TCrOne2one1 create(TCrOne2one1 tcrOne2one1) {
        LOGGER.debug("Creating a new TCrOne2one1 with information: {}", tcrOne2one1);

        TCrOne2one1 tcrOne2one1Created = this.wmGenericDao.create(tcrOne2one1);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tcrOne2one1Created);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public TCrOne2one1 getById(TCrOne2one1Id tcrone2one1Id) {
        LOGGER.debug("Finding TCrOne2one1 by id: {}", tcrone2one1Id);
        return this.wmGenericDao.findById(tcrone2one1Id);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public TCrOne2one1 findById(TCrOne2one1Id tcrone2one1Id) {
        LOGGER.debug("Finding TCrOne2one1 by id: {}", tcrone2one1Id);
        try {
            return this.wmGenericDao.findById(tcrone2one1Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No TCrOne2one1 found with id: {}", tcrone2one1Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public List<TCrOne2one1> findByMultipleIds(List<TCrOne2one1Id> tcrone2one1Ids, boolean orderedReturn) {
        LOGGER.debug("Finding TCrOne2one1s by ids: {}", tcrone2one1Ids);

        return this.wmGenericDao.findByMultipleIds(tcrone2one1Ids, orderedReturn);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public TCrOne2one1 getByTimeCol(Time timeCol) {
        Map<String, Object> timeColMap = new HashMap<>();
        timeColMap.put("timeCol", timeCol);

        LOGGER.debug("Finding TCrOne2one1 by unique keys: {}", timeColMap);
        return this.wmGenericDao.findByUniqueKey(timeColMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
    @Override
    public TCrOne2one1 update(TCrOne2one1 tcrOne2one1) {
        LOGGER.debug("Updating TCrOne2one1 with information: {}", tcrOne2one1);

        this.wmGenericDao.update(tcrOne2one1);
        this.wmGenericDao.refresh(tcrOne2one1);

        return tcrOne2one1;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public TCrOne2one1 delete(TCrOne2one1Id tcrone2one1Id) {
        LOGGER.debug("Deleting TCrOne2one1 with id: {}", tcrone2one1Id);
        TCrOne2one1 deleted = this.wmGenericDao.findById(tcrone2one1Id);
        if (deleted == null) {
            LOGGER.debug("No TCrOne2one1 found with id: {}", tcrone2one1Id);
            throw new EntityNotFoundException(String.valueOf(tcrone2one1Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public void delete(TCrOne2one1 tcrOne2one1) {
        LOGGER.debug("Deleting TCrOne2one1 with {}", tcrOne2one1);
        this.wmGenericDao.delete(tcrOne2one1);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<TCrOne2one1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TCrOne2one1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<TCrOne2one1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TCrOne2one1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table TCrOne2one1 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios for table TCrOne2one1 to {} format", options.getExportType());
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