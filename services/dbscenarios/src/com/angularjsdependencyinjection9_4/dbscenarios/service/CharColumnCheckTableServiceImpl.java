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

import com.angularjsdependencyinjection9_4.dbscenarios.CharColumnCheckTable;
import com.angularjsdependencyinjection9_4.dbscenarios.CharColumnCheckTableId;


/**
 * ServiceImpl object for domain model class CharColumnCheckTable.
 *
 * @see CharColumnCheckTable
 */
@Service("dbscenarios.CharColumnCheckTableService")
@Validated
public class CharColumnCheckTableServiceImpl implements CharColumnCheckTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CharColumnCheckTableServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.CharColumnCheckTableDao")
    private WMGenericDao<CharColumnCheckTable, CharColumnCheckTableId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CharColumnCheckTable, CharColumnCheckTableId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public CharColumnCheckTable create(CharColumnCheckTable charColumnCheckTable) {
        LOGGER.debug("Creating a new CharColumnCheckTable with information: {}", charColumnCheckTable);

        CharColumnCheckTable charColumnCheckTableCreated = this.wmGenericDao.create(charColumnCheckTable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(charColumnCheckTableCreated);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public CharColumnCheckTable getById(CharColumnCheckTableId charcolumnchecktableId) {
        LOGGER.debug("Finding CharColumnCheckTable by id: {}", charcolumnchecktableId);
        return this.wmGenericDao.findById(charcolumnchecktableId);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public CharColumnCheckTable findById(CharColumnCheckTableId charcolumnchecktableId) {
        LOGGER.debug("Finding CharColumnCheckTable by id: {}", charcolumnchecktableId);
        try {
            return this.wmGenericDao.findById(charcolumnchecktableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No CharColumnCheckTable found with id: {}", charcolumnchecktableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public List<CharColumnCheckTable> findByMultipleIds(List<CharColumnCheckTableId> charcolumnchecktableIds, boolean orderedReturn) {
        LOGGER.debug("Finding CharColumnCheckTables by ids: {}", charcolumnchecktableIds);

        return this.wmGenericDao.findByMultipleIds(charcolumnchecktableIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
    @Override
    public CharColumnCheckTable update(CharColumnCheckTable charColumnCheckTable) {
        LOGGER.debug("Updating CharColumnCheckTable with information: {}", charColumnCheckTable);

        this.wmGenericDao.update(charColumnCheckTable);
        this.wmGenericDao.refresh(charColumnCheckTable);

        return charColumnCheckTable;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public CharColumnCheckTable delete(CharColumnCheckTableId charcolumnchecktableId) {
        LOGGER.debug("Deleting CharColumnCheckTable with id: {}", charcolumnchecktableId);
        CharColumnCheckTable deleted = this.wmGenericDao.findById(charcolumnchecktableId);
        if (deleted == null) {
            LOGGER.debug("No CharColumnCheckTable found with id: {}", charcolumnchecktableId);
            throw new EntityNotFoundException(String.valueOf(charcolumnchecktableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
    public void delete(CharColumnCheckTable charColumnCheckTable) {
        LOGGER.debug("Deleting CharColumnCheckTable with {}", charColumnCheckTable);
        this.wmGenericDao.delete(charColumnCheckTable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<CharColumnCheckTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CharColumnCheckTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<CharColumnCheckTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CharColumnCheckTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table CharColumnCheckTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios for table CharColumnCheckTable to {} format", options.getExportType());
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