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

import com.angularjsdependencyinjection9_4.dbscenarios1.SampleTable2;

/**
 * Service object for domain model class {@link SampleTable2}.
 */
public interface SampleTable2Service {

    /**
     * Creates a new SampleTable2. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SampleTable2 if any.
     *
     * @param sampleTable2 Details of the SampleTable2 to be created; value cannot be null.
     * @return The newly created SampleTable2.
     */
    SampleTable2 create(@Valid SampleTable2 sampleTable2);


	/**
     * Returns SampleTable2 by given id if exists.
     *
     * @param sampletable2Id The id of the SampleTable2 to get; value cannot be null.
     * @return SampleTable2 associated with the given sampletable2Id.
	 * @throws EntityNotFoundException If no SampleTable2 is found.
     */
    SampleTable2 getById(Integer sampletable2Id);

    /**
     * Find and return the SampleTable2 by given id if exists, returns null otherwise.
     *
     * @param sampletable2Id The id of the SampleTable2 to get; value cannot be null.
     * @return SampleTable2 associated with the given sampletable2Id.
     */
    SampleTable2 findById(Integer sampletable2Id);

	/**
     * Find and return the list of SampleTable2s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param sampletable2Ids The id's of the SampleTable2 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return SampleTable2s associated with the given sampletable2Ids.
     */
    List<SampleTable2> findByMultipleIds(List<Integer> sampletable2Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing SampleTable2. It replaces all fields of the existing SampleTable2 with the given sampleTable2.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SampleTable2 if any.
     *
     * @param sampleTable2 The details of the SampleTable2 to be updated; value cannot be null.
     * @return The updated SampleTable2.
     * @throws EntityNotFoundException if no SampleTable2 is found with given input.
     */
    SampleTable2 update(@Valid SampleTable2 sampleTable2);

    /**
     * Deletes an existing SampleTable2 with the given id.
     *
     * @param sampletable2Id The id of the SampleTable2 to be deleted; value cannot be null.
     * @return The deleted SampleTable2.
     * @throws EntityNotFoundException if no SampleTable2 found with the given id.
     */
    SampleTable2 delete(Integer sampletable2Id);

    /**
     * Deletes an existing SampleTable2 with the given object.
     *
     * @param sampleTable2 The instance of the SampleTable2 to be deleted; value cannot be null.
     */
    void delete(SampleTable2 sampleTable2);

    /**
     * Find all SampleTable2s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SampleTable2s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<SampleTable2> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all SampleTable2s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SampleTable2s.
     *
     * @see Pageable
     * @see Page
     */
    Page<SampleTable2> findAll(String query, Pageable pageable);

    /**
     * Exports all SampleTable2s matching the given input query to the given exportType format.
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
     * Exports all SampleTable2s matching the given input query to the given exportType format.
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
     * Retrieve the count of the SampleTable2s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the SampleTable2.
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