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

import com.angularjsdependencyinjection9_4.dbscenarios1.BlobTypeIdentifier;
import com.angularjsdependencyinjection9_4.dbscenarios1.service.BlobTypeIdentifierService;


/**
 * Controller object for domain model class BlobTypeIdentifier.
 * @see BlobTypeIdentifier
 */
@RestController("dbscenarios1.BlobTypeIdentifierController")
@Api(value = "BlobTypeIdentifierController", description = "Exposes APIs to work with BlobTypeIdentifier resource.")
@RequestMapping("/dbscenarios1/BlobTypeIdentifier")
public class BlobTypeIdentifierController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlobTypeIdentifierController.class);

    @Autowired
	@Qualifier("dbscenarios1.BlobTypeIdentifierService")
	private BlobTypeIdentifierService blobTypeIdentifierService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new BlobTypeIdentifier instance.")
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BlobTypeIdentifier createBlobTypeIdentifier(@RequestPart("wm_data_json") BlobTypeIdentifier blobTypeIdentifier, @RequestPart(value = "column2", required = false) MultipartFile _column2) {
		LOGGER.debug("Create BlobTypeIdentifier with information: {}" , blobTypeIdentifier);

    blobTypeIdentifier.setColumn2(WMMultipartUtils.toByteArray(_column2));
		blobTypeIdentifier = blobTypeIdentifierService.create(blobTypeIdentifier);
		LOGGER.debug("Created BlobTypeIdentifier with information: {}" , blobTypeIdentifier);

	    return blobTypeIdentifier;
	}

    @ApiOperation(value = "Returns the BlobTypeIdentifier instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BlobTypeIdentifier getBlobTypeIdentifier(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting BlobTypeIdentifier with id: {}" , id);

        BlobTypeIdentifier foundBlobTypeIdentifier = blobTypeIdentifierService.getById(id);
        LOGGER.debug("BlobTypeIdentifier details with id: {}" , foundBlobTypeIdentifier);

        return foundBlobTypeIdentifier;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in BlobTypeIdentifier instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getBlobTypeIdentifierBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in BlobTypeIdentifier instance" , fieldName);

        if(!WMRuntimeUtils.isLob(BlobTypeIdentifier.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        BlobTypeIdentifier blobTypeIdentifier = blobTypeIdentifierService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(blobTypeIdentifier, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the BlobTypeIdentifier instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BlobTypeIdentifier editBlobTypeIdentifier(@PathVariable("id") Integer id, @RequestBody BlobTypeIdentifier blobTypeIdentifier) {
        LOGGER.debug("Editing BlobTypeIdentifier with id: {}" , blobTypeIdentifier.getId());

        blobTypeIdentifier.setId(id);
        blobTypeIdentifier = blobTypeIdentifierService.update(blobTypeIdentifier);
        LOGGER.debug("BlobTypeIdentifier details with id: {}" , blobTypeIdentifier);

        return blobTypeIdentifier;
    }

    @ApiOperation(value = "Updates the BlobTypeIdentifier instance associated with the given id.This API should be used when BlobTypeIdentifier instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BlobTypeIdentifier editBlobTypeIdentifier(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) {
        BlobTypeIdentifier newBlobTypeIdentifier = WMMultipartUtils.toObject(multipartHttpServletRequest, BlobTypeIdentifier.class, "dbscenarios1");
        newBlobTypeIdentifier.setId(id);

        BlobTypeIdentifier oldBlobTypeIdentifier = blobTypeIdentifierService.getById(id);
        WMMultipartUtils.updateLobsContent(oldBlobTypeIdentifier, newBlobTypeIdentifier);
        LOGGER.debug("Updating BlobTypeIdentifier with information: {}" , newBlobTypeIdentifier);

        return blobTypeIdentifierService.update(newBlobTypeIdentifier);
    }

    @ApiOperation(value = "Deletes the BlobTypeIdentifier instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteBlobTypeIdentifier(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting BlobTypeIdentifier with id: {}" , id);

        BlobTypeIdentifier deletedBlobTypeIdentifier = blobTypeIdentifierService.delete(id);

        return deletedBlobTypeIdentifier != null;
    }

    /**
     * @deprecated Use {@link #findBlobTypeIdentifiers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of BlobTypeIdentifier instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BlobTypeIdentifier> searchBlobTypeIdentifiersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering BlobTypeIdentifiers list by query filter:{}", (Object) queryFilters);
        return blobTypeIdentifierService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of BlobTypeIdentifier instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BlobTypeIdentifier> findBlobTypeIdentifiers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering BlobTypeIdentifiers list by filter:", query);
        return blobTypeIdentifierService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of BlobTypeIdentifier instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BlobTypeIdentifier> filterBlobTypeIdentifiers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering BlobTypeIdentifiers list by filter", query);
        return blobTypeIdentifierService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportBlobTypeIdentifiers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return blobTypeIdentifierService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportBlobTypeIdentifiersAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = BlobTypeIdentifier.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> blobTypeIdentifierService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of BlobTypeIdentifier instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countBlobTypeIdentifiers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting BlobTypeIdentifiers");
		return blobTypeIdentifierService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getBlobTypeIdentifierAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return blobTypeIdentifierService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BlobTypeIdentifierService instance
	 */
	protected void setBlobTypeIdentifierService(BlobTypeIdentifierService service) {
		this.blobTypeIdentifierService = service;
	}

}