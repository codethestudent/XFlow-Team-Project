package com.nhnacademy.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.nhnacademy.message.StringMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    public void process() {
        StringBuilder lines = new StringBuilder();
        try {
            // Check if reader is ready, i.e., if there's data to be read
            if (reader.ready()) {
                String line;
                // Read lines as long as there is data available
                while (reader.ready() && (line = reader.readLine()) != null) {
                    lines.append(line).append("\n");
                    log.trace(line.toString());
                }
                StringMessage message = new StringMessage(lines.toString());
                output(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
