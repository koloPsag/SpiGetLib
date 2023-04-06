package com.kolapsag.spiget.requests.authors;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;

public class AuthorListRequest extends ParameterizedSpigetRequest {

    public AuthorListRequest(String additionalParameters) { setUnsafeParameters(additionalParameters); }

    @Override
    public String getRequestMethod() { return "/authors" + parameterHandler.buildParameters(); }

}