/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.allscenariosdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TypeMismatchException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.angularjsdependencyinjection9_4.allscenariosdb.Blobtable;
import com.angularjsdependencyinjection9_4.allscenariosdb.service.BlobtableService;


/**
 * Controller object for domain model class Blobtable.
 * @see Blobtable
 */
@RestController("allscenariosdb.BlobtableController")
@Api(value = "BlobtableController", description = "Exposes APIs to work with Blobtable resource.")
@RequestMapping("/allscenariosdb/Blobtable")
public class BlobtableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlobtableController.class);

    @Autowired
	@Qualifier("allscenariosdb.BlobtableService")
	private BlobtableService blobtableService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Blobtable instance.")
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Blobtable createBlobtable(@RequestPart("wm_data_json") Blobtable blobtable, @RequestPart(value = "blobcol", required = false) MultipartFile _blobcol) {
		LOGGER.debug("Create Blobtable with information: {}" , blobtable);

    blobtable.setBlobcol(WMMultipartUtils.toByteArray(_blobcol));
		blobtable = blobtableService.create(blobtable);
		LOGGER.debug("Created Blobtable with information: {}" , blobtable);

	    return blobtable;
	}

    @ApiOperation(value = "Returns the Blobtable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Blobtable getBlobtable(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Blobtable with id: {}" , id);

        Blobtable foundBlobtable = blobtableService.getById(id);
        LOGGER.debug("Blobtable details with id: {}" , foundBlobtable);

        return foundBlobtable;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in Blobtable instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getBlobtableBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in Blobtable instance" , fieldName);

        if(!WMRuntimeUtils.isLob(Blobtable.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        Blobtable blobtable = blobtableService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(blobtable, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the Blobtable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Blobtable editBlobtable(@PathVariable("id") Integer id, @RequestBody Blobtable blobtable) {
        LOGGER.debug("Editing Blobtable with id: {}" , blobtable.getId());

        blobtable.setId(id);
        blobtable = blobtableService.update(blobtable);
        LOGGER.debug("Blobtable details with id: {}" , blobtable);

        return blobtable;
    }

    @ApiOperation(value = "Updates the Blobtable instance associated with the given id.This API should be used when Blobtable instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Blobtable editBlobtable(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) {
        Blobtable newBlobtable = WMMultipartUtils.toObject(multipartHttpServletRequest, Blobtable.class, "allscenariosdb");
        newBlobtable.setId(id);

        Blobtable oldBlobtable = blobtableService.getById(id);
        WMMultipartUtils.updateLobsContent(oldBlobtable, newBlobtable);
        LOGGER.debug("Updating Blobtable with information: {}" , newBlobtable);

        return blobtableService.update(newBlobtable);
    }

    @ApiOperation(value = "Deletes the Blobtable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteBlobtable(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Blobtable with id: {}" , id);

        Blobtable deletedBlobtable = blobtableService.delete(id);

        return deletedBlobtable != null;
    }

    /**
     * @deprecated Use {@link #findBlobtables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Blobtable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Blobtable> searchBlobtablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Blobtables list by query filter:{}", (Object) queryFilters);
        return blobtableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Blobtable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Blobtable> findBlobtables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Blobtables list by filter:", query);
        return blobtableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Blobtable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Blobtable> filterBlobtables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Blobtables list by filter", query);
        return blobtableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportBlobtables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return blobtableService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportBlobtablesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Blobtable.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> blobtableService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Blobtable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countBlobtables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Blobtables");
		return blobtableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getBlobtableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return blobtableService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BlobtableService instance
	 */
	protected void setBlobtableService(BlobtableService service) {
		this.blobtableService = service;
	}

}