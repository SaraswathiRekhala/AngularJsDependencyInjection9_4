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

import com.angularjsdependencyinjection9_4.dbscenarios.CharColumnCheckTable;
import com.angularjsdependencyinjection9_4.dbscenarios.CharColumnCheckTableId;
import com.angularjsdependencyinjection9_4.dbscenarios.service.CharColumnCheckTableService;


/**
 * Controller object for domain model class CharColumnCheckTable.
 * @see CharColumnCheckTable
 */
@RestController("dbscenarios.CharColumnCheckTableController")
@Api(value = "CharColumnCheckTableController", description = "Exposes APIs to work with CharColumnCheckTable resource.")
@RequestMapping("/dbscenarios/CharColumnCheckTable")
public class CharColumnCheckTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CharColumnCheckTableController.class);

    @Autowired
	@Qualifier("dbscenarios.CharColumnCheckTableService")
	private CharColumnCheckTableService charColumnCheckTableService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new CharColumnCheckTable instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CharColumnCheckTable createCharColumnCheckTable(@RequestBody CharColumnCheckTable charColumnCheckTable) {
		LOGGER.debug("Create CharColumnCheckTable with information: {}" , charColumnCheckTable);

		charColumnCheckTable = charColumnCheckTableService.create(charColumnCheckTable);
		LOGGER.debug("Created CharColumnCheckTable with information: {}" , charColumnCheckTable);

	    return charColumnCheckTable;
	}

    @ApiOperation(value = "Returns the CharColumnCheckTable instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CharColumnCheckTable getCharColumnCheckTable(@RequestParam("serialId") Integer serialId, @RequestParam("charCol") String charCol) {

        CharColumnCheckTableId charcolumnchecktableId = new CharColumnCheckTableId();
        charcolumnchecktableId.setSerialId(serialId);
        charcolumnchecktableId.setCharCol(charCol);

        LOGGER.debug("Getting CharColumnCheckTable with id: {}" , charcolumnchecktableId);
        CharColumnCheckTable charColumnCheckTable = charColumnCheckTableService.getById(charcolumnchecktableId);
        LOGGER.debug("CharColumnCheckTable details with id: {}" , charColumnCheckTable);

        return charColumnCheckTable;
    }



    @ApiOperation(value = "Updates the CharColumnCheckTable instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CharColumnCheckTable editCharColumnCheckTable(@RequestParam("serialId") Integer serialId, @RequestParam("charCol") String charCol, @RequestBody CharColumnCheckTable charColumnCheckTable) {

        charColumnCheckTable.setSerialId(serialId);
        charColumnCheckTable.setCharCol(charCol);

        LOGGER.debug("CharColumnCheckTable details with id is updated with: {}" , charColumnCheckTable);

        return charColumnCheckTableService.update(charColumnCheckTable);
    }


    @ApiOperation(value = "Deletes the CharColumnCheckTable instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCharColumnCheckTable(@RequestParam("serialId") Integer serialId, @RequestParam("charCol") String charCol) {

        CharColumnCheckTableId charcolumnchecktableId = new CharColumnCheckTableId();
        charcolumnchecktableId.setSerialId(serialId);
        charcolumnchecktableId.setCharCol(charCol);

        LOGGER.debug("Deleting CharColumnCheckTable with id: {}" , charcolumnchecktableId);
        CharColumnCheckTable charColumnCheckTable = charColumnCheckTableService.delete(charcolumnchecktableId);

        return charColumnCheckTable != null;
    }


    /**
     * @deprecated Use {@link #findCharColumnCheckTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CharColumnCheckTable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CharColumnCheckTable> searchCharColumnCheckTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CharColumnCheckTables list by query filter:{}", (Object) queryFilters);
        return charColumnCheckTableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CharColumnCheckTable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CharColumnCheckTable> findCharColumnCheckTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CharColumnCheckTables list by filter:", query);
        return charColumnCheckTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CharColumnCheckTable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CharColumnCheckTable> filterCharColumnCheckTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CharColumnCheckTables list by filter", query);
        return charColumnCheckTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCharColumnCheckTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return charColumnCheckTableService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportCharColumnCheckTablesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = CharColumnCheckTable.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> charColumnCheckTableService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of CharColumnCheckTable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCharColumnCheckTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CharColumnCheckTables");
		return charColumnCheckTableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCharColumnCheckTableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return charColumnCheckTableService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CharColumnCheckTableService instance
	 */
	protected void setCharColumnCheckTableService(CharColumnCheckTableService service) {
		this.charColumnCheckTableService = service;
	}

}