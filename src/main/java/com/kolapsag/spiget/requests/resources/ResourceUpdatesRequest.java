package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class ResourceUpdatesRequest extends ParameterizedSpigetRequest {

    private String request = "/resources/%d/updates";

    public ResourceUpdatesRequest(int resourceID) {
        Qualifications.checkInt(resourceID);
        request = String.format(request, resourceID);
    }
    public ResourceUpdatesRequest(int resourceID, String additionalParameters) {
        this(resourceID);
        setUnsafeParameters(additionalParameters);
    }

    @Override
    public String getRequestMethod() { return request + parameterHandler.buildParameters(); }

}