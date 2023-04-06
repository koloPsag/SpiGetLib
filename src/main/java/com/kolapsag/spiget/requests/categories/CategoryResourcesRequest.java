package com.kolapsag.spiget.requests.categories;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class CategoryResourcesRequest extends ParameterizedSpigetRequest {

    private String request = "/categories/%d/resources";

    public CategoryResourcesRequest(int categoryID) {
        Qualifications.checkInt(categoryID);
        request = String.format(request, categoryID);
    }
    public CategoryResourcesRequest(int categoryID, String additionalParameters) {
        this(categoryID);
        setUnsafeParameters(additionalParameters);
    }

    @Override
    public String getRequestMethod() { return request + parameterHandler.buildParameters(); }

}