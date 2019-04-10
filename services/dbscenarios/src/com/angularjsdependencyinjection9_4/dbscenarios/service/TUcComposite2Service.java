/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios.service;

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

import com.angularjsdependencyinjection9_4.dbscenarios.TUcComposite2;
import com.angularjsdependencyinjection9_4.dbscenarios.TUcComposite2Id;

/**
 * Service object for domain model class {@link TUcComposite2}.
 */
public interface TUcComposite2Service {

    /**
     * Creates a new TUcComposite2. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TUcComposite2 if any.
     *
     * @param tucComposite2 Details of the TUcComposite2 to be created; value cannot be null.
     * @return The newly created TUcComposite2.
     */
    TUcComposite2 create(@Valid TUcComposite2 tucComposite2);


	/**
     * Returns TUcComposite2 by given id if exists.
     *
     * @param tuccomposite2Id The id of the TUcComposite2 to get; value cannot be null.
     * @return TUcComposite2 associated with the given tuccomposite2Id.
	 * @throws EntityNotFoundException If no TUcComposite2 is found.
     */
    TUcComposite2 getById(TUcComposite2Id tuccomposite2Id);

    /**
     * Find and return the TUcComposite2 by given id if exists, returns null otherwise.
     *
     * @param tuccomposite2Id The id of the TUcComposite2 to get; value cannot be null.
     * @return TUcComposite2 associated with the given tuccomposite2Id.
     */
    TUcComposite2 findById(TUcComposite2Id tuccomposite2Id);

	/**
     * Find and return the list of TUcComposite2s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param tuccomposite2Ids The id's of the TUcComposite2 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return TUcComposite2s associated with the given tuccomposite2Ids.
     */
    List<TUcComposite2> findByMultipleIds(List<TUcComposite2Id> tuccomposite2Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing TUcComposite2. It replaces all fields of the existing TUcComposite2 with the given tucComposite2.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TUcComposite2 if any.
     *
     * @param tucComposite2 The details of the TUcComposite2 to be updated; value cannot be null.
     * @return The updated TUcComposite2.
     * @throws EntityNotFoundException if no TUcComposite2 is found with given input.
     */
    TUcComposite2 update(@Valid TUcComposite2 tucComposite2);

    /**
     * Deletes an existing TUcComposite2 with the given id.
     *
     * @param tuccomposite2Id The id of the TUcComposite2 to be deleted; value cannot be null.
     * @return The deleted TUcComposite2.
     * @throws EntityNotFoundException if no TUcComposite2 found with the given id.
     */
    TUcComposite2 delete(TUcComposite2Id tuccomposite2Id);

    /**
     * Deletes an existing TUcComposite2 with the given object.
     *
     * @param tucComposite2 The instance of the TUcComposite2 to be deleted; value cannot be null.
     */
    void delete(TUcComposite2 tucComposite2);

    /**
     * Find all TUcComposite2s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TUcComposite2s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<TUcComposite2> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all TUcComposite2s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TUcComposite2s.
     *
     * @see Pageable
     * @see Page
     */
    Page<TUcComposite2> findAll(String query, Pageable pageable);

    /**
     * Exports all TUcComposite2s matching the given input query to the given exportType format.
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
     * Exports all TUcComposite2s matching the given input query to the given exportType format.
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
     * Retrieve the count of the TUcComposite2s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the TUcComposite2.
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