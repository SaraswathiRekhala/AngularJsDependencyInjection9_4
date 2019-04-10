/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.schooldb.controller;

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

import com.angularjsdependencyinjection9_4.schooldb.Academics;
import com.angularjsdependencyinjection9_4.schooldb.Standarddetails;
import com.angularjsdependencyinjection9_4.schooldb.service.StandarddetailsService;


/**
 * Controller object for domain model class Standarddetails.
 * @see Standarddetails
 */
@RestController("SCHOOLDB.StandarddetailsController")
@Api(value = "StandarddetailsController", description = "Exposes APIs to work with Standarddetails resource.")
@RequestMapping("/SCHOOLDB/Standarddetails")
public class StandarddetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandarddetailsController.class);

    @Autowired
	@Qualifier("SCHOOLDB.StandarddetailsService")
	private StandarddetailsService standarddetailsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Standarddetails instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Standarddetails createStandarddetails(@RequestBody Standarddetails standarddetails) {
		LOGGER.debug("Create Standarddetails with information: {}" , standarddetails);

		standarddetails = standarddetailsService.create(standarddetails);
		LOGGER.debug("Created Standarddetails with information: {}" , standarddetails);

	    return standarddetails;
	}

    @ApiOperation(value = "Returns the Standarddetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Standarddetails getStandarddetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Standarddetails with id: {}" , id);

        Standarddetails foundStandarddetails = standarddetailsService.getById(id);
        LOGGER.debug("Standarddetails details with id: {}" , foundStandarddetails);

        return foundStandarddetails;
    }

    @ApiOperation(value = "Updates the Standarddetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Standarddetails editStandarddetails(@PathVariable("id") Integer id, @RequestBody Standarddetails standarddetails) {
        LOGGER.debug("Editing Standarddetails with id: {}" , standarddetails.getStandardid());

        standarddetails.setStandardid(id);
        standarddetails = standarddetailsService.update(standarddetails);
        LOGGER.debug("Standarddetails details with id: {}" , standarddetails);

        return standarddetails;
    }

    @ApiOperation(value = "Deletes the Standarddetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteStandarddetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Standarddetails with id: {}" , id);

        Standarddetails deletedStandarddetails = standarddetailsService.delete(id);

        return deletedStandarddetails != null;
    }

    @RequestMapping(value = "/standardcode/{standardcode}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Standarddetails with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Standarddetails getByStandardcode(@PathVariable("standardcode") String standardcode) {
        LOGGER.debug("Getting Standarddetails with uniques key Standardcode");
        return standarddetailsService.getByStandardcode(standardcode);
    }

    /**
     * @deprecated Use {@link #findStandarddetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Standarddetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Standarddetails> searchStandarddetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Standarddetails list by query filter:{}", (Object) queryFilters);
        return standarddetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Standarddetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Standarddetails> findStandarddetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Standarddetails list by filter:", query);
        return standarddetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Standarddetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Standarddetails> filterStandarddetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Standarddetails list by filter", query);
        return standarddetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportStandarddetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return standarddetailsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportStandarddetailsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Standarddetails.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> standarddetailsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Standarddetails instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countStandarddetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Standarddetails");
		return standarddetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getStandarddetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return standarddetailsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/academicses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the academicses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Academics> findAssociatedAcademicses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated academicses");
        return standarddetailsService.findAssociatedAcademicses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service StandarddetailsService instance
	 */
	protected void setStandarddetailsService(StandarddetailsService service) {
		this.standarddetailsService = service;
	}

}