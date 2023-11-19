package com.nhnacademy.test;

import java.net.http.HttpClient;

import com.nhnacademy.node.HttpClientNode;
import com.nhnacademy.node.StdInNode;
import com.nhnacademy.wire.BufferedWire;
import com.nhnacademy.wire.Wire;

public class FlowTest {
    public static void main(String[] args) {
        HttpClientNode client = new HttpClientNode("client", 8888);
        StdInNode stdInNode = new StdInNode();

        Wire wire1 = new BufferedWire();

        client.connectInputWire(0, wire1);
        stdInNode.connectOutputWire(0, wire1);
        stdInNode.start();
        client.start();
    }
}
