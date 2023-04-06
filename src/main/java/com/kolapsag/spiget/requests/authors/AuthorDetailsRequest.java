package com.kolapsag.spiget.requests.authors;

import com.kolapsag.spiget.request.SpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class AuthorDetailsRequest implements SpigetRequest {

    private String request = "/authors/";

    public AuthorDetailsRequest(int authorID) {
        Qualifications.checkInt(authorID);
        request += authorID;
    }

    @Override
    public String getRequestMethod() { return request; }

}