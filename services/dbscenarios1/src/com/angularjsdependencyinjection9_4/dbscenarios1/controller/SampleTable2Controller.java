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

import com.angularjsdependencyinjection9_4.dbscenarios1.SampleTable2;
import com.angularjsdependencyinjection9_4.dbscenarios1.service.SampleTable2Service;


/**
 * Controller object for domain model class SampleTable2.
 * @see SampleTable2
 */
@RestController("dbscenarios1.SampleTable2Controller")
@Api(value = "SampleTable2Controller", description = "Exposes APIs to work with SampleTable2 resource.")
@RequestMapping("/dbscenarios1/SampleTable2")
public class SampleTable2Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleTable2Controller.class);

    @Autowired
	@Qualifier("dbscenarios1.SampleTable2Service")
	private SampleTable2Service sampleTable2Service;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new SampleTable2 instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SampleTable2 createSampleTable2(@RequestBody SampleTable2 sampleTable2) {
		LOGGER.debug("Create SampleTable2 with information: {}" , sampleTable2);

		sampleTable2 = sampleTable2Service.create(sampleTable2);
		LOGGER.debug("Created SampleTable2 with information: {}" , sampleTable2);

	    return sampleTable2;
	}

    @ApiOperation(value = "Returns the SampleTable2 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SampleTable2 getSampleTable2(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting SampleTable2 with id: {}" , id);

        SampleTable2 foundSampleTable2 = sampleTable2Service.getById(id);
        LOGGER.debug("SampleTable2 details with id: {}" , foundSampleTable2);

        return foundSampleTable2;
    }

    @ApiOperation(value = "Updates the SampleTable2 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SampleTable2 editSampleTable2(@PathVariable("id") Integer id, @RequestBody SampleTable2 sampleTable2) {
        LOGGER.debug("Editing SampleTable2 with id: {}" , sampleTable2.getId());

        sampleTable2.setId(id);
        sampleTable2 = sampleTable2Service.update(sampleTable2);
        LOGGER.debug("SampleTable2 details with id: {}" , sampleTable2);

        return sampleTable2;
    }

    @ApiOperation(value = "Deletes the SampleTable2 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSampleTable2(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting SampleTable2 with id: {}" , id);

        SampleTable2 deletedSampleTable2 = sampleTable2Service.delete(id);

        return deletedSampleTable2 != null;
    }

    /**
     * @deprecated Use {@link #findSampleTable2s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SampleTable2 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SampleTable2> searchSampleTable2sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SampleTable2s list by query filter:{}", (Object) queryFilters);
        return sampleTable2Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SampleTable2 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SampleTable2> findSampleTable2s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SampleTable2s list by filter:", query);
        return sampleTable2Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SampleTable2 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SampleTable2> filterSampleTable2s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SampleTable2s list by filter", query);
        return sampleTable2Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSampleTable2s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return sampleTable2Service.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportSampleTable2sAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = SampleTable2.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> sampleTable2Service.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of SampleTable2 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSampleTable2s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SampleTable2s");
		return sampleTable2Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSampleTable2AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return sampleTable2Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SampleTable2Service instance
	 */
	protected void setSampleTable2Service(SampleTable2Service service) {
		this.sampleTable2Service = service;
	}

}