package com.nhnacademy.node;

import com.nhnacademy.message.StringMessage;
import com.nhnacademy.message.URLMessage;
import com.nhnacademy.wire.Wire;

public class URLParsingNode extends InputOutputNode {
    private String url;
    private String scheme;
    private String host;
    private int port = 1234;

    public URLParsingNode() {
        super(1, 1);
    }

    // public URLParsingNode(int inCount, int outCount) {
    // super(inCount, outCount);
    // }

    // public URLParsingNode(String name, int inCount, int outCount) {
    // super(name, inCount, outCount);
    // }

    @Override
    void process() {
        for (Wire inWire : inputWires) {
            if (inWire.hasMessage()) {
                String uri = ((StringMessage) inWire.get()).getPayload();
                String[] splitURI = uri.split("://");
                scheme = splitURI[0];
                url = splitURI[1];
                if (url.contains(":")) {
                    host = url.split(":")[0];
                    port = Integer.parseInt(url.split(":")[1]);
                } else {
                    host = url;
                }
            }
            URLMessage message = new URLMessage(url, scheme, host, port);
            for (Wire outWire : outputWires) {
                outWire.put(message);
            }
        }
    }

}
