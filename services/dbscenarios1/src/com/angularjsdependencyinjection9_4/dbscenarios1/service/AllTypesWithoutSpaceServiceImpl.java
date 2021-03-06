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

import com.angularjsdependencyinjection9_4.dbscenarios1.AllTypesWithoutSpace;


/**
 * ServiceImpl object for domain model class AllTypesWithoutSpace.
 *
 * @see AllTypesWithoutSpace
 */
@Service("dbscenarios1.AllTypesWithoutSpaceService")
@Validated
public class AllTypesWithoutSpaceServiceImpl implements AllTypesWithoutSpaceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllTypesWithoutSpaceServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.AllTypesWithoutSpaceDao")
    private WMGenericDao<AllTypesWithoutSpace, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AllTypesWithoutSpace, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public AllTypesWithoutSpace create(AllTypesWithoutSpace allTypesWithoutSpace) {
        LOGGER.debug("Creating a new AllTypesWithoutSpace with information: {}", allTypesWithoutSpace);

        AllTypesWithoutSpace allTypesWithoutSpaceCreated = this.wmGenericDao.create(allTypesWithoutSpace);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(allTypesWithoutSpaceCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public AllTypesWithoutSpace getById(Integer alltypeswithoutspaceId) {
        LOGGER.debug("Finding AllTypesWithoutSpace by id: {}", alltypeswithoutspaceId);
        return this.wmGenericDao.findById(alltypeswithoutspaceId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public AllTypesWithoutSpace findById(Integer alltypeswithoutspaceId) {
        LOGGER.debug("Finding AllTypesWithoutSpace by id: {}", alltypeswithoutspaceId);
        try {
            return this.wmGenericDao.findById(alltypeswithoutspaceId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No AllTypesWithoutSpace found with id: {}", alltypeswithoutspaceId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<AllTypesWithoutSpace> findByMultipleIds(List<Integer> alltypeswithoutspaceIds, boolean orderedReturn) {
        LOGGER.debug("Finding AllTypesWithoutSpaces by ids: {}", alltypeswithoutspaceIds);

        return this.wmGenericDao.findByMultipleIds(alltypeswithoutspaceIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public AllTypesWithoutSpace update(AllTypesWithoutSpace allTypesWithoutSpace) {
        LOGGER.debug("Updating AllTypesWithoutSpace with information: {}", allTypesWithoutSpace);

        this.wmGenericDao.update(allTypesWithoutSpace);
        this.wmGenericDao.refresh(allTypesWithoutSpace);

        return allTypesWithoutSpace;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public AllTypesWithoutSpace delete(Integer alltypeswithoutspaceId) {
        LOGGER.debug("Deleting AllTypesWithoutSpace with id: {}", alltypeswithoutspaceId);
        AllTypesWithoutSpace deleted = this.wmGenericDao.findById(alltypeswithoutspaceId);
        if (deleted == null) {
            LOGGER.debug("No AllTypesWithoutSpace found with id: {}", alltypeswithoutspaceId);
            throw new EntityNotFoundException(String.valueOf(alltypeswithoutspaceId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(AllTypesWithoutSpace allTypesWithoutSpace) {
        LOGGER.debug("Deleting AllTypesWithoutSpace with {}", allTypesWithoutSpace);
        this.wmGenericDao.delete(allTypesWithoutSpace);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<AllTypesWithoutSpace> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all AllTypesWithoutSpaces");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<AllTypesWithoutSpace> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all AllTypesWithoutSpaces");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table AllTypesWithoutSpace to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table AllTypesWithoutSpace to {} format", options.getExportType());
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