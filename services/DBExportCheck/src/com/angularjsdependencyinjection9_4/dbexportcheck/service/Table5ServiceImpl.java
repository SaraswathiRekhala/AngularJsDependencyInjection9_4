/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbexportcheck.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
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

import com.angularjsdependencyinjection9_4.dbexportcheck.Table1;
import com.angularjsdependencyinjection9_4.dbexportcheck.Table5;


/**
 * ServiceImpl object for domain model class Table5.
 *
 * @see Table5
 */
@Service("DBExportCheck.Table5Service")
@Validated
public class Table5ServiceImpl implements Table5Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table5ServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("DBExportCheck.Table1Service")
    private Table1Service table1Service;

    @Autowired
    @Qualifier("DBExportCheck.Table5Dao")
    private WMGenericDao<Table5, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table5, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DBExportCheckTransactionManager")
    @Override
    public Table5 create(Table5 table5) {
        LOGGER.debug("Creating a new Table5 with information: {}", table5);

        Table5 table5Created = this.wmGenericDao.create(table5);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table5Created);
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager")
    @Override
    public Table5 getById(Integer table5Id) {
        LOGGER.debug("Finding Table5 by id: {}", table5Id);
        return this.wmGenericDao.findById(table5Id);
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager")
    @Override
    public Table5 findById(Integer table5Id) {
        LOGGER.debug("Finding Table5 by id: {}", table5Id);
        try {
            return this.wmGenericDao.findById(table5Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table5 found with id: {}", table5Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager")
    @Override
    public List<Table5> findByMultipleIds(List<Integer> table5Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table5s by ids: {}", table5Ids);

        return this.wmGenericDao.findByMultipleIds(table5Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "DBExportCheckTransactionManager")
    @Override
    public Table5 update(Table5 table5) {
        LOGGER.debug("Updating Table5 with information: {}", table5);

        this.wmGenericDao.update(table5);
        this.wmGenericDao.refresh(table5);

        return table5;
    }

    @Transactional(value = "DBExportCheckTransactionManager")
    @Override
    public Table5 delete(Integer table5Id) {
        LOGGER.debug("Deleting Table5 with id: {}", table5Id);
        Table5 deleted = this.wmGenericDao.findById(table5Id);
        if (deleted == null) {
            LOGGER.debug("No Table5 found with id: {}", table5Id);
            throw new EntityNotFoundException(String.valueOf(table5Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "DBExportCheckTransactionManager")
    @Override
    public void delete(Table5 table5) {
        LOGGER.debug("Deleting Table5 with {}", table5);
        this.wmGenericDao.delete(table5);
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager")
    @Override
    public Page<Table5> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table5s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager")
    @Override
    public Page<Table5> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table5s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DBExportCheck for table Table5 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service DBExportCheck for table Table5 to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "DBExportCheckTransactionManager")
    @Override
    public Page<Table1> findAssociatedTable1s(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated table1s");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("table5.id = '" + id + "'");

        return table1Service.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service Table1Service instance
     */
    protected void setTable1Service(Table1Service service) {
        this.table1Service = service;
    }

}