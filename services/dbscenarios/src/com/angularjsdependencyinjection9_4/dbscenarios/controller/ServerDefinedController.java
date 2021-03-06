/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios.controller;

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

import com.angularjsdependencyinjection9_4.dbscenarios.ServerDefined;
import com.angularjsdependencyinjection9_4.dbscenarios.service.ServerDefinedService;


/**
 * Controller object for domain model class ServerDefined.
 * @see ServerDefined
 */
@RestController("dbscenarios.ServerDefinedController")
@Api(value = "ServerDefinedController", description = "Exposes APIs to work with ServerDefined resource.")
@RequestMapping("/dbscenarios/ServerDefined")
public class ServerDefinedController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerDefinedController.class);

    @Autowired
	@Qualifier("dbscenarios.ServerDefinedService")
	private ServerDefinedService serverDefinedService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new ServerDefined instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ServerDefined createServerDefined(@RequestBody ServerDefined serverDefined) {
		LOGGER.debug("Create ServerDefined with information: {}" , serverDefined);

		serverDefined = serverDefinedService.create(serverDefined);
		LOGGER.debug("Created ServerDefined with information: {}" , serverDefined);

	    return serverDefined;
	}

    @ApiOperation(value = "Returns the ServerDefined instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ServerDefined getServerDefined(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting ServerDefined with id: {}" , id);

        ServerDefined foundServerDefined = serverDefinedService.getById(id);
        LOGGER.debug("ServerDefined details with id: {}" , foundServerDefined);

        return foundServerDefined;
    }

    @ApiOperation(value = "Updates the ServerDefined instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ServerDefined editServerDefined(@PathVariable("id") Integer id, @RequestBody ServerDefined serverDefined) {
        LOGGER.debug("Editing ServerDefined with id: {}" , serverDefined.getPkId());

        serverDefined.setPkId(id);
        serverDefined = serverDefinedService.update(serverDefined);
        LOGGER.debug("ServerDefined details with id: {}" , serverDefined);

        return serverDefined;
    }

    @ApiOperation(value = "Deletes the ServerDefined instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteServerDefined(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting ServerDefined with id: {}" , id);

        ServerDefined deletedServerDefined = serverDefinedService.delete(id);

        return deletedServerDefined != null;
    }

    /**
     * @deprecated Use {@link #findServerDefineds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ServerDefined instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ServerDefined> searchServerDefinedsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ServerDefineds list by query filter:{}", (Object) queryFilters);
        return serverDefinedService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ServerDefined instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ServerDefined> findServerDefineds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ServerDefineds list by filter:", query);
        return serverDefinedService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ServerDefined instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ServerDefined> filterServerDefineds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ServerDefineds list by filter", query);
        return serverDefinedService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportServerDefineds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return serverDefinedService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportServerDefinedsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = ServerDefined.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> serverDefinedService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of ServerDefined instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countServerDefineds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ServerDefineds");
		return serverDefinedService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getServerDefinedAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return serverDefinedService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ServerDefinedService instance
	 */
	protected void setServerDefinedService(ServerDefinedService service) {
		this.serverDefinedService = service;
	}

}