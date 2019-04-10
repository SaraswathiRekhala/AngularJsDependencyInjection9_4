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

import com.angularjsdependencyinjection9_4.dbscenarios.TMany2oneC;
import com.angularjsdependencyinjection9_4.dbscenarios.TMany2oneP;

/**
 * Service object for domain model class {@link TMany2oneC}.
 */
public interface TMany2oneCService {

    /**
     * Creates a new TMany2oneC. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TMany2oneC if any.
     *
     * @param tmany2oneC Details of the TMany2oneC to be created; value cannot be null.
     * @return The newly created TMany2oneC.
     */
    TMany2oneC create(@Valid TMany2oneC tmany2oneC);


	/**
     * Returns TMany2oneC by given id if exists.
     *
     * @param tmany2onecId The id of the TMany2oneC to get; value cannot be null.
     * @return TMany2oneC associated with the given tmany2onecId.
	 * @throws EntityNotFoundException If no TMany2oneC is found.
     */
    TMany2oneC getById(Integer tmany2onecId);

    /**
     * Find and return the TMany2oneC by given id if exists, returns null otherwise.
     *
     * @param tmany2onecId The id of the TMany2oneC to get; value cannot be null.
     * @return TMany2oneC associated with the given tmany2onecId.
     */
    TMany2oneC findById(Integer tmany2onecId);

	/**
     * Find and return the list of TMany2oneCs by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param tmany2onecIds The id's of the TMany2oneC to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return TMany2oneCs associated with the given tmany2onecIds.
     */
    List<TMany2oneC> findByMultipleIds(List<Integer> tmany2onecIds, boolean orderedReturn);


    /**
     * Updates the details of an existing TMany2oneC. It replaces all fields of the existing TMany2oneC with the given tmany2oneC.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TMany2oneC if any.
     *
     * @param tmany2oneC The details of the TMany2oneC to be updated; value cannot be null.
     * @return The updated TMany2oneC.
     * @throws EntityNotFoundException if no TMany2oneC is found with given input.
     */
    TMany2oneC update(@Valid TMany2oneC tmany2oneC);

    /**
     * Deletes an existing TMany2oneC with the given id.
     *
     * @param tmany2onecId The id of the TMany2oneC to be deleted; value cannot be null.
     * @return The deleted TMany2oneC.
     * @throws EntityNotFoundException if no TMany2oneC found with the given id.
     */
    TMany2oneC delete(Integer tmany2onecId);

    /**
     * Deletes an existing TMany2oneC with the given object.
     *
     * @param tmany2oneC The instance of the TMany2oneC to be deleted; value cannot be null.
     */
    void delete(TMany2oneC tmany2oneC);

    /**
     * Find all TMany2oneCs matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TMany2oneCs.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<TMany2oneC> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all TMany2oneCs matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TMany2oneCs.
     *
     * @see Pageable
     * @see Page
     */
    Page<TMany2oneC> findAll(String query, Pageable pageable);

    /**
     * Exports all TMany2oneCs matching the given input query to the given exportType format.
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
     * Exports all TMany2oneCs matching the given input query to the given exportType format.
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
     * Retrieve the count of the TMany2oneCs in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the TMany2oneC.
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
     * Returns the associated tmany2onePs for given TMany2oneC id.
     *
     * @param bigintId value of bigintId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TMany2oneP instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TMany2oneP> findAssociatedTmany2onePs(Integer bigintId, Pageable pageable);

}