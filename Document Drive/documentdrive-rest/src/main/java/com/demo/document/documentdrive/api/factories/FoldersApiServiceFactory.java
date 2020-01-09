package com.demo.document.documentdrive.api.factories;

import com.demo.document.documentdrive.api.FoldersApiService;
import com.demo.document.documentdrive.api.impl.FoldersApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-01-09T11:02:48.153Z[GMT]")public class FoldersApiServiceFactory {
    private final static FoldersApiService service = new FoldersApiServiceImpl();

    public static FoldersApiService getFoldersApi() {
        return service;
    }
}
