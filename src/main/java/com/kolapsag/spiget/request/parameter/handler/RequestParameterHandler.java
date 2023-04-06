package com.kolapsag.spiget.request.parameter.handler;

public class RequestParameterHandler {

    private final RequestUnsafeParameterHandler unsafeParamHandler = new RequestUnsafeParameterHandler();
    private final RequestTypeParameterHandler typeParamHandler = new RequestTypeParameterHandler();

    public String buildParameters() {
        if (areParametersEmpty()) return "";

        if (unsafeParamHandler.areParametersEmpty()) { return typeParamHandler.buildParameters(); }
        else return unsafeParamHandler.buildParameters();
    }
    private boolean areParametersEmpty() {
        return unsafeParamHandler.areParametersEmpty() && typeParamHandler.areParametersEmpty();
    }

    public void clearParameters() { unsafeParamHandler.clearParameters(); typeParamHandler.clearParameters(); }

    public RequestUnsafeParameterHandler getUnsafeParameterHandler() { return unsafeParamHandler; }
    public RequestTypeParameterHandler getTypeParameterHandler() { return typeParamHandler; }

}