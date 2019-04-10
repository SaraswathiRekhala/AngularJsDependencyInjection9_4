/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1.controller;

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

import com.angularjsdependencyinjection9_4.dbscenarios1.ServerdefTable;
import com.angularjsdependencyinjection9_4.dbscenarios1.service.ServerdefTableService;


/**
 * Controller object for domain model class ServerdefTable.
 * @see ServerdefTable
 */
@RestController("dbscenarios1.ServerdefTableController")
@Api(value = "ServerdefTableController", description = "Exposes APIs to work with ServerdefTable resource.")
@RequestMapping("/dbscenarios1/ServerdefTable")
public class ServerdefTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerdefTableController.class);

    @Autowired
	@Qualifier("dbscenarios1.ServerdefTableService")
	private ServerdefTableService serverdefTableService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new ServerdefTable instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ServerdefTable createServerdefTable(@RequestBody ServerdefTable serverdefTable) {
		LOGGER.debug("Create ServerdefTable with information: {}" , serverdefTable);

		serverdefTable = serverdefTableService.create(serverdefTable);
		LOGGER.debug("Created ServerdefTable with information: {}" , serverdefTable);

	    return serverdefTable;
	}

    @ApiOperation(value = "Returns the ServerdefTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ServerdefTable getServerdefTable(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting ServerdefTable with id: {}" , id);

        ServerdefTable foundServerdefTable = serverdefTableService.getById(id);
        LOGGER.debug("ServerdefTable details with id: {}" , foundServerdefTable);

        return foundServerdefTable;
    }

    @ApiOperation(value = "Updates the ServerdefTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ServerdefTable editServerdefTable(@PathVariable("id") Integer id, @RequestBody ServerdefTable serverdefTable) {
        LOGGER.debug("Editing ServerdefTable with id: {}" , serverdefTable.getId());

        serverdefTable.setId(id);
        serverdefTable = serverdefTableService.update(serverdefTable);
        LOGGER.debug("ServerdefTable details with id: {}" , serverdefTable);

        return serverdefTable;
    }

    @ApiOperation(value = "Deletes the ServerdefTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteServerdefTable(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting ServerdefTable with id: {}" , id);

        ServerdefTable deletedServerdefTable = serverdefTableService.delete(id);

        return deletedServerdefTable != null;
    }

    /**
     * @deprecated Use {@link #findServerdefTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ServerdefTable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ServerdefTable> searchServerdefTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ServerdefTables list by query filter:{}", (Object) queryFilters);
        return serverdefTableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ServerdefTable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ServerdefTable> findServerdefTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ServerdefTables list by filter:", query);
        return serverdefTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ServerdefTable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ServerdefTable> filterServerdefTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ServerdefTables list by filter", query);
        return serverdefTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportServerdefTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return serverdefTableService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportServerdefTablesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = ServerdefTable.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> serverdefTableService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of ServerdefTable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countServerdefTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ServerdefTables");
		return serverdefTableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getServerdefTableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return serverdefTableService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ServerdefTableService instance
	 */
	protected void setServerdefTableService(ServerdefTableService service) {
		this.serverdefTableService = service;
	}

}