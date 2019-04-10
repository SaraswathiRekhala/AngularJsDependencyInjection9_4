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

import com.angularjsdependencyinjection9_4.dbscenarios.BlobTable;


/**
 * ServiceImpl object for domain model class BlobTable.
 *
 * @see BlobTable
 */
@Service("dbscenarios.BlobTableService")
@Validated
public class BlobTableServiceImpl implements BlobTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlobTableServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.BlobTableDao")
    private WMGenericDao<BlobTable, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<BlobTable, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public BlobTable create(BlobTable blobTable) {
        LOGGER.debug("Creating a new BlobTable with information: {}", blobTable);

        BlobTable blobTableCreated = this.wmGenericDao.create(blobTable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(blobTableCreated);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public BlobTable getById(Integer blobtableId) {
        LOGGER.debug("Finding BlobTable by id: {}", blobtableId);
        return this.wmGenericDao.findById(blobtableId);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public BlobTable findById(Integer blobtableId) {
        LOGGER.debug("Finding BlobTable by id: {}", blobtableId);
        try {
            return this.wmGenericDao.findById(blobtableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No BlobTable found with id: {}", blobtableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public List<BlobTable> findByMultipleIds(List<Integer> blobtableIds, boolean orderedReturn) {
        LOGGER.debug("Finding BlobTables by ids: {}", blobtableIds);

        return this.wmGenericDao.findByMultipleIds(blobtableIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
    @Override
    public BlobTable update(BlobTable blobTable) {
        LOGGER.debug("Updating BlobTable with information: {}", blobTable);

        this.wmGenericDao.update(blobTable);
        this.wmGenericDao.refresh(blobTable);

        return blobTable;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public BlobTable delete(Integer blobtableId) {
        LOGGER.debug("Deleting BlobTable with id: {}", blobtableId);
        BlobTable deleted = this.wmGenericDao.findById(blobtableId);
        if (deleted == null) {
            LOGGER.debug("No BlobTable found with id: {}", blobtableId);
            throw new EntityNotFoundException(String.valueOf(blobtableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public void delete(BlobTable blobTable) {
        LOGGER.debug("Deleting BlobTable with {}", blobTable);
        this.wmGenericDao.delete(blobTable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<BlobTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all BlobTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<BlobTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all BlobTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table BlobTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios for table BlobTable to {} format", options.getExportType());
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