/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.schooldb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
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

import com.angularjsdependencyinjection9_4.schooldb.Academics;
import com.angularjsdependencyinjection9_4.schooldb.Standarddetails;


/**
 * ServiceImpl object for domain model class Standarddetails.
 *
 * @see Standarddetails
 */
@Service("SCHOOLDB.StandarddetailsService")
@Validated
public class StandarddetailsServiceImpl implements StandarddetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandarddetailsServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("SCHOOLDB.AcademicsService")
    private AcademicsService academicsService;

    @Autowired
    @Qualifier("SCHOOLDB.StandarddetailsDao")
    private WMGenericDao<Standarddetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Standarddetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Standarddetails create(Standarddetails standarddetails) {
        LOGGER.debug("Creating a new Standarddetails with information: {}", standarddetails);

        Standarddetails standarddetailsCreated = this.wmGenericDao.create(standarddetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(standarddetailsCreated);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Standarddetails getById(Integer standarddetailsId) {
        LOGGER.debug("Finding Standarddetails by id: {}", standarddetailsId);
        return this.wmGenericDao.findById(standarddetailsId);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Standarddetails findById(Integer standarddetailsId) {
        LOGGER.debug("Finding Standarddetails by id: {}", standarddetailsId);
        try {
            return this.wmGenericDao.findById(standarddetailsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Standarddetails found with id: {}", standarddetailsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public List<Standarddetails> findByMultipleIds(List<Integer> standarddetailsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Standarddetails by ids: {}", standarddetailsIds);

        return this.wmGenericDao.findByMultipleIds(standarddetailsIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Standarddetails getByStandardcode(String standardcode) {
        Map<String, Object> standardcodeMap = new HashMap<>();
        standardcodeMap.put("standardcode", standardcode);

        LOGGER.debug("Finding Standarddetails by unique keys: {}", standardcodeMap);
        return this.wmGenericDao.findByUniqueKey(standardcodeMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SCHOOLDBTransactionManager")
    @Override
    public Standarddetails update(Standarddetails standarddetails) {
        LOGGER.debug("Updating Standarddetails with information: {}", standarddetails);

        this.wmGenericDao.update(standarddetails);
        this.wmGenericDao.refresh(standarddetails);

        return standarddetails;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Standarddetails delete(Integer standarddetailsId) {
        LOGGER.debug("Deleting Standarddetails with id: {}", standarddetailsId);
        Standarddetails deleted = this.wmGenericDao.findById(standarddetailsId);
        if (deleted == null) {
            LOGGER.debug("No Standarddetails found with id: {}", standarddetailsId);
            throw new EntityNotFoundException(String.valueOf(standarddetailsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public void delete(Standarddetails standarddetails) {
        LOGGER.debug("Deleting Standarddetails with {}", standarddetails);
        this.wmGenericDao.delete(standarddetails);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Standarddetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Standarddetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Standarddetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Standarddetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Standarddetails to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Standarddetails to {} format", options.getExportType());
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

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Academics> findAssociatedAcademicses(Integer standardid, Pageable pageable) {
        LOGGER.debug("Fetching all associated academicses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("standarddetails.standardid = '" + standardid + "'");

        return academicsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AcademicsService instance
     */
    protected void setAcademicsService(AcademicsService service) {
        this.academicsService = service;
    }

}