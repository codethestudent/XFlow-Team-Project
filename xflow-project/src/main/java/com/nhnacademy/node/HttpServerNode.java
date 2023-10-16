package com.nhnacademy.node;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.nhnacademy.wire.BufferedWire;

/*
 * 음,,, 일단 여기선 서버를 열긴 해야하는데 이제,,, json 파일도 ems로 부터 요청을 해야해서
 */

public class HttpServerNode extends InputOutputNode {
    ServerSocket serverSocket;
    int port = 8888;
    Socket socket;
    BufferedWire socketInWire;
    BufferedWire socketOutWire;
    SocketInNode socketInNode;
    SocketOutNode socketOutNode;

    public HttpServerNode(String name) {
        super(name, 1, 1);
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void preprocess() {
        try {
            serverSocket = new ServerSocket(port);
            socketInWire = new BufferedWire();
            socketOutWire = new BufferedWire();
            socketInNode = new SocketInNode(socket);
            socketOutNode = new SocketOutNode(socket);

            socketInNode.connectOutputWire(0, socketInWire);
            this.connectInputWire(0, socketInWire);
            this.connectOutputWire(0, socketOutWire);
            socketOutNode.connectInputWire(0, socketOutWire);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process() {
        try {
            socket = serverSocket.accept();
            if (socketInWire != null) {
                for (int i = 0; i < getInputWireCount(); i++) {
                    if ((getInputWire(i) != null) && (getInputWire(i).hasMessage())) {
                        output(getInputWire(i).get());
                    }
                }
                socketInNode.start();
                socketOutNode.start();
            }
        } catch (IOException e) {
        }
    }
}
