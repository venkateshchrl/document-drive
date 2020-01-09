package com.demo.document.documentdrive.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.io.File;
import java.util.Map;
import java.util.List;
import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.demo.document.documentdrive.api.FoldersApiService;
import com.demo.document.documentdrive.api.NotFoundException;
import com.demo.document.documentdrive.api.factories.FoldersApiServiceFactory;
import com.demo.document.documentdrive.model.*;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/folders")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-01-09T11:02:48.153Z[GMT]")public class FoldersApi  {
   private final FoldersApiService delegate;

   public FoldersApi(@Context ServletConfig servletContext) {
      FoldersApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("FoldersApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (FoldersApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = FoldersApiServiceFactory.getFoldersApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/{folderid}/files/{fileid}/download")
    
    @Produces({ "application/octet-stream" })
    @Operation(summary = "Downloads the file", description = "", tags={ "files" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = File.class))),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    public Response downloadFile(@Parameter(in = ParameterIn.PATH, description = "Id of the folder where files are to be read",required=true) @PathParam("folderid") String folderid
,@Parameter(in = ParameterIn.PATH, description = "Id of the file",required=true) @PathParam("fileid") String fileid
,@Parameter(in = ParameterIn.QUERY, description = "Should download/preview") @QueryParam("preview") Boolean preview
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.downloadFile(folderid,fileid,preview,securityContext);
    }
    @GET
    @Path("/{folderid}/download")
    
    @Produces({ "application/octet-stream" })
    @Operation(summary = "Downloads the files in a folder as zip format", description = "", tags={ "files" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = File.class))),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    public Response downloadFolder(@Parameter(in = ParameterIn.PATH, description = "Id of the folder where files are to be read",required=true) @PathParam("folderid") String folderid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.downloadFolder(folderid,securityContext);
    }
    @GET
    @Path("/{folderid}/files/{fileid}")
    
    @Produces({ "application/json" })
    @Operation(summary = "Retrieves details of a file/folder", description = "", tags={ "files" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = File.class))),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    public Response getFileDetails(@Parameter(in = ParameterIn.PATH, description = "Id of the folder where files are to be read",required=true) @PathParam("folderid") String folderid
,@Parameter(in = ParameterIn.PATH, description = "Id of the file",required=true) @PathParam("fileid") String fileid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getFileDetails(folderid,fileid,securityContext);
    }
    @GET
    @Path("/{folderid}/files")
    
    @Produces({ "application/json" })
    @Operation(summary = "Retrieves list of in a folder", description = "", tags={ "files" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = Files.class))),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    public Response getFilesList(@Parameter(in = ParameterIn.PATH, description = "Id of the folder where files are to be read",required=true) @PathParam("folderid") String folderid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getFilesList(folderid,securityContext);
    }
    @POST
    @Path("/{folderid}/files")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @Operation(summary = "Add single/multiple files in a folder", description = "", tags={ "files" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Successful", content = @Content(schema = @Schema(implementation = Files.class))),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    public Response uploadFiles(@Parameter(in = ParameterIn.PATH, description = "Id of the folder where files are to be uploaded",required=true) @PathParam("folderid") String folderid
,@Parameter(description = "")  @FormParam("location")  String location
,@Parameter(description = "")  @FormParam("content")  List<File> content
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.uploadFiles(folderid,location,content,securityContext);
    }
}
