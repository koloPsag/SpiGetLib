package com.kolapsag.spiget.requests.categories;

import com.kolapsag.spiget.request.SpigetRequest;
import com.kolapsag.spiget.util.Qualifications;

public class CategoryDetailsRequest implements SpigetRequest {

    private String request = "/categories/";

    public CategoryDetailsRequest(int categoryID) {
        Qualifications.checkInt(categoryID);
        request = String.format(request, categoryID);
    }

    @Override
    public String getRequestMethod() { return request; }

}