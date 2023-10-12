package com.nhnacademy.node;

import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;

/* output message queue -> 출력
 * flow에서 처리된 결과를 stdout으로 출력함
 */
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
        for (int i = 0; i < getInputCount(); i++) {
            if (getInput(i).hasMessage()) {
                System.out.println(getInput(i));
                Message message = getInput(i).get();
                if (message instanceof StringMessage) {
                    System.out.println(((StringMessage) message).getPayload());
                }
            }
        }
    }
}
