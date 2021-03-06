/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1.controller;

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

import com.angularjsdependencyinjection9_4.dbscenarios1.AllExternalTypes;
import com.angularjsdependencyinjection9_4.dbscenarios1.service.AllExternalTypesService;


/**
 * Controller object for domain model class AllExternalTypes.
 * @see AllExternalTypes
 */
@RestController("dbscenarios1.AllExternalTypesController")
@Api(value = "AllExternalTypesController", description = "Exposes APIs to work with AllExternalTypes resource.")
@RequestMapping("/dbscenarios1/AllExternalTypes")
public class AllExternalTypesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllExternalTypesController.class);

    @Autowired
	@Qualifier("dbscenarios1.AllExternalTypesService")
	private AllExternalTypesService allExternalTypesService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new AllExternalTypes instance.")
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AllExternalTypes createAllExternalTypes(@RequestPart("wm_data_json") AllExternalTypes allExternalTypes, @RequestPart(value = "blobCol", required = false) MultipartFile _blobCol, @RequestPart(value = "longblobCol", required = false) MultipartFile _longblobCol) {
		LOGGER.debug("Create AllExternalTypes with information: {}" , allExternalTypes);

    allExternalTypes.setBlobCol(WMMultipartUtils.toByteArray(_blobCol));
    allExternalTypes.setLongblobCol(WMMultipartUtils.toByteArray(_longblobCol));
		allExternalTypes = allExternalTypesService.create(allExternalTypes);
		LOGGER.debug("Created AllExternalTypes with information: {}" , allExternalTypes);

	    return allExternalTypes;
	}

    @ApiOperation(value = "Returns the AllExternalTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AllExternalTypes getAllExternalTypes(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting AllExternalTypes with id: {}" , id);

        AllExternalTypes foundAllExternalTypes = allExternalTypesService.getById(id);
        LOGGER.debug("AllExternalTypes details with id: {}" , foundAllExternalTypes);

        return foundAllExternalTypes;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in AllExternalTypes instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getAllExternalTypesBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in AllExternalTypes instance" , fieldName);

        if(!WMRuntimeUtils.isLob(AllExternalTypes.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        AllExternalTypes allExternalTypes = allExternalTypesService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(allExternalTypes, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the AllExternalTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AllExternalTypes editAllExternalTypes(@PathVariable("id") Integer id, @RequestBody AllExternalTypes allExternalTypes) {
        LOGGER.debug("Editing AllExternalTypes with id: {}" , allExternalTypes.getIntCol());

        allExternalTypes.setIntCol(id);
        allExternalTypes = allExternalTypesService.update(allExternalTypes);
        LOGGER.debug("AllExternalTypes details with id: {}" , allExternalTypes);

        return allExternalTypes;
    }

    @ApiOperation(value = "Updates the AllExternalTypes instance associated with the given id.This API should be used when AllExternalTypes instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AllExternalTypes editAllExternalTypes(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) {
        AllExternalTypes newAllExternalTypes = WMMultipartUtils.toObject(multipartHttpServletRequest, AllExternalTypes.class, "dbscenarios1");
        newAllExternalTypes.setIntCol(id);

        AllExternalTypes oldAllExternalTypes = allExternalTypesService.getById(id);
        WMMultipartUtils.updateLobsContent(oldAllExternalTypes, newAllExternalTypes);
        LOGGER.debug("Updating AllExternalTypes with information: {}" , newAllExternalTypes);

        return allExternalTypesService.update(newAllExternalTypes);
    }

    @ApiOperation(value = "Deletes the AllExternalTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAllExternalTypes(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting AllExternalTypes with id: {}" , id);

        AllExternalTypes deletedAllExternalTypes = allExternalTypesService.delete(id);

        return deletedAllExternalTypes != null;
    }

    /**
     * @deprecated Use {@link #findAllExternalTypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of AllExternalTypes instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AllExternalTypes> searchAllExternalTypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AllExternalTypes list by query filter:{}", (Object) queryFilters);
        return allExternalTypesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AllExternalTypes instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AllExternalTypes> findAllExternalTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AllExternalTypes list by filter:", query);
        return allExternalTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AllExternalTypes instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AllExternalTypes> filterAllExternalTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AllExternalTypes list by filter", query);
        return allExternalTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAllExternalTypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return allExternalTypesService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportAllExternalTypesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = AllExternalTypes.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> allExternalTypesService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of AllExternalTypes instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAllExternalTypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting AllExternalTypes");
		return allExternalTypesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAllExternalTypesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return allExternalTypesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AllExternalTypesService instance
	 */
	protected void setAllExternalTypesService(AllExternalTypesService service) {
		this.allExternalTypesService = service;
	}

}