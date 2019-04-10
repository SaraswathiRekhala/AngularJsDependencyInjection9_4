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

import com.angularjsdependencyinjection9_4.schooldb.Alltypes;


/**
 * ServiceImpl object for domain model class Alltypes.
 *
 * @see Alltypes
 */
@Service("SCHOOLDB.AlltypesService")
@Validated
public class AlltypesServiceImpl implements AlltypesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlltypesServiceImpl.class);


    @Autowired
    @Qualifier("SCHOOLDB.AlltypesDao")
    private WMGenericDao<Alltypes, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Alltypes, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Alltypes create(Alltypes alltypes) {
        LOGGER.debug("Creating a new Alltypes with information: {}", alltypes);

        Alltypes alltypesCreated = this.wmGenericDao.create(alltypes);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(alltypesCreated);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Alltypes getById(Integer alltypesId) {
        LOGGER.debug("Finding Alltypes by id: {}", alltypesId);
        return this.wmGenericDao.findById(alltypesId);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Alltypes findById(Integer alltypesId) {
        LOGGER.debug("Finding Alltypes by id: {}", alltypesId);
        try {
            return this.wmGenericDao.findById(alltypesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Alltypes found with id: {}", alltypesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public List<Alltypes> findByMultipleIds(List<Integer> alltypesIds, boolean orderedReturn) {
        LOGGER.debug("Finding Alltypes by ids: {}", alltypesIds);

        return this.wmGenericDao.findByMultipleIds(alltypesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SCHOOLDBTransactionManager")
    @Override
    public Alltypes update(Alltypes alltypes) {
        LOGGER.debug("Updating Alltypes with information: {}", alltypes);

        this.wmGenericDao.update(alltypes);
        this.wmGenericDao.refresh(alltypes);

        return alltypes;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Alltypes delete(Integer alltypesId) {
        LOGGER.debug("Deleting Alltypes with id: {}", alltypesId);
        Alltypes deleted = this.wmGenericDao.findById(alltypesId);
        if (deleted == null) {
            LOGGER.debug("No Alltypes found with id: {}", alltypesId);
            throw new EntityNotFoundException(String.valueOf(alltypesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public void delete(Alltypes alltypes) {
        LOGGER.debug("Deleting Alltypes with {}", alltypes);
        this.wmGenericDao.delete(alltypes);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Alltypes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Alltypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Alltypes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Alltypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Alltypes to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Alltypes to {} format", options.getExportType());
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