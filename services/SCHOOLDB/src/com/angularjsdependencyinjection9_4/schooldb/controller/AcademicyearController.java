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
import com.angularjsdependencyinjection9_4.schooldb.Academicyear;
import com.angularjsdependencyinjection9_4.schooldb.service.AcademicyearService;


/**
 * Controller object for domain model class Academicyear.
 * @see Academicyear
 */
@RestController("SCHOOLDB.AcademicyearController")
@Api(value = "AcademicyearController", description = "Exposes APIs to work with Academicyear resource.")
@RequestMapping("/SCHOOLDB/Academicyear")
public class AcademicyearController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcademicyearController.class);

    @Autowired
	@Qualifier("SCHOOLDB.AcademicyearService")
	private AcademicyearService academicyearService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Academicyear instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Academicyear createAcademicyear(@RequestBody Academicyear academicyearInstance) {
		LOGGER.debug("Create Academicyear with information: {}" , academicyearInstance);

		academicyearInstance = academicyearService.create(academicyearInstance);
		LOGGER.debug("Created Academicyear with information: {}" , academicyearInstance);

	    return academicyearInstance;
	}

    @ApiOperation(value = "Returns the Academicyear instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Academicyear getAcademicyear(@PathVariable("id") String id) {
        LOGGER.debug("Getting Academicyear with id: {}" , id);

        Academicyear foundAcademicyear = academicyearService.getById(id);
        LOGGER.debug("Academicyear details with id: {}" , foundAcademicyear);

        return foundAcademicyear;
    }

    @ApiOperation(value = "Updates the Academicyear instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Academicyear editAcademicyear(@PathVariable("id") String id, @RequestBody Academicyear academicyearInstance) {
        LOGGER.debug("Editing Academicyear with id: {}" , academicyearInstance.getAcademicyear());

        academicyearInstance.setAcademicyear(id);
        academicyearInstance = academicyearService.update(academicyearInstance);
        LOGGER.debug("Academicyear details with id: {}" , academicyearInstance);

        return academicyearInstance;
    }

    @ApiOperation(value = "Deletes the Academicyear instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAcademicyear(@PathVariable("id") String id) {
        LOGGER.debug("Deleting Academicyear with id: {}" , id);

        Academicyear deletedAcademicyear = academicyearService.delete(id);

        return deletedAcademicyear != null;
    }

    @RequestMapping(value = "/startyear/{startyear}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Academicyear with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Academicyear getByStartyear(@PathVariable("startyear") int startyear) {
        LOGGER.debug("Getting Academicyear with uniques key Startyear");
        return academicyearService.getByStartyear(startyear);
    }

    /**
     * @deprecated Use {@link #findAcademicyears(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Academicyear instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Academicyear> searchAcademicyearsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Academicyears list by query filter:{}", (Object) queryFilters);
        return academicyearService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Academicyear instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Academicyear> findAcademicyears(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Academicyears list by filter:", query);
        return academicyearService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Academicyear instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Academicyear> filterAcademicyears(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Academicyears list by filter", query);
        return academicyearService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAcademicyears(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return academicyearService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportAcademicyearsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Academicyear.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> academicyearService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Academicyear instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAcademicyears( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Academicyears");
		return academicyearService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAcademicyearAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return academicyearService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/academicses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the academicses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Academics> findAssociatedAcademicses(@PathVariable("id") String id, Pageable pageable) {

        LOGGER.debug("Fetching all associated academicses");
        return academicyearService.findAssociatedAcademicses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AcademicyearService instance
	 */
	protected void setAcademicyearService(AcademicyearService service) {
		this.academicyearService = service;
	}

}