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

import com.angularjsdependencyinjection9_4.dbscenarios.VirtualOne2one;
import com.angularjsdependencyinjection9_4.dbscenarios.VirtualOne2oneId;

/**
 * Service object for domain model class {@link VirtualOne2one}.
 */
public interface VirtualOne2oneService {

    /**
     * Creates a new VirtualOne2one. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on VirtualOne2one if any.
     *
     * @param virtualOne2one Details of the VirtualOne2one to be created; value cannot be null.
     * @return The newly created VirtualOne2one.
     */
    VirtualOne2one create(@Valid VirtualOne2one virtualOne2one);


	/**
     * Returns VirtualOne2one by given id if exists.
     *
     * @param virtualone2oneId The id of the VirtualOne2one to get; value cannot be null.
     * @return VirtualOne2one associated with the given virtualone2oneId.
	 * @throws EntityNotFoundException If no VirtualOne2one is found.
     */
    VirtualOne2one getById(VirtualOne2oneId virtualone2oneId);

    /**
     * Find and return the VirtualOne2one by given id if exists, returns null otherwise.
     *
     * @param virtualone2oneId The id of the VirtualOne2one to get; value cannot be null.
     * @return VirtualOne2one associated with the given virtualone2oneId.
     */
    VirtualOne2one findById(VirtualOne2oneId virtualone2oneId);

	/**
     * Find and return the list of VirtualOne2ones by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param virtualone2oneIds The id's of the VirtualOne2one to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return VirtualOne2ones associated with the given virtualone2oneIds.
     */
    List<VirtualOne2one> findByMultipleIds(List<VirtualOne2oneId> virtualone2oneIds, boolean orderedReturn);


    /**
     * Updates the details of an existing VirtualOne2one. It replaces all fields of the existing VirtualOne2one with the given virtualOne2one.
     *
     * This method overrides the input field values using Server side or database managed properties defined on VirtualOne2one if any.
     *
     * @param virtualOne2one The details of the VirtualOne2one to be updated; value cannot be null.
     * @return The updated VirtualOne2one.
     * @throws EntityNotFoundException if no VirtualOne2one is found with given input.
     */
    VirtualOne2one update(@Valid VirtualOne2one virtualOne2one);

    /**
     * Deletes an existing VirtualOne2one with the given id.
     *
     * @param virtualone2oneId The id of the VirtualOne2one to be deleted; value cannot be null.
     * @return The deleted VirtualOne2one.
     * @throws EntityNotFoundException if no VirtualOne2one found with the given id.
     */
    VirtualOne2one delete(VirtualOne2oneId virtualone2oneId);

    /**
     * Deletes an existing VirtualOne2one with the given object.
     *
     * @param virtualOne2one The instance of the VirtualOne2one to be deleted; value cannot be null.
     */
    void delete(VirtualOne2one virtualOne2one);

    /**
     * Find all VirtualOne2ones matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching VirtualOne2ones.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<VirtualOne2one> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all VirtualOne2ones matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching VirtualOne2ones.
     *
     * @see Pageable
     * @see Page
     */
    Page<VirtualOne2one> findAll(String query, Pageable pageable);

    /**
     * Exports all VirtualOne2ones matching the given input query to the given exportType format.
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
     * Exports all VirtualOne2ones matching the given input query to the given exportType format.
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
     * Retrieve the count of the VirtualOne2ones in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the VirtualOne2one.
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