package com.nhnacademy.node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketOutNode extends OutputNode {

    @Override
    public void run() {
        try (Socket socket = new Socket();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                writer.write(pollInputMessageQueue().toString());
                writer.flush();
            }
        } catch (IOException e) {

        }
    }

}
