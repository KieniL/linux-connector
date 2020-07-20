/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.3.4).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.kienast.authservice.rest.api;

import com.kienast.authservice.rest.api.model.LoginModel;
import com.kienast.authservice.rest.api.model.TokenModel;
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
@Api(value = "auth", description = "the auth API")
public interface AuthApi {

    @ApiOperation(value = "Authenticate", nickname = "authenticate", notes = "", response = TokenModel.class, tags={ "auth", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = TokenModel.class) })
    @RequestMapping(value = "/auth",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<TokenModel> authenticate(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LoginModel loginModel);


    @ApiOperation(value = "Register", nickname = "register", notes = "", response = TokenModel.class, tags={ "auth", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = TokenModel.class) })
    @RequestMapping(value = "/auth",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    ResponseEntity<TokenModel> register(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LoginModel loginModel);


    @ApiOperation(value = "VerifyToken", nickname = "verifyToken", notes = "", response = TokenModel.class, tags={ "auth", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Schemas", response = TokenModel.class) })
    @RequestMapping(value = "/auth",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<TokenModel> verifyToken(@ApiParam(value = "" ,required=true )  @Valid @RequestBody TokenModel tokenModel);

}
