package com.kolapsag.spiget.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.function.Consumer;

public class ConnectionOpener {

    private ConnectionOpener() {} // Disable instantiation

    public static HttpURLConnection openConnection(String url) throws IOException {
        return (HttpURLConnection) new URL(url).openConnection();
    }
    public static HttpURLConnection openConnection(String url, Consumer<HttpURLConnection> before) throws IOException {
        final HttpURLConnection connection = openConnection(url);

        before.accept(connection);

        return connection;
    }
    public static HttpURLConnection openConnectionWithUserAgent(String url, String userAgent) throws IOException {
        return openConnection(url, connection -> connection.setRequestProperty("User-Agent", userAgent));
    }

}