package com.nhnacademy.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nhnacademy.message.Message;

/* 입력 -> input message queue
 * stdin으로 들어오는 데이터를 flow 메시지로 만들어 flow에 넣는다
 */
public class StdInputNode extends InputNode {
    Message message;

    StdInputNode(Message message) {
        super();
        this.message = message;
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
