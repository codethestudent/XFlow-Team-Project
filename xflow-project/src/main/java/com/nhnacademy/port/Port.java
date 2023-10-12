package com.nhnacademy.port;

import java.util.LinkedList;
import java.util.Queue;

import com.nhnacademy.message.Message;

public class Port {
    // 메세지를 저장하는 큐
    Queue<Message> messageQueue;


    public Port() {
        // 포트 생성시 메시지 큐 생성
        messageQueue = new LinkedList<>();
    }

    // 큐에 메시지를 넣는 put 메서드
    public void put(Message message) {
        messageQueue.add(message);
    }

    // 큐가 비어있는지 안비어있는지 상태 지정해주는 hasMessage 메서드
    public boolean hasMessage() {
        return !messageQueue.isEmpty();
    }

    // 큐에서 메시지를 가져오는 get 메서드
    public Message get() {
        return messageQueue.poll();
    }
}
