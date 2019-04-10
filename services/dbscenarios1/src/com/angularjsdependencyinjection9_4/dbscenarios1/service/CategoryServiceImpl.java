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

import com.angularjsdependencyinjection9_4.dbscenarios1.Category;
import com.angularjsdependencyinjection9_4.dbscenarios1.ProductTest;
import com.angularjsdependencyinjection9_4.dbscenarios1.SubCategory;


/**
 * ServiceImpl object for domain model class Category.
 *
 * @see Category
 */
@Service("dbscenarios1.CategoryService")
@Validated
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("dbscenarios1.SubCategoryService")
    private SubCategoryService subCategoryService;

    @Lazy
    @Autowired
    @Qualifier("dbscenarios1.ProductTestService")
    private ProductTestService productTestService;

    @Autowired
    @Qualifier("dbscenarios1.CategoryDao")
    private WMGenericDao<Category, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Category, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Category create(Category category) {
        LOGGER.debug("Creating a new Category with information: {}", category);

        Category categoryCreated = this.wmGenericDao.create(category);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(categoryCreated);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Category getById(String categoryId) {
        LOGGER.debug("Finding Category by id: {}", categoryId);
        return this.wmGenericDao.findById(categoryId);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Category findById(String categoryId) {
        LOGGER.debug("Finding Category by id: {}", categoryId);
        try {
            return this.wmGenericDao.findById(categoryId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Category found with id: {}", categoryId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public List<Category> findByMultipleIds(List<String> categoryIds, boolean orderedReturn) {
        LOGGER.debug("Finding Categories by ids: {}", categoryIds);

        return this.wmGenericDao.findByMultipleIds(categoryIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenarios1TransactionManager")
    @Override
    public Category update(Category category) {
        LOGGER.debug("Updating Category with information: {}", category);

        this.wmGenericDao.update(category);
        this.wmGenericDao.refresh(category);

        return category;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public Category delete(String categoryId) {
        LOGGER.debug("Deleting Category with id: {}", categoryId);
        Category deleted = this.wmGenericDao.findById(categoryId);
        if (deleted == null) {
            LOGGER.debug("No Category found with id: {}", categoryId);
            throw new EntityNotFoundException(String.valueOf(categoryId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "dbscenarios1TransactionManager")
    @Override
    public void delete(Category category) {
        LOGGER.debug("Deleting Category with {}", category);
        this.wmGenericDao.delete(category);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Category> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Categories");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<Category> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Categories");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Category to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service dbscenarios1 for table Category to {} format", options.getExportType());
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

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<ProductTest> findAssociatedProductTests(String catrgory, Pageable pageable) {
        LOGGER.debug("Fetching all associated productTests");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("categoryByCategory.catrgory = '" + catrgory + "'");

        return productTestService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbscenarios1TransactionManager")
    @Override
    public Page<SubCategory> findAssociatedSubCategories(String catrgory, Pageable pageable) {
        LOGGER.debug("Fetching all associated subCategories");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("categoryByCategory.catrgory = '" + catrgory + "'");

        return subCategoryService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service SubCategoryService instance
     */
    protected void setSubCategoryService(SubCategoryService service) {
        this.subCategoryService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service ProductTestService instance
     */
    protected void setProductTestService(ProductTestService service) {
        this.productTestService = service;
    }

}