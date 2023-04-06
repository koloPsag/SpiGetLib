package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class ResourceVersionsRequest extends ParameterizedSpigetRequest {

    private String request = "/resources/%d/versions";

    public ResourceVersionsRequest(int resourceID) {
        Qualifications.checkInt(resourceID);
        request = String.format(request, resourceID);
    }
    public ResourceVersionsRequest(int resourceID, String additionalParameters) {
        this(resourceID);
        setUnsafeParameters(additionalParameters);
    }

    @Override
    public String getRequestMethod() { return request + parameterHandler.buildParameters(); }

}