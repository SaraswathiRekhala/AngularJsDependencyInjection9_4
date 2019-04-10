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

import com.angularjsdependencyinjection9_4.schooldb.ViewAllTypes;
import com.angularjsdependencyinjection9_4.schooldb.ViewAllTypesId;


/**
 * ServiceImpl object for domain model class ViewAllTypes.
 *
 * @see ViewAllTypes
 */
@Service("SCHOOLDB.ViewAllTypesService")
@Validated
public class ViewAllTypesServiceImpl implements ViewAllTypesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewAllTypesServiceImpl.class);


    @Autowired
    @Qualifier("SCHOOLDB.ViewAllTypesDao")
    private WMGenericDao<ViewAllTypes, ViewAllTypesId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ViewAllTypes, ViewAllTypesId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public ViewAllTypes create(ViewAllTypes viewAllTypes) {
        LOGGER.debug("Creating a new ViewAllTypes with information: {}", viewAllTypes);

        ViewAllTypes viewAllTypesCreated = this.wmGenericDao.create(viewAllTypes);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(viewAllTypesCreated);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public ViewAllTypes getById(ViewAllTypesId viewalltypesId) {
        LOGGER.debug("Finding ViewAllTypes by id: {}", viewalltypesId);
        return this.wmGenericDao.findById(viewalltypesId);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public ViewAllTypes findById(ViewAllTypesId viewalltypesId) {
        LOGGER.debug("Finding ViewAllTypes by id: {}", viewalltypesId);
        try {
            return this.wmGenericDao.findById(viewalltypesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No ViewAllTypes found with id: {}", viewalltypesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public List<ViewAllTypes> findByMultipleIds(List<ViewAllTypesId> viewalltypesIds, boolean orderedReturn) {
        LOGGER.debug("Finding ViewAllTypes by ids: {}", viewalltypesIds);

        return this.wmGenericDao.findByMultipleIds(viewalltypesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SCHOOLDBTransactionManager")
    @Override
    public ViewAllTypes update(ViewAllTypes viewAllTypes) {
        LOGGER.debug("Updating ViewAllTypes with information: {}", viewAllTypes);

        this.wmGenericDao.update(viewAllTypes);
        this.wmGenericDao.refresh(viewAllTypes);

        return viewAllTypes;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public ViewAllTypes delete(ViewAllTypesId viewalltypesId) {
        LOGGER.debug("Deleting ViewAllTypes with id: {}", viewalltypesId);
        ViewAllTypes deleted = this.wmGenericDao.findById(viewalltypesId);
        if (deleted == null) {
            LOGGER.debug("No ViewAllTypes found with id: {}", viewalltypesId);
            throw new EntityNotFoundException(String.valueOf(viewalltypesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public void delete(ViewAllTypes viewAllTypes) {
        LOGGER.debug("Deleting ViewAllTypes with {}", viewAllTypes);
        this.wmGenericDao.delete(viewAllTypes);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<ViewAllTypes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ViewAllTypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<ViewAllTypes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ViewAllTypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table ViewAllTypes to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table ViewAllTypes to {} format", options.getExportType());
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