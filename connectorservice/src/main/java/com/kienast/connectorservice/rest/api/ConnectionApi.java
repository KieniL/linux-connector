/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.3.4).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.kienast.connectorservice.rest.api;

import com.kienast.connectorservice.rest.api.model.ConnectionCommandRequestModel;
import com.kienast.connectorservice.rest.api.model.ConnectionCommandResponseModel;
import com.kienast.connectorservice.rest.api.model.ConnectionModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStatusModel;
import com.kienast.connectorservice.rest.api.model.DestroyConnectionRequestModel;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Validated
@Api(value = "connection", description = "the connection API")
public interface ConnectionApi {

    @ApiOperation(value = "AddCommand", nickname = "addCommand", notes = "", response = ConnectionCommandResponseModel.class, tags={ "connection", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = ConnectionCommandResponseModel.class) })
    @RequestMapping(value = "/connection",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ConnectionCommandResponseModel> addCommand(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConnectionCommandRequestModel connectionCommandRequestModel);


    @ApiOperation(value = "CreateConnection", nickname = "createConnection", notes = "", response = ConnectionStatusModel.class, tags={ "connection", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = ConnectionStatusModel.class) })
    @RequestMapping(value = "/connection",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ConnectionStatusModel> createConnection(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConnectionModel connectionModel);


    @ApiOperation(value = "DestroyConnection", nickname = "destroyConnection", notes = "", response = ConnectionStatusModel.class, tags={ "connection", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = ConnectionStatusModel.class) })
    @RequestMapping(value = "/connection",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<ConnectionStatusModel> destroyConnection(@ApiParam(value = "" ,required=true )  @Valid @RequestBody DestroyConnectionRequestModel destroyConnectionRequestModel);


    @ApiOperation(value = "GetActiveConnections", nickname = "getActiveConnections", notes = "", response = ConnectionModel.class, responseContainer = "List", tags={ "connection", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = ConnectionModel.class, responseContainer = "List") })
    @RequestMapping(value = "/connection",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ConnectionModel>> getActiveConnections();

}
