package com.kolapsag.spiget.requests.authors;

import com.kolapsag.spiget.request.ParameterizedSpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class AuthorReviewsRequest extends ParameterizedSpigetRequest {

    private String request = "/authors/%d/reviews";

    public AuthorReviewsRequest(int authorID) {
        Qualifications.checkInt(authorID);
        request = String.format(request, authorID);
    }
    public AuthorReviewsRequest(int authorID, String additionalParameters) {
        this(authorID);
        setUnsafeParameters(additionalParameters);
    }

    @Override
    public String getRequestMethod() { return request + parameterHandler.buildParameters(); }

}