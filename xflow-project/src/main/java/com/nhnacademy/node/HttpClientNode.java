package com.nhnacademy.node;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

/*
 * 터미널에서(system in)에서 저장한 wire을 읽고 output()메서드로 데이터 입력
 */

@Slf4j
public class HttpClientNode extends InputOutputNode {

    int port;

    HttpClientNode(String name, int port) {
        super(name, 1, 1);
        this.port = port;
    }

    HttpClientNode(int port) {
        super(1, 1);
        this.port = port;
    }

    @Override
    public void process() {
        try (Socket socket = new Socket("localhost", port)) {
            log.trace("connected!");
            // std in -> socket out
            for (int i = 0; i < getInputWireCount(); i++) {
                if ((getInputWire(i) != null) && (getInputWire(i).hasMessage())) {
                    output(getInputWire(i).get());
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
