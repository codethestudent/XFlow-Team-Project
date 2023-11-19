package com.nhnacademy.test;

import com.nhnacademy.node.HttpServerNode;

public class ServerTest {
    public static void main(String[] args) {
        HttpServerNode server = new HttpServerNode("host");
        server.start();
    }
}