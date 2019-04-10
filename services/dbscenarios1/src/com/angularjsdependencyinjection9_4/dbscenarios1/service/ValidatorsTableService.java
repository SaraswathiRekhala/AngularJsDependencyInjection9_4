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

import com.angularjsdependencyinjection9_4.dbscenarios1.ValidatorsTable;

/**
 * Service object for domain model class {@link ValidatorsTable}.
 */
public interface ValidatorsTableService {

    /**
     * Creates a new ValidatorsTable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ValidatorsTable if any.
     *
     * @param validatorsTable Details of the ValidatorsTable to be created; value cannot be null.
     * @return The newly created ValidatorsTable.
     */
    ValidatorsTable create(@Valid ValidatorsTable validatorsTable);


	/**
     * Returns ValidatorsTable by given id if exists.
     *
     * @param validatorstableId The id of the ValidatorsTable to get; value cannot be null.
     * @return ValidatorsTable associated with the given validatorstableId.
	 * @throws EntityNotFoundException If no ValidatorsTable is found.
     */
    ValidatorsTable getById(Integer validatorstableId);

    /**
     * Find and return the ValidatorsTable by given id if exists, returns null otherwise.
     *
     * @param validatorstableId The id of the ValidatorsTable to get; value cannot be null.
     * @return ValidatorsTable associated with the given validatorstableId.
     */
    ValidatorsTable findById(Integer validatorstableId);

	/**
     * Find and return the list of ValidatorsTables by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param validatorstableIds The id's of the ValidatorsTable to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return ValidatorsTables associated with the given validatorstableIds.
     */
    List<ValidatorsTable> findByMultipleIds(List<Integer> validatorstableIds, boolean orderedReturn);


    /**
     * Updates the details of an existing ValidatorsTable. It replaces all fields of the existing ValidatorsTable with the given validatorsTable.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ValidatorsTable if any.
     *
     * @param validatorsTable The details of the ValidatorsTable to be updated; value cannot be null.
     * @return The updated ValidatorsTable.
     * @throws EntityNotFoundException if no ValidatorsTable is found with given input.
     */
    ValidatorsTable update(@Valid ValidatorsTable validatorsTable);

    /**
     * Deletes an existing ValidatorsTable with the given id.
     *
     * @param validatorstableId The id of the ValidatorsTable to be deleted; value cannot be null.
     * @return The deleted ValidatorsTable.
     * @throws EntityNotFoundException if no ValidatorsTable found with the given id.
     */
    ValidatorsTable delete(Integer validatorstableId);

    /**
     * Deletes an existing ValidatorsTable with the given object.
     *
     * @param validatorsTable The instance of the ValidatorsTable to be deleted; value cannot be null.
     */
    void delete(ValidatorsTable validatorsTable);

    /**
     * Find all ValidatorsTables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ValidatorsTables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<ValidatorsTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all ValidatorsTables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ValidatorsTables.
     *
     * @see Pageable
     * @see Page
     */
    Page<ValidatorsTable> findAll(String query, Pageable pageable);

    /**
     * Exports all ValidatorsTables matching the given input query to the given exportType format.
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
     * Exports all ValidatorsTables matching the given input query to the given exportType format.
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
     * Retrieve the count of the ValidatorsTables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the ValidatorsTable.
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