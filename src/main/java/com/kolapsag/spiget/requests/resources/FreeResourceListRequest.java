package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;

public class FreeResourceListRequest extends ParameterizedSpigetRequest {

    public FreeResourceListRequest(String additionalParameters) { setUnsafeParameters(additionalParameters); }

    @Override
    public String getRequestMethod() { return "/resources/free" + parameterHandler.buildParameters(); }

}