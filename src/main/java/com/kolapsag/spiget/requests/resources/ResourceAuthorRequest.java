package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.SpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class ResourceAuthorRequest implements SpigetRequest {

    private String request = "/resources/%d/author";

    public ResourceAuthorRequest(int resourceID) {
        Qualifications.checkInt(resourceID);
        request = String.format(request, resourceID);
    }

    @Override
    public String getRequestMethod() { return request; }

}