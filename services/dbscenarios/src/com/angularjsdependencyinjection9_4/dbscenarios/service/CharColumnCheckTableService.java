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

import com.angularjsdependencyinjection9_4.dbscenarios.CharColumnCheckTable;
import com.angularjsdependencyinjection9_4.dbscenarios.CharColumnCheckTableId;

/**
 * Service object for domain model class {@link CharColumnCheckTable}.
 */
public interface CharColumnCheckTableService {

    /**
     * Creates a new CharColumnCheckTable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CharColumnCheckTable if any.
     *
     * @param charColumnCheckTable Details of the CharColumnCheckTable to be created; value cannot be null.
     * @return The newly created CharColumnCheckTable.
     */
    CharColumnCheckTable create(@Valid CharColumnCheckTable charColumnCheckTable);


	/**
     * Returns CharColumnCheckTable by given id if exists.
     *
     * @param charcolumnchecktableId The id of the CharColumnCheckTable to get; value cannot be null.
     * @return CharColumnCheckTable associated with the given charcolumnchecktableId.
	 * @throws EntityNotFoundException If no CharColumnCheckTable is found.
     */
    CharColumnCheckTable getById(CharColumnCheckTableId charcolumnchecktableId);

    /**
     * Find and return the CharColumnCheckTable by given id if exists, returns null otherwise.
     *
     * @param charcolumnchecktableId The id of the CharColumnCheckTable to get; value cannot be null.
     * @return CharColumnCheckTable associated with the given charcolumnchecktableId.
     */
    CharColumnCheckTable findById(CharColumnCheckTableId charcolumnchecktableId);

	/**
     * Find and return the list of CharColumnCheckTables by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param charcolumnchecktableIds The id's of the CharColumnCheckTable to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return CharColumnCheckTables associated with the given charcolumnchecktableIds.
     */
    List<CharColumnCheckTable> findByMultipleIds(List<CharColumnCheckTableId> charcolumnchecktableIds, boolean orderedReturn);


    /**
     * Updates the details of an existing CharColumnCheckTable. It replaces all fields of the existing CharColumnCheckTable with the given charColumnCheckTable.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CharColumnCheckTable if any.
     *
     * @param charColumnCheckTable The details of the CharColumnCheckTable to be updated; value cannot be null.
     * @return The updated CharColumnCheckTable.
     * @throws EntityNotFoundException if no CharColumnCheckTable is found with given input.
     */
    CharColumnCheckTable update(@Valid CharColumnCheckTable charColumnCheckTable);

    /**
     * Deletes an existing CharColumnCheckTable with the given id.
     *
     * @param charcolumnchecktableId The id of the CharColumnCheckTable to be deleted; value cannot be null.
     * @return The deleted CharColumnCheckTable.
     * @throws EntityNotFoundException if no CharColumnCheckTable found with the given id.
     */
    CharColumnCheckTable delete(CharColumnCheckTableId charcolumnchecktableId);

    /**
     * Deletes an existing CharColumnCheckTable with the given object.
     *
     * @param charColumnCheckTable The instance of the CharColumnCheckTable to be deleted; value cannot be null.
     */
    void delete(CharColumnCheckTable charColumnCheckTable);

    /**
     * Find all CharColumnCheckTables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CharColumnCheckTables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<CharColumnCheckTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all CharColumnCheckTables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CharColumnCheckTables.
     *
     * @see Pageable
     * @see Page
     */
    Page<CharColumnCheckTable> findAll(String query, Pageable pageable);

    /**
     * Exports all CharColumnCheckTables matching the given input query to the given exportType format.
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
     * Exports all CharColumnCheckTables matching the given input query to the given exportType format.
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
     * Retrieve the count of the CharColumnCheckTables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the CharColumnCheckTable.
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