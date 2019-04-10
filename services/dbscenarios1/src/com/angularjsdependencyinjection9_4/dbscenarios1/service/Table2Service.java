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

import com.angularjsdependencyinjection9_4.dbscenarios1.Table2;

/**
 * Service object for domain model class {@link Table2}.
 */
public interface Table2Service {

    /**
     * Creates a new Table2. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table2 if any.
     *
     * @param table2 Details of the Table2 to be created; value cannot be null.
     * @return The newly created Table2.
     */
    Table2 create(@Valid Table2 table2);


	/**
     * Returns Table2 by given id if exists.
     *
     * @param table2Id The id of the Table2 to get; value cannot be null.
     * @return Table2 associated with the given table2Id.
	 * @throws EntityNotFoundException If no Table2 is found.
     */
    Table2 getById(Integer table2Id);

    /**
     * Find and return the Table2 by given id if exists, returns null otherwise.
     *
     * @param table2Id The id of the Table2 to get; value cannot be null.
     * @return Table2 associated with the given table2Id.
     */
    Table2 findById(Integer table2Id);

	/**
     * Find and return the list of Table2s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param table2Ids The id's of the Table2 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Table2s associated with the given table2Ids.
     */
    List<Table2> findByMultipleIds(List<Integer> table2Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing Table2. It replaces all fields of the existing Table2 with the given table2.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table2 if any.
     *
     * @param table2 The details of the Table2 to be updated; value cannot be null.
     * @return The updated Table2.
     * @throws EntityNotFoundException if no Table2 is found with given input.
     */
    Table2 update(@Valid Table2 table2);

    /**
     * Deletes an existing Table2 with the given id.
     *
     * @param table2Id The id of the Table2 to be deleted; value cannot be null.
     * @return The deleted Table2.
     * @throws EntityNotFoundException if no Table2 found with the given id.
     */
    Table2 delete(Integer table2Id);

    /**
     * Deletes an existing Table2 with the given object.
     *
     * @param table2 The instance of the Table2 to be deleted; value cannot be null.
     */
    void delete(Table2 table2);

    /**
     * Find all Table2s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table2s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Table2> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Table2s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table2s.
     *
     * @see Pageable
     * @see Page
     */
    Page<Table2> findAll(String query, Pageable pageable);

    /**
     * Exports all Table2s matching the given input query to the given exportType format.
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
     * Exports all Table2s matching the given input query to the given exportType format.
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
     * Retrieve the count of the Table2s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Table2.
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