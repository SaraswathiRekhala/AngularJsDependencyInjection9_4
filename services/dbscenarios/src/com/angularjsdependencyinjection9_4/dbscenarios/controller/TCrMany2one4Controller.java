/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.sql.Date;
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

import com.angularjsdependencyinjection9_4.dbscenarios.TCrMany2one4;
import com.angularjsdependencyinjection9_4.dbscenarios.service.TCrMany2one4Service;


/**
 * Controller object for domain model class TCrMany2one4.
 * @see TCrMany2one4
 */
@RestController("dbscenarios.TCrMany2one4Controller")
@Api(value = "TCrMany2one4Controller", description = "Exposes APIs to work with TCrMany2one4 resource.")
@RequestMapping("/dbscenarios/TCrMany2one4")
public class TCrMany2one4Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCrMany2one4Controller.class);

    @Autowired
	@Qualifier("dbscenarios.TCrMany2one4Service")
	private TCrMany2one4Service tCrMany2one4Service;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new TCrMany2one4 instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TCrMany2one4 createTCrMany2one4(@RequestBody TCrMany2one4 tcrMany2one4) {
		LOGGER.debug("Create TCrMany2one4 with information: {}" , tcrMany2one4);

		tcrMany2one4 = tCrMany2one4Service.create(tcrMany2one4);
		LOGGER.debug("Created TCrMany2one4 with information: {}" , tcrMany2one4);

	    return tcrMany2one4;
	}

    @ApiOperation(value = "Returns the TCrMany2one4 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TCrMany2one4 getTCrMany2one4(@PathVariable("id") Date id) {
        LOGGER.debug("Getting TCrMany2one4 with id: {}" , id);

        TCrMany2one4 foundTCrMany2one4 = tCrMany2one4Service.getById(id);
        LOGGER.debug("TCrMany2one4 details with id: {}" , foundTCrMany2one4);

        return foundTCrMany2one4;
    }

    @ApiOperation(value = "Updates the TCrMany2one4 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TCrMany2one4 editTCrMany2one4(@PathVariable("id") Date id, @RequestBody TCrMany2one4 tcrMany2one4) {
        LOGGER.debug("Editing TCrMany2one4 with id: {}" , tcrMany2one4.getDateId());

        tcrMany2one4.setDateId(id);
        tcrMany2one4 = tCrMany2one4Service.update(tcrMany2one4);
        LOGGER.debug("TCrMany2one4 details with id: {}" , tcrMany2one4);

        return tcrMany2one4;
    }

    @ApiOperation(value = "Deletes the TCrMany2one4 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTCrMany2one4(@PathVariable("id") Date id) {
        LOGGER.debug("Deleting TCrMany2one4 with id: {}" , id);

        TCrMany2one4 deletedTCrMany2one4 = tCrMany2one4Service.delete(id);

        return deletedTCrMany2one4 != null;
    }

    /**
     * @deprecated Use {@link #findTCrMany2one4s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TCrMany2one4 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TCrMany2one4> searchTCrMany2one4sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TCrMany2one4s list by query filter:{}", (Object) queryFilters);
        return tCrMany2one4Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TCrMany2one4 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TCrMany2one4> findTCrMany2one4s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TCrMany2one4s list by filter:", query);
        return tCrMany2one4Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TCrMany2one4 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TCrMany2one4> filterTCrMany2one4s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TCrMany2one4s list by filter", query);
        return tCrMany2one4Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTCrMany2one4s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return tCrMany2one4Service.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportTCrMany2one4sAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = TCrMany2one4.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> tCrMany2one4Service.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of TCrMany2one4 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTCrMany2one4s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TCrMany2one4s");
		return tCrMany2one4Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTCrMany2one4AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return tCrMany2one4Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TCrMany2one4Service instance
	 */
	protected void setTCrMany2one4Service(TCrMany2one4Service service) {
		this.tCrMany2one4Service = service;
	}

}