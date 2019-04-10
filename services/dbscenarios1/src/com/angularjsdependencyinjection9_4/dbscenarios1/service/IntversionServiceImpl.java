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

import com.angularjsdependencyinjection9_4.dbscenarios1.Intversion;


/**
 * ServiceImpl object for domain model class Intversion.
 *
 * @see Intversion
 */
@Service("dbscenarios1.IntversionService")
@Validated
public class IntversionServiceImpl implements IntversionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntversionServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.IntversionDao")
    private WMGenericDao<Intversion, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Intversion, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Intversion create(Intversion intversion) {
        LOGGER.debug("Creating a new Intversion with information: {}", intversion);

        Intversion intversionCreated = this.wmGenericDao.create(intversion);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(intversionCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Intversion getById(Integer intversionId) {
        LOGGER.debug("Finding Intversion by id: {}", intversionId);
        return this.wmGenericDao.findById(intversionId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Intversion findById(Integer intversionId) {
        LOGGER.debug("Finding Intversion by id: {}", intversionId);
        try {
            return this.wmGenericDao.findById(intversionId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Intversion found with id: {}", intversionId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<Intversion> findByMultipleIds(List<Integer> intversionIds, boolean orderedReturn) {
        LOGGER.debug("Finding Intversions by ids: {}", intversionIds);

        return this.wmGenericDao.findByMultipleIds(intversionIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public Intversion update(Intversion intversion) {
        LOGGER.debug("Updating Intversion with information: {}", intversion);

        this.wmGenericDao.update(intversion);
        this.wmGenericDao.refresh(intversion);

        return intversion;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Intversion delete(Integer intversionId) {
        LOGGER.debug("Deleting Intversion with id: {}", intversionId);
        Intversion deleted = this.wmGenericDao.findById(intversionId);
        if (deleted == null) {
            LOGGER.debug("No Intversion found with id: {}", intversionId);
            throw new EntityNotFoundException(String.valueOf(intversionId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(Intversion intversion) {
        LOGGER.debug("Deleting Intversion with {}", intversion);
        this.wmGenericDao.delete(intversion);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Intversion> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Intversions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Intversion> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Intversions");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Intversion to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Intversion to {} format", options.getExportType());
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