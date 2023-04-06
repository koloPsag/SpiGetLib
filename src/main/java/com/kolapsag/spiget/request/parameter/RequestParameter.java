package com.kolapsag.spiget.request.parameter;

public enum RequestParameter {

    FIELD("field"),
    METHOD("method"),
    SORT("sort"),
    SIZE("size"),
    PAGE("page"),
    FIELDS("fields");

    private final String key;

    RequestParameter(String key) { this.key = key; }

    public String getKey() { return key; }

    public static final RequestParameter[] values = values();

}