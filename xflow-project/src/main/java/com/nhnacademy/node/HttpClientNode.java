package com.nhnacademy.node;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.nhnacademy.wire.BufferedWire;

import lombok.extern.slf4j.Slf4j;

/*
 * 터미널에서(system in)에서 저장한 wire을 읽고 output()메서드로 데이터 입력
 */

@Slf4j
public class HttpClientNode extends InputOutputNode {

    int port;
    Socket socket;
    BufferedWire socketInWire;
    BufferedWire socketOutWire;
    SocketInNode socketInNode;
    SocketOutNode socketOutNode;

    public HttpClientNode(String name, int port) {
        super(name, 2, 2);
        this.port = port;
    }

    public HttpClientNode(int port) {
        super(2, 2);
        this.port = port;
    }

    @Override
    public void preprocess() {
        try {
            socket = new Socket("localhost", port);
            socketInWire = new BufferedWire();
            socketOutWire = new BufferedWire();
            socketInNode = new SocketInNode(socket);
            socketOutNode = new SocketOutNode(socket);

            socketInNode.connectOutputWire(0, socketInWire);
            this.connectInputWire(1, socketInWire);
            socketOutNode.connectInputWire(0, socketOutWire);
            this.connectOutputWire(1, socketOutWire);
            socketInNode.start();
            socketOutNode.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process() {
        if (socket != null) {
            // log.trace("connected!");
        } else {
            log.trace("waiting for connectino..");
            this.preprocess();
        }

        if (socketInWire != null) {
            // std in -> socket out
            // log.trace("socket in wire not null");
            for (int i = 0; i < getInputWireCount(); i++) {
                if (getInputWire(i).hasMessage()) {
                    output(getInputWire(i).get());
                }
            }
        }

    }

}
