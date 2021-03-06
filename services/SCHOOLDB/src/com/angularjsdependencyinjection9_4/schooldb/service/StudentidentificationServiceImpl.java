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

import com.angularjsdependencyinjection9_4.schooldb.Studentidentification;


/**
 * ServiceImpl object for domain model class Studentidentification.
 *
 * @see Studentidentification
 */
@Service("SCHOOLDB.StudentidentificationService")
@Validated
public class StudentidentificationServiceImpl implements StudentidentificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentidentificationServiceImpl.class);


    @Autowired
    @Qualifier("SCHOOLDB.StudentidentificationDao")
    private WMGenericDao<Studentidentification, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Studentidentification, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Studentidentification create(Studentidentification studentidentification) {
        LOGGER.debug("Creating a new Studentidentification with information: {}", studentidentification);

        Studentidentification studentidentificationCreated = this.wmGenericDao.create(studentidentification);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(studentidentificationCreated);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Studentidentification getById(Integer studentidentificationId) {
        LOGGER.debug("Finding Studentidentification by id: {}", studentidentificationId);
        return this.wmGenericDao.findById(studentidentificationId);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Studentidentification findById(Integer studentidentificationId) {
        LOGGER.debug("Finding Studentidentification by id: {}", studentidentificationId);
        try {
            return this.wmGenericDao.findById(studentidentificationId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Studentidentification found with id: {}", studentidentificationId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public List<Studentidentification> findByMultipleIds(List<Integer> studentidentificationIds, boolean orderedReturn) {
        LOGGER.debug("Finding Studentidentifications by ids: {}", studentidentificationIds);

        return this.wmGenericDao.findByMultipleIds(studentidentificationIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Studentidentification getByIdentificationnumber(String identificationnumber) {
        Map<String, Object> identificationnumberMap = new HashMap<>();
        identificationnumberMap.put("identificationnumber", identificationnumber);

        LOGGER.debug("Finding Studentidentification by unique keys: {}", identificationnumberMap);
        return this.wmGenericDao.findByUniqueKey(identificationnumberMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SCHOOLDBTransactionManager")
    @Override
    public Studentidentification update(Studentidentification studentidentification) {
        LOGGER.debug("Updating Studentidentification with information: {}", studentidentification);

        this.wmGenericDao.update(studentidentification);
        this.wmGenericDao.refresh(studentidentification);

        return studentidentification;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Studentidentification delete(Integer studentidentificationId) {
        LOGGER.debug("Deleting Studentidentification with id: {}", studentidentificationId);
        Studentidentification deleted = this.wmGenericDao.findById(studentidentificationId);
        if (deleted == null) {
            LOGGER.debug("No Studentidentification found with id: {}", studentidentificationId);
            throw new EntityNotFoundException(String.valueOf(studentidentificationId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public void delete(Studentidentification studentidentification) {
        LOGGER.debug("Deleting Studentidentification with {}", studentidentification);
        this.wmGenericDao.delete(studentidentification);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Studentidentification> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Studentidentifications");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Studentidentification> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Studentidentifications");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Studentidentification to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Studentidentification to {} format", options.getExportType());
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