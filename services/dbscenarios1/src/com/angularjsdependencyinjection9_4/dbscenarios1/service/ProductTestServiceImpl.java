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

import com.angularjsdependencyinjection9_4.dbscenarios1.ProductTest;


/**
 * ServiceImpl object for domain model class ProductTest.
 *
 * @see ProductTest
 */
@Service("dbscenarios1.ProductTestService")
@Validated
public class ProductTestServiceImpl implements ProductTestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTestServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios1.ProductTestDao")
    private WMGenericDao<ProductTest, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ProductTest, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public ProductTest create(ProductTest productTest) {
        LOGGER.debug("Creating a new ProductTest with information: {}", productTest);

        ProductTest productTestCreated = this.wmGenericDao.create(productTest);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(productTestCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public ProductTest getById(Integer producttestId) {
        LOGGER.debug("Finding ProductTest by id: {}", producttestId);
        return this.wmGenericDao.findById(producttestId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public ProductTest findById(Integer producttestId) {
        LOGGER.debug("Finding ProductTest by id: {}", producttestId);
        try {
            return this.wmGenericDao.findById(producttestId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No ProductTest found with id: {}", producttestId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<ProductTest> findByMultipleIds(List<Integer> producttestIds, boolean orderedReturn) {
        LOGGER.debug("Finding ProductTests by ids: {}", producttestIds);

        return this.wmGenericDao.findByMultipleIds(producttestIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public ProductTest update(ProductTest productTest) {
        LOGGER.debug("Updating ProductTest with information: {}", productTest);

        this.wmGenericDao.update(productTest);
        this.wmGenericDao.refresh(productTest);

        return productTest;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public ProductTest delete(Integer producttestId) {
        LOGGER.debug("Deleting ProductTest with id: {}", producttestId);
        ProductTest deleted = this.wmGenericDao.findById(producttestId);
        if (deleted == null) {
            LOGGER.debug("No ProductTest found with id: {}", producttestId);
            throw new EntityNotFoundException(String.valueOf(producttestId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(ProductTest productTest) {
        LOGGER.debug("Deleting ProductTest with {}", productTest);
        this.wmGenericDao.delete(productTest);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<ProductTest> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ProductTests");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<ProductTest> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ProductTests");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table ProductTest to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table ProductTest to {} format", options.getExportType());
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