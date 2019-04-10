/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbexportcheck.controller;

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

import com.angularjsdependencyinjection9_4.dbexportcheck.Table1;
import com.angularjsdependencyinjection9_4.dbexportcheck.Table3;
import com.angularjsdependencyinjection9_4.dbexportcheck.service.Table3Service;


/**
 * Controller object for domain model class Table3.
 * @see Table3
 */
@RestController("DBExportCheck.Table3Controller")
@Api(value = "Table3Controller", description = "Exposes APIs to work with Table3 resource.")
@RequestMapping("/DBExportCheck/Table3")
public class Table3Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table3Controller.class);

    @Autowired
	@Qualifier("DBExportCheck.Table3Service")
	private Table3Service table3Service;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Table3 instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table3 createTable3(@RequestBody Table3 table3) {
		LOGGER.debug("Create Table3 with information: {}" , table3);

		table3 = table3Service.create(table3);
		LOGGER.debug("Created Table3 with information: {}" , table3);

	    return table3;
	}

    @ApiOperation(value = "Returns the Table3 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table3 getTable3(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Table3 with id: {}" , id);

        Table3 foundTable3 = table3Service.getById(id);
        LOGGER.debug("Table3 details with id: {}" , foundTable3);

        return foundTable3;
    }

    @ApiOperation(value = "Updates the Table3 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table3 editTable3(@PathVariable("id") Integer id, @RequestBody Table3 table3) {
        LOGGER.debug("Editing Table3 with id: {}" , table3.getId());

        table3.setId(id);
        table3 = table3Service.update(table3);
        LOGGER.debug("Table3 details with id: {}" , table3);

        return table3;
    }

    @ApiOperation(value = "Deletes the Table3 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable3(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Table3 with id: {}" , id);

        Table3 deletedTable3 = table3Service.delete(id);

        return deletedTable3 != null;
    }

    /**
     * @deprecated Use {@link #findTable3s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table3 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table3> searchTable3sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table3s list by query filter:{}", (Object) queryFilters);
        return table3Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table3 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table3> findTable3s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table3s list by filter:", query);
        return table3Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table3 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table3> filterTable3s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table3s list by filter", query);
        return table3Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable3s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table3Service.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportTable3sAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Table3.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> table3Service.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Table3 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable3s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table3s");
		return table3Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable3AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table3Service.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/table1s", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the table1s instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table1> findAssociatedTable1s(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated table1s");
        return table3Service.findAssociatedTable1s(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table3Service instance
	 */
	protected void setTable3Service(Table3Service service) {
		this.table3Service = service;
	}

}