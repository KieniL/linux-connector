/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.3.4).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.kienast.apiservice.rest.api;

import com.kienast.apiservice.rest.api.model.ConnectionStoreModel;
import com.kienast.apiservice.rest.api.model.ConnectionStoreStatusModel;
import com.kienast.apiservice.rest.api.model.DeleteConnectionStoreRequestModel;
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
@Api(value = "connstore", description = "the connstore API")
public interface ConnstoreApi {

    @ApiOperation(value = "AddConnectionStore", nickname = "addConnectionStore", notes = "", response = ConnectionStoreStatusModel.class, tags={ "connstore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = ConnectionStoreStatusModel.class) })
    @RequestMapping(value = "/connstore",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ConnectionStoreStatusModel> addConnectionStore(@ApiParam(value = ""  )  @Valid @RequestBody ConnectionStoreModel connectionStoreModel);


    @ApiOperation(value = "DeleteConnectionStore", nickname = "deleteConnectionStore", notes = "", response = ConnectionStoreStatusModel.class, tags={ "connstore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = ConnectionStoreStatusModel.class) })
    @RequestMapping(value = "/connstore",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.HEAD)
    ResponseEntity<ConnectionStoreStatusModel> deleteConnectionStore(@ApiParam(value = "" ,required=true )  @Valid @RequestBody DeleteConnectionStoreRequestModel deleteConnectionStoreRequestModel);


    @ApiOperation(value = "GetConnectionStores", nickname = "getConnectionStores", notes = "", response = ConnectionStoreModel.class, responseContainer = "List", tags={ "connstore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = ConnectionStoreModel.class, responseContainer = "List") })
    @RequestMapping(value = "/connstore",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ConnectionStoreModel>> getConnectionStores();


    @ApiOperation(value = "UpdateConnectionStore", nickname = "updateConnectionStore", notes = "", response = ConnectionStoreStatusModel.class, tags={ "connstore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = ConnectionStoreStatusModel.class) })
    @RequestMapping(value = "/connstore/{storeId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ConnectionStoreStatusModel> updateConnectionStore(@ApiParam(value = "the id of the stored Connection",required=true) @PathVariable("storeId") String storeId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConnectionStoreModel connectionStoreModel);

}