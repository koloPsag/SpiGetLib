package com.kolapsag.spiget.request.parameter.handler;

import com.kolapsag.spiget.request.parameter.RequestParameter;

import java.util.Map;

public class RequestParameterBuilder {

    public static String buildFromString(String parameters) { return '?' + parameters; }
    public static String buildFromMap(Map<RequestParameter, String> parameters) {
        final StringBuilder builder = new StringBuilder().append('?');

        parameters.forEach((parameter, value) -> concatenateToBuilder(builder, parameter, value));

        return builder.toString();
    }
    private static void concatenateToBuilder(StringBuilder builder, RequestParameter parameter, String value) {
        builder.append(parameter.getKey()).append("=").append(value).append("&");
    }

}