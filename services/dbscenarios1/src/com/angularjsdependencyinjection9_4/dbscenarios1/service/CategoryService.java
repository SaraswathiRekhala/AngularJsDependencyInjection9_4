/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
 * Service object for domain model class {@link Category}.
 */
public interface CategoryService {

    /**
     * Creates a new Category. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Category if any.
     *
     * @param category Details of the Category to be created; value cannot be null.
     * @return The newly created Category.
     */
    Category create(@Valid Category category);


	/**
     * Returns Category by given id if exists.
     *
     * @param categoryId The id of the Category to get; value cannot be null.
     * @return Category associated with the given categoryId.
	 * @throws EntityNotFoundException If no Category is found.
     */
    Category getById(String categoryId);

    /**
     * Find and return the Category by given id if exists, returns null otherwise.
     *
     * @param categoryId The id of the Category to get; value cannot be null.
     * @return Category associated with the given categoryId.
     */
    Category findById(String categoryId);

	/**
     * Find and return the list of Categories by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param categoryIds The id's of the Category to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Categories associated with the given categoryIds.
     */
    List<Category> findByMultipleIds(List<String> categoryIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Category. It replaces all fields of the existing Category with the given category.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Category if any.
     *
     * @param category The details of the Category to be updated; value cannot be null.
     * @return The updated Category.
     * @throws EntityNotFoundException if no Category is found with given input.
     */
    Category update(@Valid Category category);

    /**
     * Deletes an existing Category with the given id.
     *
     * @param categoryId The id of the Category to be deleted; value cannot be null.
     * @return The deleted Category.
     * @throws EntityNotFoundException if no Category found with the given id.
     */
    Category delete(String categoryId);

    /**
     * Deletes an existing Category with the given object.
     *
     * @param category The instance of the Category to be deleted; value cannot be null.
     */
    void delete(Category category);

    /**
     * Find all Categories matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Categories.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Category> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Categories matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Categories.
     *
     * @see Pageable
     * @see Page
     */
    Page<Category> findAll(String query, Pageable pageable);

    /**
     * Exports all Categories matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all Categories matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the Categories in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Category.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated productTests for given Category id.
     *
     * @param catrgory value of catrgory; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated ProductTest instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<ProductTest> findAssociatedProductTests(String catrgory, Pageable pageable);

    /*
     * Returns the associated subCategories for given Category id.
     *
     * @param catrgory value of catrgory; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated SubCategory instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<SubCategory> findAssociatedSubCategories(String catrgory, Pageable pageable);

}