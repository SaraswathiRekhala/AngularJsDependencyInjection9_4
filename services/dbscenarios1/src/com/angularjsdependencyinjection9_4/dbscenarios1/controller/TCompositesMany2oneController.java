/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios1.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigDecimal;
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

import com.angularjsdependencyinjection9_4.dbscenarios1.TCompositesMany2one;
import com.angularjsdependencyinjection9_4.dbscenarios1.TCompositesMany2one1;
import com.angularjsdependencyinjection9_4.dbscenarios1.TCompositesMany2oneId;
import com.angularjsdependencyinjection9_4.dbscenarios1.service.TCompositesMany2oneService;


/**
 * Controller object for domain model class TCompositesMany2one.
 * @see TCompositesMany2one
 */
@RestController("dbscenarios1.TCompositesMany2oneController")
@Api(value = "TCompositesMany2oneController", description = "Exposes APIs to work with TCompositesMany2one resource.")
@RequestMapping("/dbscenarios1/TCompositesMany2one")
public class TCompositesMany2oneController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCompositesMany2oneController.class);

    @Autowired
	@Qualifier("dbscenarios1.TCompositesMany2oneService")
	private TCompositesMany2oneService tCompositesMany2oneService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new TCompositesMany2one instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TCompositesMany2one createTCompositesMany2one(@RequestBody TCompositesMany2one tcompositesMany2one) {
		LOGGER.debug("Create TCompositesMany2one with information: {}" , tcompositesMany2one);

		tcompositesMany2one = tCompositesMany2oneService.create(tcompositesMany2one);
		LOGGER.debug("Created TCompositesMany2one with information: {}" , tcompositesMany2one);

	    return tcompositesMany2one;
	}

    @ApiOperation(value = "Returns the TCompositesMany2one instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TCompositesMany2one getTCompositesMany2one(@RequestParam("bigdecId") BigDecimal bigdecId, @RequestParam("shortId") Short shortId, @RequestParam("byteId") Short byteId, @RequestParam("charId") String charId) {

        TCompositesMany2oneId tcompositesmany2oneId = new TCompositesMany2oneId();
        tcompositesmany2oneId.setBigdecId(bigdecId);
        tcompositesmany2oneId.setShortId(shortId);
        tcompositesmany2oneId.setByteId(byteId);
        tcompositesmany2oneId.setCharId(charId);

        LOGGER.debug("Getting TCompositesMany2one with id: {}" , tcompositesmany2oneId);
        TCompositesMany2one tcompositesMany2one = tCompositesMany2oneService.getById(tcompositesmany2oneId);
        LOGGER.debug("TCompositesMany2one details with id: {}" , tcompositesMany2one);

        return tcompositesMany2one;
    }



    @ApiOperation(value = "Updates the TCompositesMany2one instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TCompositesMany2one editTCompositesMany2one(@RequestParam("bigdecId") BigDecimal bigdecId, @RequestParam("shortId") Short shortId, @RequestParam("byteId") Short byteId, @RequestParam("charId") String charId, @RequestBody TCompositesMany2one tcompositesMany2one) {

        tcompositesMany2one.setBigdecId(bigdecId);
        tcompositesMany2one.setShortId(shortId);
        tcompositesMany2one.setByteId(byteId);
        tcompositesMany2one.setCharId(charId);

        LOGGER.debug("TCompositesMany2one details with id is updated with: {}" , tcompositesMany2one);

        return tCompositesMany2oneService.update(tcompositesMany2one);
    }


    @ApiOperation(value = "Deletes the TCompositesMany2one instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTCompositesMany2one(@RequestParam("bigdecId") BigDecimal bigdecId, @RequestParam("shortId") Short shortId, @RequestParam("byteId") Short byteId, @RequestParam("charId") String charId) {

        TCompositesMany2oneId tcompositesmany2oneId = new TCompositesMany2oneId();
        tcompositesmany2oneId.setBigdecId(bigdecId);
        tcompositesmany2oneId.setShortId(shortId);
        tcompositesmany2oneId.setByteId(byteId);
        tcompositesmany2oneId.setCharId(charId);

        LOGGER.debug("Deleting TCompositesMany2one with id: {}" , tcompositesmany2oneId);
        TCompositesMany2one tcompositesMany2one = tCompositesMany2oneService.delete(tcompositesmany2oneId);

        return tcompositesMany2one != null;
    }


    /**
     * @deprecated Use {@link #findTCompositesMany2ones(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TCompositesMany2one instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TCompositesMany2one> searchTCompositesMany2onesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TCompositesMany2ones list by query filter:{}", (Object) queryFilters);
        return tCompositesMany2oneService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TCompositesMany2one instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TCompositesMany2one> findTCompositesMany2ones(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TCompositesMany2ones list by filter:", query);
        return tCompositesMany2oneService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TCompositesMany2one instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TCompositesMany2one> filterTCompositesMany2ones(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TCompositesMany2ones list by filter", query);
        return tCompositesMany2oneService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTCompositesMany2ones(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return tCompositesMany2oneService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportTCompositesMany2onesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = TCompositesMany2one.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> tCompositesMany2oneService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of TCompositesMany2one instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTCompositesMany2ones( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TCompositesMany2ones");
		return tCompositesMany2oneService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTCompositesMany2oneAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return tCompositesMany2oneService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/composite-id/tcompositesMany2one1s", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the tcompositesMany2one1s instance associated with the given composite-id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TCompositesMany2one1> findAssociatedTcompositesMany2one1s(@RequestParam("bigdecId") BigDecimal bigdecId, @RequestParam("shortId") Short shortId, @RequestParam("byteId") Short byteId, @RequestParam("charId") String charId, Pageable pageable) {

        LOGGER.debug("Fetching all associated tcompositesMany2one1s");
        return tCompositesMany2oneService.findAssociatedTcompositesMany2one1s(bigdecId, shortId, byteId, charId, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TCompositesMany2oneService instance
	 */
	protected void setTCompositesMany2oneService(TCompositesMany2oneService service) {
		this.tCompositesMany2oneService = service;
	}

}