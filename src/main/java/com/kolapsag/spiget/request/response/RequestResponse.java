package com.kolapsag.spiget.request.response;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public record RequestResponse(HttpURLConnection connection) {

    public JsonElement getResponse() throws IOException {
        return JsonParser.parseReader(getInputReader());
    }
    private InputStreamReader getInputReader() throws IOException {
        return new InputStreamReader(connection.getInputStream());
    }

    public JsonObject getResponseArrayAsObject() throws IOException {
        final JsonArray element = getResponse().getAsJsonArray();

        if (element.size() > 1) throw new IllegalStateException("JsonArray is too large to be an object!");

        return element.get(0).getAsJsonObject();
    }

}