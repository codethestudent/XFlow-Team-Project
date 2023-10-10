package com.nhnacademy.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nhnacademy.message.Message;

public class StdInputNode extends InputNode {
    Message message;

    StdInputNode() {
        super();
        message = new Message();
    }

    @Override
    public Message process(Message message) {
        return message;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                message.setData(reader.readLine());
                addInputMessageQueue(message);
            }
        } catch (IOException e) {
        }
    }
}
