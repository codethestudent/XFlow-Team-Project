package com.nhnacademy.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

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
        StringBuilder lines = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                lines.append(line + "\n");
            }
            StringMessage message = new StringMessage(lines.toString());
            output(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
