package com.nhnacademy.message;

public class URLMessage extends StringMessage {
    private String url;
    private String scheme;
    private String host;
    private int port;

    public URLMessage(String url, String scheme, String host, int port) {
        this(url + scheme + host + port);
        this.url = url;
        this.scheme = scheme;
        this.host = host;
        this.port = port;
    }

    public URLMessage(String payload) {
        super(payload);
    }

    public String getUrl() {
        return url;
    }

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

}
