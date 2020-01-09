package com.demo.document.documentdrive.api.impl;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.demo.document.documentdrive.api.NotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@Path("/users")
public class UserProfile {
	@GET
    @Path("/me")
    
    @Produces({ "application/json" })
    @Operation(summary = "Fetches user profile", description = "", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = File.class))),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    public Response fetchUserProfile(@Context SecurityContext securityContext)
    throws NotFoundException {
        return Response.ok(securityContext.getUserPrincipal())
        				.build();
    }
}
