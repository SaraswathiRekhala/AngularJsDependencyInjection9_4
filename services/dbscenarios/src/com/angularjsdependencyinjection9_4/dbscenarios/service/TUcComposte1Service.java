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

import com.angularjsdependencyinjection9_4.dbscenarios.TUcComposte1;

/**
 * Service object for domain model class {@link TUcComposte1}.
 */
public interface TUcComposte1Service {

    /**
     * Creates a new TUcComposte1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TUcComposte1 if any.
     *
     * @param tucComposte1 Details of the TUcComposte1 to be created; value cannot be null.
     * @return The newly created TUcComposte1.
     */
    TUcComposte1 create(@Valid TUcComposte1 tucComposte1);


	/**
     * Returns TUcComposte1 by given id if exists.
     *
     * @param tuccomposte1Id The id of the TUcComposte1 to get; value cannot be null.
     * @return TUcComposte1 associated with the given tuccomposte1Id.
	 * @throws EntityNotFoundException If no TUcComposte1 is found.
     */
    TUcComposte1 getById(Integer tuccomposte1Id);

    /**
     * Find and return the TUcComposte1 by given id if exists, returns null otherwise.
     *
     * @param tuccomposte1Id The id of the TUcComposte1 to get; value cannot be null.
     * @return TUcComposte1 associated with the given tuccomposte1Id.
     */
    TUcComposte1 findById(Integer tuccomposte1Id);

	/**
     * Find and return the list of TUcComposte1s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param tuccomposte1Ids The id's of the TUcComposte1 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return TUcComposte1s associated with the given tuccomposte1Ids.
     */
    List<TUcComposte1> findByMultipleIds(List<Integer> tuccomposte1Ids, boolean orderedReturn);

    /**
     * Find and return the TUcComposte1 for given byteCol  andstringCol  if exists.
     *
     * @param byteCol value of byteCol; value cannot be null.
     * @param stringCol value of stringCol; value cannot be null.
     * @return TUcComposte1 associated with the given inputs.
     * @throws EntityNotFoundException if no matching TUcComposte1 found.
     */
    TUcComposte1 getByByteColAndStringCol(Short byteCol, String stringCol);

    /**
     * Find and return the TUcComposte1 for given longCol  andbigintCol  andcharCol  if exists.
     *
     * @param longCol value of longCol; value cannot be null.
     * @param bigintCol value of bigintCol; value cannot be null.
     * @param charCol value of charCol; value cannot be null.
     * @return TUcComposte1 associated with the given inputs.
     * @throws EntityNotFoundException if no matching TUcComposte1 found.
     */
    TUcComposte1 getByLongColAndBigintColAndCharCol(Long longCol, Long bigintCol, String charCol);

    /**
     * Updates the details of an existing TUcComposte1. It replaces all fields of the existing TUcComposte1 with the given tucComposte1.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TUcComposte1 if any.
     *
     * @param tucComposte1 The details of the TUcComposte1 to be updated; value cannot be null.
     * @return The updated TUcComposte1.
     * @throws EntityNotFoundException if no TUcComposte1 is found with given input.
     */
    TUcComposte1 update(@Valid TUcComposte1 tucComposte1);

    /**
     * Deletes an existing TUcComposte1 with the given id.
     *
     * @param tuccomposte1Id The id of the TUcComposte1 to be deleted; value cannot be null.
     * @return The deleted TUcComposte1.
     * @throws EntityNotFoundException if no TUcComposte1 found with the given id.
     */
    TUcComposte1 delete(Integer tuccomposte1Id);

    /**
     * Deletes an existing TUcComposte1 with the given object.
     *
     * @param tucComposte1 The instance of the TUcComposte1 to be deleted; value cannot be null.
     */
    void delete(TUcComposte1 tucComposte1);

    /**
     * Find all TUcComposte1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TUcComposte1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<TUcComposte1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all TUcComposte1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TUcComposte1s.
     *
     * @see Pageable
     * @see Page
     */
    Page<TUcComposte1> findAll(String query, Pageable pageable);

    /**
     * Exports all TUcComposte1s matching the given input query to the given exportType format.
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
     * Exports all TUcComposte1s matching the given input query to the given exportType format.
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
     * Retrieve the count of the TUcComposte1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the TUcComposte1.
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