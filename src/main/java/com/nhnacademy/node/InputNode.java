package com.nhnacademy.node;

import com.nhnacademy.message.Message;

public abstract class InputNode extends ActiveNode {
    public void addInputMessageQueue(Message message) {
        inputMessageQueue.add(message);
    }

    public void addOutputMessageQueue(Message message) {
        outputMessageQueue.add(message);
    }
}