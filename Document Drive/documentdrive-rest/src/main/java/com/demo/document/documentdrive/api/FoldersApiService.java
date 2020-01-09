package com.demo.document.documentdrive.api;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.demo.document.documentdrive.api.*;
import com.demo.document.documentdrive.model.*;

import java.io.File;
import java.util.Map;
import java.util.List;
import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-01-09T11:02:48.153Z[GMT]")public abstract class FoldersApiService {
    public abstract Response downloadFile(String folderid,String fileid, Boolean preview,SecurityContext securityContext) throws NotFoundException;
    public abstract Response downloadFolder(String folderid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getFileDetails(String folderid,String fileid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getFilesList(String folderid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response uploadFiles(String folderid,String location,List<File> content,SecurityContext securityContext) throws NotFoundException;
}
