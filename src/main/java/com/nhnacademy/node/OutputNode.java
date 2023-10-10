package com.nhnacademy.node;

import com.nhnacademy.message.Message;

public abstract class OutputNode extends ActiveNode {
    public Message pollOutputMessageQueue() {
        return outputMessageQueue.poll();
    }

    public Message pollInputMessageQueue() {
        return inputMessageQueue.poll();
    }
}