package com.nhnacademy.node;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Node {
    static int count;
    String id;

    public Node() {
        count++;
        id = String.format("%s-%02d", getClass().getSimpleName(), count);
        log.trace("create node : {}", id);
    }// 기본 생성자

    public static int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public abstract String getName();

    public abstract void setName(String name);
}
