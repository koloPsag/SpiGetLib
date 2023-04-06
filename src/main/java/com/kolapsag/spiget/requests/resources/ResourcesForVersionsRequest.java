package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class ResourcesForVersionsRequest extends ParameterizedSpigetRequest {

    private String request = "/resources/for/";

    public ResourcesForVersionsRequest(String versions) {
        Qualifications.checkString(versions);
        request += versions;
    }
    public ResourcesForVersionsRequest(String versions, String additionalParameters) {
        this(versions);
        setUnsafeParameters(additionalParameters);
    }

    @Override
    public String getRequestMethod() { return request + parameterHandler.buildParameters(); }

}