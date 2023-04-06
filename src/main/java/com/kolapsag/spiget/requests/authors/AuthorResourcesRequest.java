package com.kolapsag.spiget.requests.authors;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class AuthorResourcesRequest extends ParameterizedSpigetRequest {

    private String request = "/authors/%d/resources";

    public AuthorResourcesRequest(int authorID) {
        Qualifications.checkInt(authorID);
        request = String.format(request, authorID);
    }
    public AuthorResourcesRequest(int authorID, String additionalParameters) {
        this(authorID);
        setUnsafeParameters(additionalParameters);
    }

    @Override
    public String getRequestMethod() { return request + parameterHandler.buildParameters(); }

}