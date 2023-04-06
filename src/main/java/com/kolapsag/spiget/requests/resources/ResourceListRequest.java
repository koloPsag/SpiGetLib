package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;

public class ResourceListRequest extends ParameterizedSpigetRequest {

    public ResourceListRequest(String additionalParameters) { setUnsafeParameters(additionalParameters); }

    @Override
    public String getRequestMethod() { return "/resources" + parameterHandler.buildParameters(); }

}