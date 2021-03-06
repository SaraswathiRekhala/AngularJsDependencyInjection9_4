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

import com.angularjsdependencyinjection9_4.dbscenarios1.ProductTest;
import com.angularjsdependencyinjection9_4.dbscenarios1.SubCategory;

/**
 * Service object for domain model class {@link SubCategory}.
 */
public interface SubCategoryService {

    /**
     * Creates a new SubCategory. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SubCategory if any.
     *
     * @param subCategory Details of the SubCategory to be created; value cannot be null.
     * @return The newly created SubCategory.
     */
    SubCategory create(@Valid SubCategory subCategory);


	/**
     * Returns SubCategory by given id if exists.
     *
     * @param subcategoryId The id of the SubCategory to get; value cannot be null.
     * @return SubCategory associated with the given subcategoryId.
	 * @throws EntityNotFoundException If no SubCategory is found.
     */
    SubCategory getById(String subcategoryId);

    /**
     * Find and return the SubCategory by given id if exists, returns null otherwise.
     *
     * @param subcategoryId The id of the SubCategory to get; value cannot be null.
     * @return SubCategory associated with the given subcategoryId.
     */
    SubCategory findById(String subcategoryId);

	/**
     * Find and return the list of SubCategories by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param subcategoryIds The id's of the SubCategory to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return SubCategories associated with the given subcategoryIds.
     */
    List<SubCategory> findByMultipleIds(List<String> subcategoryIds, boolean orderedReturn);


    /**
     * Updates the details of an existing SubCategory. It replaces all fields of the existing SubCategory with the given subCategory.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SubCategory if any.
     *
     * @param subCategory The details of the SubCategory to be updated; value cannot be null.
     * @return The updated SubCategory.
     * @throws EntityNotFoundException if no SubCategory is found with given input.
     */
    SubCategory update(@Valid SubCategory subCategory);

    /**
     * Deletes an existing SubCategory with the given id.
     *
     * @param subcategoryId The id of the SubCategory to be deleted; value cannot be null.
     * @return The deleted SubCategory.
     * @throws EntityNotFoundException if no SubCategory found with the given id.
     */
    SubCategory delete(String subcategoryId);

    /**
     * Deletes an existing SubCategory with the given object.
     *
     * @param subCategory The instance of the SubCategory to be deleted; value cannot be null.
     */
    void delete(SubCategory subCategory);

    /**
     * Find all SubCategories matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubCategories.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<SubCategory> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all SubCategories matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubCategories.
     *
     * @see Pageable
     * @see Page
     */
    Page<SubCategory> findAll(String query, Pageable pageable);

    /**
     * Exports all SubCategories matching the given input query to the given exportType format.
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
     * Exports all SubCategories matching the given input query to the given exportType format.
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
     * Retrieve the count of the SubCategories in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the SubCategory.
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
     * Returns the associated productTests for given SubCategory id.
     *
     * @param subcategory value of subcategory; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated ProductTest instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<ProductTest> findAssociatedProductTests(String subcategory, Pageable pageable);

}