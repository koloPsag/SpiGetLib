package com.kolapsag.spiget.requests.resources;

import com.kolapsag.spiget.request.SpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class ResourceVersionRequest implements SpigetRequest {

    private String request = "/resources/%d/versions/%d";

    public ResourceVersionRequest(int resourceID, int versionID) {
        Qualifications.checkInts("One or more numbers are < 0", resourceID, versionID);
        request = String.format(request, resourceID, versionID);
    }

    @Override
    public String getRequestMethod() { return request; }

}