package com.nhnacademy.node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.nhnacademy.message.Message;

public class StdOutNode extends OutputNode {

    @Override
    public Message process(Message message) {
        return message;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            while (true) {
                writer.write(pollOutputMessageQueue().toString());
                writer.flush();
            }
        } catch (IOException e) {

        }

    }

}
