package com.kolapsag.spiget.requests.categories;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;

public class CategoryListRequest extends ParameterizedSpigetRequest {

    public CategoryListRequest(String additionalParameters) { setUnsafeParameters(additionalParameters); }

    @Override
    public String getRequestMethod() { return "/categories" + parameterHandler.buildParameters(); }

}