package com.nhnacademy.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.nhnacademy.message.Message;

public class SocketInputNode extends InputNode {
    Message message;

    SocketInputNode() {
        super();
        message = new Message();
    }

    @Override
    public Message process(Message message) {
        return message;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 80);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (true) {
                this.message.setData(reader.readLine());
                addOutputMessageQueue(message);
            }
        } catch (IOException e) {
        }
    }

}
