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

import com.angularjsdependencyinjection9_4.dbscenarios.ServerDefined;

/**
 * Service object for domain model class {@link ServerDefined}.
 */
public interface ServerDefinedService {

    /**
     * Creates a new ServerDefined. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ServerDefined if any.
     *
     * @param serverDefined Details of the ServerDefined to be created; value cannot be null.
     * @return The newly created ServerDefined.
     */
    ServerDefined create(@Valid ServerDefined serverDefined);


	/**
     * Returns ServerDefined by given id if exists.
     *
     * @param serverdefinedId The id of the ServerDefined to get; value cannot be null.
     * @return ServerDefined associated with the given serverdefinedId.
	 * @throws EntityNotFoundException If no ServerDefined is found.
     */
    ServerDefined getById(Integer serverdefinedId);

    /**
     * Find and return the ServerDefined by given id if exists, returns null otherwise.
     *
     * @param serverdefinedId The id of the ServerDefined to get; value cannot be null.
     * @return ServerDefined associated with the given serverdefinedId.
     */
    ServerDefined findById(Integer serverdefinedId);

	/**
     * Find and return the list of ServerDefineds by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param serverdefinedIds The id's of the ServerDefined to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return ServerDefineds associated with the given serverdefinedIds.
     */
    List<ServerDefined> findByMultipleIds(List<Integer> serverdefinedIds, boolean orderedReturn);


    /**
     * Updates the details of an existing ServerDefined. It replaces all fields of the existing ServerDefined with the given serverDefined.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ServerDefined if any.
     *
     * @param serverDefined The details of the ServerDefined to be updated; value cannot be null.
     * @return The updated ServerDefined.
     * @throws EntityNotFoundException if no ServerDefined is found with given input.
     */
    ServerDefined update(@Valid ServerDefined serverDefined);

    /**
     * Deletes an existing ServerDefined with the given id.
     *
     * @param serverdefinedId The id of the ServerDefined to be deleted; value cannot be null.
     * @return The deleted ServerDefined.
     * @throws EntityNotFoundException if no ServerDefined found with the given id.
     */
    ServerDefined delete(Integer serverdefinedId);

    /**
     * Deletes an existing ServerDefined with the given object.
     *
     * @param serverDefined The instance of the ServerDefined to be deleted; value cannot be null.
     */
    void delete(ServerDefined serverDefined);

    /**
     * Find all ServerDefineds matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ServerDefineds.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<ServerDefined> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all ServerDefineds matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ServerDefineds.
     *
     * @see Pageable
     * @see Page
     */
    Page<ServerDefined> findAll(String query, Pageable pageable);

    /**
     * Exports all ServerDefineds matching the given input query to the given exportType format.
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
     * Exports all ServerDefineds matching the given input query to the given exportType format.
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
     * Retrieve the count of the ServerDefineds in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the ServerDefined.
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