package com.nhnacademy.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;

public class SocketInNode extends InputNode {
    BufferedReader reader;
    Socket socket;

    public SocketInNode(Socket socket) {
        this(1);
        this.socket = socket;
    }

    public SocketInNode(int count) {
        super(count);
    }

    @Override
    void preprocess() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void process() {
        String line;
        try {
            line = reader.readLine();
            StringMessage message = new StringMessage(line);
            output(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void postprocess() {
        socket = null;
    }

}
