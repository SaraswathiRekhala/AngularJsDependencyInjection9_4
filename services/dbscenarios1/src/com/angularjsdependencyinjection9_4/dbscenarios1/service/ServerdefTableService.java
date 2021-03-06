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

import com.angularjsdependencyinjection9_4.dbscenarios1.ServerdefTable;

/**
 * Service object for domain model class {@link ServerdefTable}.
 */
public interface ServerdefTableService {

    /**
     * Creates a new ServerdefTable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ServerdefTable if any.
     *
     * @param serverdefTable Details of the ServerdefTable to be created; value cannot be null.
     * @return The newly created ServerdefTable.
     */
    ServerdefTable create(@Valid ServerdefTable serverdefTable);


	/**
     * Returns ServerdefTable by given id if exists.
     *
     * @param serverdeftableId The id of the ServerdefTable to get; value cannot be null.
     * @return ServerdefTable associated with the given serverdeftableId.
	 * @throws EntityNotFoundException If no ServerdefTable is found.
     */
    ServerdefTable getById(Integer serverdeftableId);

    /**
     * Find and return the ServerdefTable by given id if exists, returns null otherwise.
     *
     * @param serverdeftableId The id of the ServerdefTable to get; value cannot be null.
     * @return ServerdefTable associated with the given serverdeftableId.
     */
    ServerdefTable findById(Integer serverdeftableId);

	/**
     * Find and return the list of ServerdefTables by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param serverdeftableIds The id's of the ServerdefTable to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return ServerdefTables associated with the given serverdeftableIds.
     */
    List<ServerdefTable> findByMultipleIds(List<Integer> serverdeftableIds, boolean orderedReturn);


    /**
     * Updates the details of an existing ServerdefTable. It replaces all fields of the existing ServerdefTable with the given serverdefTable.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ServerdefTable if any.
     *
     * @param serverdefTable The details of the ServerdefTable to be updated; value cannot be null.
     * @return The updated ServerdefTable.
     * @throws EntityNotFoundException if no ServerdefTable is found with given input.
     */
    ServerdefTable update(@Valid ServerdefTable serverdefTable);

    /**
     * Deletes an existing ServerdefTable with the given id.
     *
     * @param serverdeftableId The id of the ServerdefTable to be deleted; value cannot be null.
     * @return The deleted ServerdefTable.
     * @throws EntityNotFoundException if no ServerdefTable found with the given id.
     */
    ServerdefTable delete(Integer serverdeftableId);

    /**
     * Deletes an existing ServerdefTable with the given object.
     *
     * @param serverdefTable The instance of the ServerdefTable to be deleted; value cannot be null.
     */
    void delete(ServerdefTable serverdefTable);

    /**
     * Find all ServerdefTables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ServerdefTables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<ServerdefTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all ServerdefTables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ServerdefTables.
     *
     * @see Pageable
     * @see Page
     */
    Page<ServerdefTable> findAll(String query, Pageable pageable);

    /**
     * Exports all ServerdefTables matching the given input query to the given exportType format.
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
     * Exports all ServerdefTables matching the given input query to the given exportType format.
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
     * Retrieve the count of the ServerdefTables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the ServerdefTable.
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