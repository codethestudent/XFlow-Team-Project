package com.nhnacademy.test;

import com.nhnacademy.node.HttpClientNode;
import com.nhnacademy.node.HttpServerNode;
import com.nhnacademy.node.StdInNode;
import com.nhnacademy.node.StdOutNode;
import com.nhnacademy.wire.BufferedWire;
import com.nhnacademy.wire.Wire;

public class ServerTest {
    public static void main(String[] args) {
        StdInNode terminalInput = new StdInNode();
        StdOutNode terminalOutput = new StdOutNode();
        HttpServerNode server = new HttpServerNode("host");
        HttpClientNode client = new HttpClientNode("client", 8888);

        Wire wire1 = new BufferedWire();
        Wire wire2 = new BufferedWire();

        terminalInput.connectOutputWire(0, wire1);
        client.connectInputWire(0, wire1);
        client.connectOutputWire(0, wire2);
        terminalOutput.connectInputWire(0, wire2);

        terminalInput.start();
        server.start();
        client.start();
        terminalOutput.start();
    }
}