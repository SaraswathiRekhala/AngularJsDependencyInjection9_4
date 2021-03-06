/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.angularjsdependencyinjection9_4.dbscenarios.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.sql.Date;
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
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.angularjsdependencyinjection9_4.dbscenarios.VirtualOne2one;
import com.angularjsdependencyinjection9_4.dbscenarios.VirtualOne2oneId;
import com.angularjsdependencyinjection9_4.dbscenarios.service.VirtualOne2oneService;


/**
 * Controller object for domain model class VirtualOne2one.
 * @see VirtualOne2one
 */
@RestController("dbscenarios.VirtualOne2oneController")
@Api(value = "VirtualOne2oneController", description = "Exposes APIs to work with VirtualOne2one resource.")
@RequestMapping("/dbscenarios/VirtualOne2one")
public class VirtualOne2oneController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VirtualOne2oneController.class);

    @Autowired
	@Qualifier("dbscenarios.VirtualOne2oneService")
	private VirtualOne2oneService virtualOne2oneService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new VirtualOne2one instance.")
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualOne2one createVirtualOne2one(@RequestPart("wm_data_json") VirtualOne2one virtualOne2one, @RequestPart(value = "byteaColumn", required = false) MultipartFile _byteaColumn, @RequestPart(value = "name1Column", required = false) MultipartFile _name1Column) {
		LOGGER.debug("Create VirtualOne2one with information: {}" , virtualOne2one);

    virtualOne2one.setByteaColumn(WMMultipartUtils.toByteArray(_byteaColumn));
    virtualOne2one.setName1Column(WMMultipartUtils.toByteArray(_name1Column));
		virtualOne2one = virtualOne2oneService.create(virtualOne2one);
		LOGGER.debug("Created VirtualOne2one with information: {}" , virtualOne2one);

	    return virtualOne2one;
	}

    @ApiOperation(value = "Returns the VirtualOne2one instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualOne2one getVirtualOne2one(@RequestParam("virtualPk") Integer virtualPk, @RequestParam("bigserialColumn") Long bigserialColumn, @RequestParam("bigintColumn") Long bigintColumn, @RequestParam("byteaColumn") byte[] byteaColumn, @RequestParam("characterVaryingColumn") String characterVaryingColumn, @RequestParam("dateColumn") Date dateColumn, @RequestParam("charColumnDoublequotesChar") String charColumnDoublequotesChar, @RequestParam("smallintColumn") Short smallintColumn, @RequestParam("name1Column") byte[] name1Column, @RequestParam("textColumn") String textColumn) {

        VirtualOne2oneId virtualone2oneId = new VirtualOne2oneId();
        virtualone2oneId.setVirtualPk(virtualPk);
        virtualone2oneId.setBigserialColumn(bigserialColumn);
        virtualone2oneId.setBigintColumn(bigintColumn);
        virtualone2oneId.setByteaColumn(byteaColumn);
        virtualone2oneId.setCharacterVaryingColumn(characterVaryingColumn);
        virtualone2oneId.setDateColumn(dateColumn);
        virtualone2oneId.setCharColumnDoublequotesChar(charColumnDoublequotesChar);
        virtualone2oneId.setSmallintColumn(smallintColumn);
        virtualone2oneId.setName1Column(name1Column);
        virtualone2oneId.setTextColumn(textColumn);

        LOGGER.debug("Getting VirtualOne2one with id: {}" , virtualone2oneId);
        VirtualOne2one virtualOne2one = virtualOne2oneService.getById(virtualone2oneId);
        LOGGER.debug("VirtualOne2one details with id: {}" , virtualOne2one);

        return virtualOne2one;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in VirtualOne2one instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id/content/{fieldName}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public void getVirtualOne2oneBLOBContent(@RequestParam("virtualPk") Integer virtualPk, @RequestParam("bigserialColumn") Long bigserialColumn, @RequestParam("bigintColumn") Long bigintColumn, @RequestParam("byteaColumn") byte[] byteaColumn, @RequestParam("characterVaryingColumn") String characterVaryingColumn, @RequestParam("dateColumn") Date dateColumn, @RequestParam("charColumnDoublequotesChar") String charColumnDoublequotesChar, @RequestParam("smallintColumn") Short smallintColumn, @RequestParam("name1Column") byte[] name1Column, @RequestParam("textColumn") String textColumn, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in VirtualOne2one instance" , fieldName);

        if(!WMRuntimeUtils.isLob(VirtualOne2one.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName +  " is not a valid BLOB type");
        }

        VirtualOne2oneId virtualone2oneId = new VirtualOne2oneId();
        virtualone2oneId.setVirtualPk(virtualPk);
        virtualone2oneId.setBigserialColumn(bigserialColumn);
        virtualone2oneId.setBigintColumn(bigintColumn);
        virtualone2oneId.setByteaColumn(byteaColumn);
        virtualone2oneId.setCharacterVaryingColumn(characterVaryingColumn);
        virtualone2oneId.setDateColumn(dateColumn);
        virtualone2oneId.setCharColumnDoublequotesChar(charColumnDoublequotesChar);
        virtualone2oneId.setSmallintColumn(smallintColumn);
        virtualone2oneId.setName1Column(name1Column);
        virtualone2oneId.setTextColumn(textColumn);

        VirtualOne2one virtualOne2one = virtualOne2oneService.getById(virtualone2oneId);
        WMMultipartUtils.buildHttpResponseForBlob(virtualOne2one, fieldName, httpServletRequest, httpServletResponse);
    }



    @ApiOperation(value = "Updates the VirtualOne2one instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualOne2one editVirtualOne2one(@RequestParam("virtualPk") Integer virtualPk, @RequestParam("bigserialColumn") Long bigserialColumn, @RequestParam("bigintColumn") Long bigintColumn, @RequestParam("byteaColumn") byte[] byteaColumn, @RequestParam("characterVaryingColumn") String characterVaryingColumn, @RequestParam("dateColumn") Date dateColumn, @RequestParam("charColumnDoublequotesChar") String charColumnDoublequotesChar, @RequestParam("smallintColumn") Short smallintColumn, @RequestParam("name1Column") byte[] name1Column, @RequestParam("textColumn") String textColumn, @RequestBody VirtualOne2one virtualOne2one) {

        virtualOne2one.setVirtualPk(virtualPk);
        virtualOne2one.setBigserialColumn(bigserialColumn);
        virtualOne2one.setBigintColumn(bigintColumn);
        virtualOne2one.setByteaColumn(byteaColumn);
        virtualOne2one.setCharacterVaryingColumn(characterVaryingColumn);
        virtualOne2one.setDateColumn(dateColumn);
        virtualOne2one.setCharColumnDoublequotesChar(charColumnDoublequotesChar);
        virtualOne2one.setSmallintColumn(smallintColumn);
        virtualOne2one.setName1Column(name1Column);
        virtualOne2one.setTextColumn(textColumn);

        LOGGER.debug("VirtualOne2one details with id is updated with: {}" , virtualOne2one);

        return virtualOne2oneService.update(virtualOne2one);
    }

    @ApiOperation(value = "Updates the VirtualOne2one instance associated with the given composite-id.This API should be used when VirtualOne2one instance fields that require multipart data.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualOne2one editVirtualOne2one(@RequestParam("virtualPk") Integer virtualPk, @RequestParam("bigserialColumn") Long bigserialColumn, @RequestParam("bigintColumn") Long bigintColumn, @RequestParam("byteaColumn") byte[] byteaColumn, @RequestParam("characterVaryingColumn") String characterVaryingColumn, @RequestParam("dateColumn") Date dateColumn, @RequestParam("charColumnDoublequotesChar") String charColumnDoublequotesChar, @RequestParam("smallintColumn") Short smallintColumn, @RequestParam("name1Column") byte[] name1Column, @RequestParam("textColumn") String textColumn, MultipartHttpServletRequest multipartHttpServletRequest) {
        return this.editVirtualOne2oneAndMultiparts(virtualPk, bigserialColumn, bigintColumn, byteaColumn, characterVaryingColumn, dateColumn, charColumnDoublequotesChar, smallintColumn, name1Column, textColumn, multipartHttpServletRequest);
    }

    @ApiOperation(value = "Updates the VirtualOne2one instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT,  consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualOne2one editVirtualOne2oneAndMultiparts(@RequestParam("virtualPk") Integer virtualPk, @RequestParam("bigserialColumn") Long bigserialColumn, @RequestParam("bigintColumn") Long bigintColumn, @RequestParam("byteaColumn") byte[] byteaColumn, @RequestParam("characterVaryingColumn") String characterVaryingColumn, @RequestParam("dateColumn") Date dateColumn, @RequestParam("charColumnDoublequotesChar") String charColumnDoublequotesChar, @RequestParam("smallintColumn") Short smallintColumn, @RequestParam("name1Column") byte[] name1Column, @RequestParam("textColumn") String textColumn, MultipartHttpServletRequest multipartHttpServletRequest) { 

        VirtualOne2oneId virtualone2oneId = new VirtualOne2oneId();
        virtualone2oneId.setVirtualPk(virtualPk);
        virtualone2oneId.setBigserialColumn(bigserialColumn);
        virtualone2oneId.setBigintColumn(bigintColumn);
        virtualone2oneId.setByteaColumn(byteaColumn);
        virtualone2oneId.setCharacterVaryingColumn(characterVaryingColumn);
        virtualone2oneId.setDateColumn(dateColumn);
        virtualone2oneId.setCharColumnDoublequotesChar(charColumnDoublequotesChar);
        virtualone2oneId.setSmallintColumn(smallintColumn);
        virtualone2oneId.setName1Column(name1Column);
        virtualone2oneId.setTextColumn(textColumn);

        VirtualOne2one newVirtualOne2one = WMMultipartUtils.toObject(multipartHttpServletRequest, VirtualOne2one.class, "dbscenarios");
        VirtualOne2one oldVirtualOne2one = virtualOne2oneService.getById(virtualone2oneId);

        WMMultipartUtils.updateLobsContent(oldVirtualOne2one, newVirtualOne2one);

        newVirtualOne2one.setVirtualPk(virtualPk);
        newVirtualOne2one.setBigserialColumn(bigserialColumn);
        newVirtualOne2one.setBigintColumn(bigintColumn);
        newVirtualOne2one.setByteaColumn(byteaColumn);
        newVirtualOne2one.setCharacterVaryingColumn(characterVaryingColumn);
        newVirtualOne2one.setDateColumn(dateColumn);
        newVirtualOne2one.setCharColumnDoublequotesChar(charColumnDoublequotesChar);
        newVirtualOne2one.setSmallintColumn(smallintColumn);
        newVirtualOne2one.setName1Column(name1Column);
        newVirtualOne2one.setTextColumn(textColumn);

        LOGGER.debug("VirtualOne2one details with id is updated with: {}" , newVirtualOne2one);

        return virtualOne2oneService.update(newVirtualOne2one);
    }


    @ApiOperation(value = "Deletes the VirtualOne2one instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteVirtualOne2one(@RequestParam("virtualPk") Integer virtualPk, @RequestParam("bigserialColumn") Long bigserialColumn, @RequestParam("bigintColumn") Long bigintColumn, @RequestParam("byteaColumn") byte[] byteaColumn, @RequestParam("characterVaryingColumn") String characterVaryingColumn, @RequestParam("dateColumn") Date dateColumn, @RequestParam("charColumnDoublequotesChar") String charColumnDoublequotesChar, @RequestParam("smallintColumn") Short smallintColumn, @RequestParam("name1Column") byte[] name1Column, @RequestParam("textColumn") String textColumn) {

        VirtualOne2oneId virtualone2oneId = new VirtualOne2oneId();
        virtualone2oneId.setVirtualPk(virtualPk);
        virtualone2oneId.setBigserialColumn(bigserialColumn);
        virtualone2oneId.setBigintColumn(bigintColumn);
        virtualone2oneId.setByteaColumn(byteaColumn);
        virtualone2oneId.setCharacterVaryingColumn(characterVaryingColumn);
        virtualone2oneId.setDateColumn(dateColumn);
        virtualone2oneId.setCharColumnDoublequotesChar(charColumnDoublequotesChar);
        virtualone2oneId.setSmallintColumn(smallintColumn);
        virtualone2oneId.setName1Column(name1Column);
        virtualone2oneId.setTextColumn(textColumn);

        LOGGER.debug("Deleting VirtualOne2one with id: {}" , virtualone2oneId);
        VirtualOne2one virtualOne2one = virtualOne2oneService.delete(virtualone2oneId);

        return virtualOne2one != null;
    }


    /**
     * @deprecated Use {@link #findVirtualOne2ones(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of VirtualOne2one instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VirtualOne2one> searchVirtualOne2onesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering VirtualOne2ones list by query filter:{}", (Object) queryFilters);
        return virtualOne2oneService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VirtualOne2one instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VirtualOne2one> findVirtualOne2ones(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VirtualOne2ones list by filter:", query);
        return virtualOne2oneService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VirtualOne2one instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VirtualOne2one> filterVirtualOne2ones(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VirtualOne2ones list by filter", query);
        return virtualOne2oneService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportVirtualOne2ones(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return virtualOne2oneService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportVirtualOne2onesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = VirtualOne2one.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> virtualOne2oneService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of VirtualOne2one instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countVirtualOne2ones( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting VirtualOne2ones");
		return virtualOne2oneService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getVirtualOne2oneAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return virtualOne2oneService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service VirtualOne2oneService instance
	 */
	protected void setVirtualOne2oneService(VirtualOne2oneService service) {
		this.virtualOne2oneService = service;
	}

}