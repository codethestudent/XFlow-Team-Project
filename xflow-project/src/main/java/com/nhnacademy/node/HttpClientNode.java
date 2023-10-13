package com.nhnacademy.node;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClientNode extends InputOutputNode {

    int port;

    HttpClientNode(int inCount, int outCount) {
        super(inCount, outCount);
    }

    HttpClientNode(int inCount, int outCount, int port) {
        this(inCount, outCount);
        this.port = port;
    }

    @Override
    public void preprocess() {
        log.trace("trying to get connection");
    }

    @Override
    public void process() {
        try (Socket socket = new Socket("localhost", port)) {

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
