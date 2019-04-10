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

import com.angularjsdependencyinjection9_4.schooldb.Persons;
import com.angularjsdependencyinjection9_4.schooldb.PersonsId;


/**
 * ServiceImpl object for domain model class Persons.
 *
 * @see Persons
 */
@Service("SCHOOLDB.PersonsService")
@Validated
public class PersonsServiceImpl implements PersonsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonsServiceImpl.class);


    @Autowired
    @Qualifier("SCHOOLDB.PersonsDao")
    private WMGenericDao<Persons, PersonsId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Persons, PersonsId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Persons create(Persons persons) {
        LOGGER.debug("Creating a new Persons with information: {}", persons);

        Persons personsCreated = this.wmGenericDao.create(persons);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(personsCreated);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Persons getById(PersonsId personsId) {
        LOGGER.debug("Finding Persons by id: {}", personsId);
        return this.wmGenericDao.findById(personsId);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Persons findById(PersonsId personsId) {
        LOGGER.debug("Finding Persons by id: {}", personsId);
        try {
            return this.wmGenericDao.findById(personsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Persons found with id: {}", personsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public List<Persons> findByMultipleIds(List<PersonsId> personsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Persons by ids: {}", personsIds);

        return this.wmGenericDao.findByMultipleIds(personsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SCHOOLDBTransactionManager")
    @Override
    public Persons update(Persons persons) {
        LOGGER.debug("Updating Persons with information: {}", persons);

        this.wmGenericDao.update(persons);
        this.wmGenericDao.refresh(persons);

        return persons;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public Persons delete(PersonsId personsId) {
        LOGGER.debug("Deleting Persons with id: {}", personsId);
        Persons deleted = this.wmGenericDao.findById(personsId);
        if (deleted == null) {
            LOGGER.debug("No Persons found with id: {}", personsId);
            throw new EntityNotFoundException(String.valueOf(personsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "SCHOOLDBTransactionManager")
    @Override
    public void delete(Persons persons) {
        LOGGER.debug("Deleting Persons with {}", persons);
        this.wmGenericDao.delete(persons);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Persons> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Persons");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager")
    @Override
    public Page<Persons> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Persons");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Persons to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "SCHOOLDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service SCHOOLDB for table Persons to {} format", options.getExportType());
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