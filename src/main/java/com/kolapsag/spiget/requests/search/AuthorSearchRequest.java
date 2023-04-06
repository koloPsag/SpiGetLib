package com.kolapsag.spiget.requests.search;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class AuthorSearchRequest extends ParameterizedSpigetRequest {

    private String request = "/search/authors/";

    public AuthorSearchRequest(String query) {
        Qualifications.checkString(query);
        request += query;
    }
    public AuthorSearchRequest(String query, String additionalParameters) {
        this(query);
        setUnsafeParameters(additionalParameters);
    }

    @Override
    public String getRequestMethod() { return request + parameterHandler.buildParameters(); }

}