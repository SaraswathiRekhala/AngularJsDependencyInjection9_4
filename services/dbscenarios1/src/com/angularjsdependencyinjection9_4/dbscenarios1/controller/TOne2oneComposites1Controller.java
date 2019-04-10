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

import com.angularjsdependencyinjection9_4.dbscenarios1.TOne2oneComposites1;
import com.angularjsdependencyinjection9_4.dbscenarios1.TOne2oneComposites1Id;
import com.angularjsdependencyinjection9_4.dbscenarios1.service.TOne2oneComposites1Service;


/**
 * Controller object for domain model class TOne2oneComposites1.
 * @see TOne2oneComposites1
 */
@RestController("dbscenarios1.TOne2oneComposites1Controller")
@Api(value = "TOne2oneComposites1Controller", description = "Exposes APIs to work with TOne2oneComposites1 resource.")
@RequestMapping("/dbscenarios1/TOne2oneComposites1")
public class TOne2oneComposites1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(TOne2oneComposites1Controller.class);

    @Autowired
	@Qualifier("dbscenarios1.TOne2oneComposites1Service")
	private TOne2oneComposites1Service tOne2oneComposites1Service;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new TOne2oneComposites1 instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneComposites1 createTOne2oneComposites1(@RequestBody TOne2oneComposites1 tone2oneComposites1) {
		LOGGER.debug("Create TOne2oneComposites1 with information: {}" , tone2oneComposites1);

		tone2oneComposites1 = tOne2oneComposites1Service.create(tone2oneComposites1);
		LOGGER.debug("Created TOne2oneComposites1 with information: {}" , tone2oneComposites1);

	    return tone2oneComposites1;
	}

    @ApiOperation(value = "Returns the TOne2oneComposites1 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneComposites1 getTOne2oneComposites1(@RequestParam("shortId") Short shortId, @RequestParam("stringId") String stringId, @RequestParam("byteId") Short byteId, @RequestParam("charId") String charId) {

        TOne2oneComposites1Id tone2onecomposites1Id = new TOne2oneComposites1Id();
        tone2onecomposites1Id.setShortId(shortId);
        tone2onecomposites1Id.setStringId(stringId);
        tone2onecomposites1Id.setByteId(byteId);
        tone2onecomposites1Id.setCharId(charId);

        LOGGER.debug("Getting TOne2oneComposites1 with id: {}" , tone2onecomposites1Id);
        TOne2oneComposites1 tone2oneComposites1 = tOne2oneComposites1Service.getById(tone2onecomposites1Id);
        LOGGER.debug("TOne2oneComposites1 details with id: {}" , tone2oneComposites1);

        return tone2oneComposites1;
    }



    @ApiOperation(value = "Updates the TOne2oneComposites1 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneComposites1 editTOne2oneComposites1(@RequestParam("shortId") Short shortId, @RequestParam("stringId") String stringId, @RequestParam("byteId") Short byteId, @RequestParam("charId") String charId, @RequestBody TOne2oneComposites1 tone2oneComposites1) {

        tone2oneComposites1.setShortId(shortId);
        tone2oneComposites1.setStringId(stringId);
        tone2oneComposites1.setByteId(byteId);
        tone2oneComposites1.setCharId(charId);

        LOGGER.debug("TOne2oneComposites1 details with id is updated with: {}" , tone2oneComposites1);

        return tOne2oneComposites1Service.update(tone2oneComposites1);
    }


    @ApiOperation(value = "Deletes the TOne2oneComposites1 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTOne2oneComposites1(@RequestParam("shortId") Short shortId, @RequestParam("stringId") String stringId, @RequestParam("byteId") Short byteId, @RequestParam("charId") String charId) {

        TOne2oneComposites1Id tone2onecomposites1Id = new TOne2oneComposites1Id();
        tone2onecomposites1Id.setShortId(shortId);
        tone2onecomposites1Id.setStringId(stringId);
        tone2onecomposites1Id.setByteId(byteId);
        tone2onecomposites1Id.setCharId(charId);

        LOGGER.debug("Deleting TOne2oneComposites1 with id: {}" , tone2onecomposites1Id);
        TOne2oneComposites1 tone2oneComposites1 = tOne2oneComposites1Service.delete(tone2onecomposites1Id);

        return tone2oneComposites1 != null;
    }


    /**
     * @deprecated Use {@link #findTOne2oneComposites1s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TOne2oneComposites1 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneComposites1> searchTOne2oneComposites1sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TOne2oneComposites1s list by query filter:{}", (Object) queryFilters);
        return tOne2oneComposites1Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TOne2oneComposites1 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneComposites1> findTOne2oneComposites1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TOne2oneComposites1s list by filter:", query);
        return tOne2oneComposites1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TOne2oneComposites1 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneComposites1> filterTOne2oneComposites1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TOne2oneComposites1s list by filter", query);
        return tOne2oneComposites1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTOne2oneComposites1s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return tOne2oneComposites1Service.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportTOne2oneComposites1sAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = TOne2oneComposites1.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> tOne2oneComposites1Service.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of TOne2oneComposites1 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTOne2oneComposites1s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TOne2oneComposites1s");
		return tOne2oneComposites1Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTOne2oneComposites1AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return tOne2oneComposites1Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TOne2oneComposites1Service instance
	 */
	protected void setTOne2oneComposites1Service(TOne2oneComposites1Service service) {
		this.tOne2oneComposites1Service = service;
	}

}