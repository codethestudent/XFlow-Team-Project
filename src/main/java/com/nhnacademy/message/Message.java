package com.nhnacademy.message;

public abstract class Message {
    private String data;
    static int count;

    Message() {
        count++;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
