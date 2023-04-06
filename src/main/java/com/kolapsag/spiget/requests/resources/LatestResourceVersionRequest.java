package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.SpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class LatestResourceVersionRequest implements SpigetRequest {

    private String request = "/resources/%d/versions/latest";

    public LatestResourceVersionRequest(int resourceID) {
        Qualifications.checkInt(resourceID, "I HOPE YOU DIE");
        request = String.format(request, resourceID);
    }

    @Override
    public String getRequestMethod() { return request; }

}