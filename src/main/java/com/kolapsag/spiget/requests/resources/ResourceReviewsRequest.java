package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class ResourceReviewsRequest extends ParameterizedSpigetRequest {

    private String request = "/resources/%d/reviews";

    public ResourceReviewsRequest(int resourceID) {
        Qualifications.checkInt(resourceID);
        request = String.format(request, resourceID);
    }
    public ResourceReviewsRequest(int resourceID, String additionalParameters) {
        this(resourceID);
        setUnsafeParameters(additionalParameters);
    }

    @Override
    public String getRequestMethod() { return request + parameterHandler.buildParameters(); }

}