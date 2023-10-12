package com.nhnacademy.node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.nhnacademy.message.Message;

/* output message queue -> 출력
 * flow에서 처리된 결과를 stdout으로 출력함
 */
public class StdOutNode extends OutputNode {

    Message message;

    StdOutNode(Message message) {
        super();
        this.message = message;
    }

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
