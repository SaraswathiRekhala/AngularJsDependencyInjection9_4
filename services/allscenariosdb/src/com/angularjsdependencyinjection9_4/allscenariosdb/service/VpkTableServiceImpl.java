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

import com.angularjsdependencyinjection9_4.allscenariosdb.VpkTable;
import com.angularjsdependencyinjection9_4.allscenariosdb.VpkTableId;


/**
 * ServiceImpl object for domain model class VpkTable.
 *
 * @see VpkTable
 */
@Service("allscenariosdb.VpkTableService")
@Validated
public class VpkTableServiceImpl implements VpkTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VpkTableServiceImpl.class);


    @Autowired
    @Qualifier("allscenariosdb.VpkTableDao")
    private WMGenericDao<VpkTable, VpkTableId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VpkTable, VpkTableId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public VpkTable create(VpkTable vpkTable) {
        LOGGER.debug("Creating a new VpkTable with information: {}", vpkTable);

        VpkTable vpkTableCreated = this.wmGenericDao.create(vpkTable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(vpkTableCreated);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public VpkTable getById(VpkTableId vpktableId) {
        LOGGER.debug("Finding VpkTable by id: {}", vpktableId);
        return this.wmGenericDao.findById(vpktableId);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public VpkTable findById(VpkTableId vpktableId) {
        LOGGER.debug("Finding VpkTable by id: {}", vpktableId);
        try {
            return this.wmGenericDao.findById(vpktableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No VpkTable found with id: {}", vpktableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public List<VpkTable> findByMultipleIds(List<VpkTableId> vpktableIds, boolean orderedReturn) {
        LOGGER.debug("Finding VpkTables by ids: {}", vpktableIds);

        return this.wmGenericDao.findByMultipleIds(vpktableIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "allscenariosdbTransactionManager")
    @Override
    public VpkTable update(VpkTable vpkTable) {
        LOGGER.debug("Updating VpkTable with information: {}", vpkTable);

        this.wmGenericDao.update(vpkTable);
        this.wmGenericDao.refresh(vpkTable);

        return vpkTable;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public VpkTable delete(VpkTableId vpktableId) {
        LOGGER.debug("Deleting VpkTable with id: {}", vpktableId);
        VpkTable deleted = this.wmGenericDao.findById(vpktableId);
        if (deleted == null) {
            LOGGER.debug("No VpkTable found with id: {}", vpktableId);
            throw new EntityNotFoundException(String.valueOf(vpktableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public void delete(VpkTable vpkTable) {
        LOGGER.debug("Deleting VpkTable with {}", vpkTable);
        this.wmGenericDao.delete(vpkTable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<VpkTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all VpkTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<VpkTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all VpkTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service allscenariosdb for table VpkTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service allscenariosdb for table VpkTable to {} format", options.getExportType());
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