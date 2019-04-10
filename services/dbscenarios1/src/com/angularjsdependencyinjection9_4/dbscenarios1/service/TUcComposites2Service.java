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

import com.angularjsdependencyinjection9_4.dbscenarios1.TUcComposites2;
import com.angularjsdependencyinjection9_4.dbscenarios1.TUcComposites2Id;

/**
 * Service object for domain model class {@link TUcComposites2}.
 */
public interface TUcComposites2Service {

    /**
     * Creates a new TUcComposites2. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TUcComposites2 if any.
     *
     * @param tucComposites2 Details of the TUcComposites2 to be created; value cannot be null.
     * @return The newly created TUcComposites2.
     */
    TUcComposites2 create(@Valid TUcComposites2 tucComposites2);


	/**
     * Returns TUcComposites2 by given id if exists.
     *
     * @param tuccomposites2Id The id of the TUcComposites2 to get; value cannot be null.
     * @return TUcComposites2 associated with the given tuccomposites2Id.
	 * @throws EntityNotFoundException If no TUcComposites2 is found.
     */
    TUcComposites2 getById(TUcComposites2Id tuccomposites2Id);

    /**
     * Find and return the TUcComposites2 by given id if exists, returns null otherwise.
     *
     * @param tuccomposites2Id The id of the TUcComposites2 to get; value cannot be null.
     * @return TUcComposites2 associated with the given tuccomposites2Id.
     */
    TUcComposites2 findById(TUcComposites2Id tuccomposites2Id);

	/**
     * Find and return the list of TUcComposites2s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param tuccomposites2Ids The id's of the TUcComposites2 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return TUcComposites2s associated with the given tuccomposites2Ids.
     */
    List<TUcComposites2> findByMultipleIds(List<TUcComposites2Id> tuccomposites2Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing TUcComposites2. It replaces all fields of the existing TUcComposites2 with the given tucComposites2.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TUcComposites2 if any.
     *
     * @param tucComposites2 The details of the TUcComposites2 to be updated; value cannot be null.
     * @return The updated TUcComposites2.
     * @throws EntityNotFoundException if no TUcComposites2 is found with given input.
     */
    TUcComposites2 update(@Valid TUcComposites2 tucComposites2);

    /**
     * Deletes an existing TUcComposites2 with the given id.
     *
     * @param tuccomposites2Id The id of the TUcComposites2 to be deleted; value cannot be null.
     * @return The deleted TUcComposites2.
     * @throws EntityNotFoundException if no TUcComposites2 found with the given id.
     */
    TUcComposites2 delete(TUcComposites2Id tuccomposites2Id);

    /**
     * Deletes an existing TUcComposites2 with the given object.
     *
     * @param tucComposites2 The instance of the TUcComposites2 to be deleted; value cannot be null.
     */
    void delete(TUcComposites2 tucComposites2);

    /**
     * Find all TUcComposites2s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TUcComposites2s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<TUcComposites2> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all TUcComposites2s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TUcComposites2s.
     *
     * @see Pageable
     * @see Page
     */
    Page<TUcComposites2> findAll(String query, Pageable pageable);

    /**
     * Exports all TUcComposites2s matching the given input query to the given exportType format.
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
     * Exports all TUcComposites2s matching the given input query to the given exportType format.
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
     * Retrieve the count of the TUcComposites2s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the TUcComposites2.
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