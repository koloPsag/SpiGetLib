package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;

public class PremiumResourceListRequest extends ParameterizedSpigetRequest {

    public PremiumResourceListRequest(String additionalParameters) { setUnsafeParameters(additionalParameters); }

    @Override
    public String getRequestMethod() { return "/resources/premium" + parameterHandler.buildParameters(); }

}