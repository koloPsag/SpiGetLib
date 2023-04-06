package com.kolapsag.spiget.requests.status;

import com.kolapsag.spiget.request.SpigetRequest;

public class SpiGetStatusRequest implements SpigetRequest {

    @Override public String getRequestMethod() { return "/status"; }

}