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

import com.angularjsdependencyinjection9_4.dbscenarios1.TUcOne2oneParent;

/**
 * Service object for domain model class {@link TUcOne2oneParent}.
 */
public interface TUcOne2oneParentService {

    /**
     * Creates a new TUcOne2oneParent. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TUcOne2oneParent if any.
     *
     * @param tucOne2oneParent Details of the TUcOne2oneParent to be created; value cannot be null.
     * @return The newly created TUcOne2oneParent.
     */
    TUcOne2oneParent create(@Valid TUcOne2oneParent tucOne2oneParent);


	/**
     * Returns TUcOne2oneParent by given id if exists.
     *
     * @param tucone2oneparentId The id of the TUcOne2oneParent to get; value cannot be null.
     * @return TUcOne2oneParent associated with the given tucone2oneparentId.
	 * @throws EntityNotFoundException If no TUcOne2oneParent is found.
     */
    TUcOne2oneParent getById(Integer tucone2oneparentId);

    /**
     * Find and return the TUcOne2oneParent by given id if exists, returns null otherwise.
     *
     * @param tucone2oneparentId The id of the TUcOne2oneParent to get; value cannot be null.
     * @return TUcOne2oneParent associated with the given tucone2oneparentId.
     */
    TUcOne2oneParent findById(Integer tucone2oneparentId);

	/**
     * Find and return the list of TUcOne2oneParents by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param tucone2oneparentIds The id's of the TUcOne2oneParent to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return TUcOne2oneParents associated with the given tucone2oneparentIds.
     */
    List<TUcOne2oneParent> findByMultipleIds(List<Integer> tucone2oneparentIds, boolean orderedReturn);

    /**
     * Find and return the TUcOne2oneParent for given shortCol  if exists.
     *
     * @param shortCol value of shortCol; value cannot be null.
     * @return TUcOne2oneParent associated with the given inputs.
     * @throws EntityNotFoundException if no matching TUcOne2oneParent found.
     */
    TUcOne2oneParent getByShortCol(Short shortCol);

    /**
     * Updates the details of an existing TUcOne2oneParent. It replaces all fields of the existing TUcOne2oneParent with the given tucOne2oneParent.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TUcOne2oneParent if any.
     *
     * @param tucOne2oneParent The details of the TUcOne2oneParent to be updated; value cannot be null.
     * @return The updated TUcOne2oneParent.
     * @throws EntityNotFoundException if no TUcOne2oneParent is found with given input.
     */
    TUcOne2oneParent update(@Valid TUcOne2oneParent tucOne2oneParent);

    /**
     * Deletes an existing TUcOne2oneParent with the given id.
     *
     * @param tucone2oneparentId The id of the TUcOne2oneParent to be deleted; value cannot be null.
     * @return The deleted TUcOne2oneParent.
     * @throws EntityNotFoundException if no TUcOne2oneParent found with the given id.
     */
    TUcOne2oneParent delete(Integer tucone2oneparentId);

    /**
     * Deletes an existing TUcOne2oneParent with the given object.
     *
     * @param tucOne2oneParent The instance of the TUcOne2oneParent to be deleted; value cannot be null.
     */
    void delete(TUcOne2oneParent tucOne2oneParent);

    /**
     * Find all TUcOne2oneParents matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TUcOne2oneParents.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<TUcOne2oneParent> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all TUcOne2oneParents matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TUcOne2oneParents.
     *
     * @see Pageable
     * @see Page
     */
    Page<TUcOne2oneParent> findAll(String query, Pageable pageable);

    /**
     * Exports all TUcOne2oneParents matching the given input query to the given exportType format.
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
     * Exports all TUcOne2oneParents matching the given input query to the given exportType format.
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
     * Retrieve the count of the TUcOne2oneParents in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the TUcOne2oneParent.
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


}