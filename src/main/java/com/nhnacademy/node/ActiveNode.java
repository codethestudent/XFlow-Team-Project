package com.nhnacademy.node;

import java.util.LinkedList;
import java.util.Queue;

import com.nhnacademy.message.Message;

public abstract class ActiveNode extends Node implements Runnable {
    Thread thread;
    static Queue<Message> inputMessageQueue = new LinkedList<>();
    static Queue<Message> outputMessageQueue = new LinkedList<>();

    ActiveNode() {
        super();
        thread = new Thread(this, getId());
    }

    ActiveNode(String name) {
        this();
        setName(name);
    }

    public Message process(Message message) {
        return message;
    }

    @Override
    public String getName() {
        return thread.getName();
    }

    @Override
    public void setName(String name) {
        thread.setName(name);
    }

}
