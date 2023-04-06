package com.kolapsag.spiget.request.parameter.handler;

import com.kolapsag.spiget.request.parameter.validator.ParameterValidator;

public class RequestUnsafeParameterHandler {

    private String parameters = "";

    public void setUnsafeParameters(String parameters) { this.parameters = parameters; }

    public void setParameters(String parameters) {
        ParameterValidator.validateParameters(parameters);
        setUnsafeParameters(parameters); // safer in reality
    }

    public void clearParameters() { this.parameters = ""; }

    public boolean areParametersEmpty() { return parameters.isEmpty(); }

    public String buildParameters() { return RequestParameterBuilder.buildFromString(parameters); }

}