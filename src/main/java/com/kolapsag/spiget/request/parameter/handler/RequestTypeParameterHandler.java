package com.kolapsag.spiget.request.parameter.handler;

import com.kolapsag.spiget.request.parameter.RequestParameter;
import com.kolapsag.spiget.request.parameter.validator.ArgumentValidator;

import java.util.HashMap;
import java.util.Map;

public class RequestTypeParameterHandler {

    private final Map<RequestParameter, String> paramMap = new HashMap<>();

    public void setParameter(RequestParameter param, String value) {
        if (value == null || param == null || value.isBlank()) return;

        ArgumentValidator.validateArgument(param, value);

        paramMap.put(param, value);
    }

    public void removeParameters(RequestParameter... parameters) {
        for (RequestParameter param : parameters) { paramMap.remove(param); }
    }

    public void clearParameters() { paramMap.clear(); }

    public boolean areParametersEmpty() { return paramMap.isEmpty(); }

    public String buildParameters() { return RequestParameterBuilder.buildFromMap(paramMap); }

    public Map<RequestParameter, String> getParameterMap() { return paramMap; }

}