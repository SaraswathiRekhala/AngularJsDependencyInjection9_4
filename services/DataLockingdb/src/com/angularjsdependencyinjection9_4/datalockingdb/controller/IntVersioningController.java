/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.datalockingdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.angularjsdependencyinjection9_4.datalockingdb.IntVersioning;
import com.angularjsdependencyinjection9_4.datalockingdb.service.IntVersioningService;


/**
 * Controller object for domain model class IntVersioning.
 * @see IntVersioning
 */
@RestController("DataLockingdb.IntVersioningController")
@Api(value = "IntVersioningController", description = "Exposes APIs to work with IntVersioning resource.")
@RequestMapping("/DataLockingdb/IntVersioning")
public class IntVersioningController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntVersioningController.class);

    @Autowired
	@Qualifier("DataLockingdb.IntVersioningService")
	private IntVersioningService intVersioningService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new IntVersioning instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IntVersioning createIntVersioning(@RequestBody IntVersioning intVersioning) {
		LOGGER.debug("Create IntVersioning with information: {}" , intVersioning);

		intVersioning = intVersioningService.create(intVersioning);
		LOGGER.debug("Created IntVersioning with information: {}" , intVersioning);

	    return intVersioning;
	}

    @ApiOperation(value = "Returns the IntVersioning instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IntVersioning getIntVersioning(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting IntVersioning with id: {}" , id);

        IntVersioning foundIntVersioning = intVersioningService.getById(id);
        LOGGER.debug("IntVersioning details with id: {}" , foundIntVersioning);

        return foundIntVersioning;
    }

    @ApiOperation(value = "Updates the IntVersioning instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IntVersioning editIntVersioning(@PathVariable("id") Integer id, @RequestBody IntVersioning intVersioning) {
        LOGGER.debug("Editing IntVersioning with id: {}" , intVersioning.getId());

        intVersioning.setId(id);
        intVersioning = intVersioningService.update(intVersioning);
        LOGGER.debug("IntVersioning details with id: {}" , intVersioning);

        return intVersioning;
    }

    @ApiOperation(value = "Deletes the IntVersioning instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteIntVersioning(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting IntVersioning with id: {}" , id);

        IntVersioning deletedIntVersioning = intVersioningService.delete(id);

        return deletedIntVersioning != null;
    }

    /**
     * @deprecated Use {@link #findIntVersionings(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of IntVersioning instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IntVersioning> searchIntVersioningsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering IntVersionings list by query filter:{}", (Object) queryFilters);
        return intVersioningService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of IntVersioning instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IntVersioning> findIntVersionings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering IntVersionings list by filter:", query);
        return intVersioningService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of IntVersioning instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IntVersioning> filterIntVersionings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering IntVersionings list by filter", query);
        return intVersioningService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportIntVersionings(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return intVersioningService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportIntVersioningsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = IntVersioning.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> intVersioningService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of IntVersioning instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countIntVersionings( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting IntVersionings");
		return intVersioningService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getIntVersioningAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return intVersioningService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service IntVersioningService instance
	 */
	protected void setIntVersioningService(IntVersioningService service) {
		this.intVersioningService = service;
	}

}