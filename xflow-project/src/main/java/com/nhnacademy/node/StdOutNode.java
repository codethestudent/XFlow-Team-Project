package com.nhnacademy.node;

import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;

import lombok.extern.slf4j.Slf4j;

/* output message queue -> 출력
 * flow에서 처리된 결과를 stdout으로 출력함
 */
@Slf4j
public class StdOutNode extends OutputNode {

    public StdOutNode() {
        this(1);
    }

    public StdOutNode(int count) {
        super(count);
    }

    @Override
    void preprocess() {
        setInterval(1);
    }

    @Override
    void process() {
        for (int i = 0; i < getInputWireCount(); i++) {
            if (getInputWire(i).hasMessage()) {
                System.out.println(getInputWire(i));
                Message message = getInputWire(i).get();
                if (message instanceof StringMessage) {
                    System.out.println(((StringMessage) message).getPayload());
                }
            }
        }
    }
}
