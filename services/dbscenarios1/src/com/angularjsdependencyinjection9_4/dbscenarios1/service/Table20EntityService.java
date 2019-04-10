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

import com.angularjsdependencyinjection9_4.dbscenarios1.Table20Entity;

/**
 * Service object for domain model class {@link Table20Entity}.
 */
public interface Table20EntityService {

    /**
     * Creates a new Table20Entity. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table20Entity if any.
     *
     * @param table20entity Details of the Table20Entity to be created; value cannot be null.
     * @return The newly created Table20Entity.
     */
    Table20Entity create(@Valid Table20Entity table20entity);


	/**
     * Returns Table20Entity by given id if exists.
     *
     * @param table20entityId The id of the Table20Entity to get; value cannot be null.
     * @return Table20Entity associated with the given table20entityId.
	 * @throws EntityNotFoundException If no Table20Entity is found.
     */
    Table20Entity getById(Integer table20entityId);

    /**
     * Find and return the Table20Entity by given id if exists, returns null otherwise.
     *
     * @param table20entityId The id of the Table20Entity to get; value cannot be null.
     * @return Table20Entity associated with the given table20entityId.
     */
    Table20Entity findById(Integer table20entityId);

	/**
     * Find and return the list of Table20Entities by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param table20entityIds The id's of the Table20Entity to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Table20Entities associated with the given table20entityIds.
     */
    List<Table20Entity> findByMultipleIds(List<Integer> table20entityIds, boolean orderedReturn);

    /**
     * Find and return the Table20Entity for given lastName  if exists.
     *
     * @param lastName value of lastName; value cannot be null.
     * @return Table20Entity associated with the given inputs.
     * @throws EntityNotFoundException if no matching Table20Entity found.
     */
    Table20Entity getByLastName(String lastName);

    /**
     * Updates the details of an existing Table20Entity. It replaces all fields of the existing Table20Entity with the given table20entity.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table20Entity if any.
     *
     * @param table20entity The details of the Table20Entity to be updated; value cannot be null.
     * @return The updated Table20Entity.
     * @throws EntityNotFoundException if no Table20Entity is found with given input.
     */
    Table20Entity update(@Valid Table20Entity table20entity);

    /**
     * Deletes an existing Table20Entity with the given id.
     *
     * @param table20entityId The id of the Table20Entity to be deleted; value cannot be null.
     * @return The deleted Table20Entity.
     * @throws EntityNotFoundException if no Table20Entity found with the given id.
     */
    Table20Entity delete(Integer table20entityId);

    /**
     * Deletes an existing Table20Entity with the given object.
     *
     * @param table20entity The instance of the Table20Entity to be deleted; value cannot be null.
     */
    void delete(Table20Entity table20entity);

    /**
     * Find all Table20Entities matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table20Entities.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Table20Entity> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Table20Entities matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table20Entities.
     *
     * @see Pageable
     * @see Page
     */
    Page<Table20Entity> findAll(String query, Pageable pageable);

    /**
     * Exports all Table20Entities matching the given input query to the given exportType format.
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
     * Exports all Table20Entities matching the given input query to the given exportType format.
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
     * Retrieve the count of the Table20Entities in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Table20Entity.
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