package com.kolapsag.spiget.request;

import com.kolapsag.spiget.request.parameter.RequestParameter;
import com.kolapsag.spiget.request.parameter.handler.RequestParameterHandler;
import com.kolapsag.spiget.request.parameter.handler.RequestTypeParameterHandler;
import com.kolapsag.spiget.request.parameter.handler.RequestUnsafeParameterHandler;

public abstract class ParameterizedSpigetRequest implements SpigetRequest {

    protected final RequestParameterHandler parameterHandler = new RequestParameterHandler();
    protected final RequestUnsafeParameterHandler unsafeParamHandler = parameterHandler.getUnsafeParameterHandler();
    protected final RequestTypeParameterHandler typeParamHandler = parameterHandler.getTypeParameterHandler();

    public void setParameters(String parameters) { unsafeParamHandler.setParameters(parameters); }
    public void setParameter(RequestParameter parameter, String value) { typeParamHandler.setParameter(parameter, value); }
    public void setUnsafeParameters(String parameters) { unsafeParamHandler.setUnsafeParameters(parameters); }

    public void clearParameters() { parameterHandler.clearParameters(); }
    public void clearUnsafeParameters() { unsafeParamHandler.clearParameters(); }
    public void clearTypeParameters() { typeParamHandler.clearParameters(); }

    public void removeTypeParameters(RequestParameter... parameters) { typeParamHandler.removeParameters(parameters); }

}