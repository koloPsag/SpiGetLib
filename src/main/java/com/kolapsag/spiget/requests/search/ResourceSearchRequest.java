package com.kolapsag.spiget.requests.search;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class ResourceSearchRequest extends ParameterizedSpigetRequest {

    private String request = "/search/resources/";

    public ResourceSearchRequest(String query) {
        Qualifications.checkString(query);
        request += query;
    }
    public ResourceSearchRequest(String query, String additionalParameters) {
        this(query);
        setUnsafeParameters(additionalParameters);
    }

    @Override
    public String getRequestMethod() { return request + parameterHandler.buildParameters(); }

}