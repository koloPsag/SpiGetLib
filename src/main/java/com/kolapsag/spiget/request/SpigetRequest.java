package com.kolapsag.spiget.request;

import com.kolapsag.spiget.request.response.RequestResponse;
import com.kolapsag.spiget.util.ConnectionOpener;

import java.io.IOException;

public interface SpigetRequest {

    String URL = "https://api.spiget.org/v2";

    String getRequestMethod();

    default RequestResponse request() throws IOException { return requestWithUserAgent("Mozilla/5.0"); }
    default RequestResponse requestWithUserAgent(String userAgent) throws IOException {
        return customRequest(getRequestMethod(), userAgent);
    }
    static RequestResponse customRequest(String url, String userAgent) throws IOException {
        return new RequestResponse(ConnectionOpener.openConnectionWithUserAgent(URL + url, userAgent));
    }

}