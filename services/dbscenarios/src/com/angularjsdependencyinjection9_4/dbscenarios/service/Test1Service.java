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

import com.angularjsdependencyinjection9_4.dbscenarios.Test1;

/**
 * Service object for domain model class {@link Test1}.
 */
public interface Test1Service {

    /**
     * Creates a new Test1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Test1 if any.
     *
     * @param test1 Details of the Test1 to be created; value cannot be null.
     * @return The newly created Test1.
     */
    Test1 create(@Valid Test1 test1);


	/**
     * Returns Test1 by given id if exists.
     *
     * @param test1Id The id of the Test1 to get; value cannot be null.
     * @return Test1 associated with the given test1Id.
	 * @throws EntityNotFoundException If no Test1 is found.
     */
    Test1 getById(Integer test1Id);

    /**
     * Find and return the Test1 by given id if exists, returns null otherwise.
     *
     * @param test1Id The id of the Test1 to get; value cannot be null.
     * @return Test1 associated with the given test1Id.
     */
    Test1 findById(Integer test1Id);

	/**
     * Find and return the list of Test1s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param test1Ids The id's of the Test1 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Test1s associated with the given test1Ids.
     */
    List<Test1> findByMultipleIds(List<Integer> test1Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing Test1. It replaces all fields of the existing Test1 with the given test1.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Test1 if any.
     *
     * @param test1 The details of the Test1 to be updated; value cannot be null.
     * @return The updated Test1.
     * @throws EntityNotFoundException if no Test1 is found with given input.
     */
    Test1 update(@Valid Test1 test1);

    /**
     * Deletes an existing Test1 with the given id.
     *
     * @param test1Id The id of the Test1 to be deleted; value cannot be null.
     * @return The deleted Test1.
     * @throws EntityNotFoundException if no Test1 found with the given id.
     */
    Test1 delete(Integer test1Id);

    /**
     * Deletes an existing Test1 with the given object.
     *
     * @param test1 The instance of the Test1 to be deleted; value cannot be null.
     */
    void delete(Test1 test1);

    /**
     * Find all Test1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Test1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Test1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Test1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Test1s.
     *
     * @see Pageable
     * @see Page
     */
    Page<Test1> findAll(String query, Pageable pageable);

    /**
     * Exports all Test1s matching the given input query to the given exportType format.
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
     * Exports all Test1s matching the given input query to the given exportType format.
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
     * Retrieve the count of the Test1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Test1.
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