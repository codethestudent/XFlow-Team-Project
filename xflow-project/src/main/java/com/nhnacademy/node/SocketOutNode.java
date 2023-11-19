package com.nhnacademy.node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketOutNode extends OutputNode {

    BufferedWriter socketOut;
    Socket socket;

    public SocketOutNode(Socket socket) {
        this(1);
        this.socket = socket;
    }

    public SocketOutNode(int count) {
        super(count);
    }

    @Override
    public void preprocess() {
        try {
            socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void process() {
        try {
            for (int i = 0; i < getInputWireCount(); i++) {
                Wire wire = getInputWire(i);
                if (wire != null && wire.hasMessage()) {
                    Message message = wire.get();
                    log.trace(((StringMessage) message).getPayload());
                    socketOut.write(((StringMessage) message).getPayload());
                    socketOut.write("\n");
                    socketOut.flush();
                    log.trace("socket out processed");
                }
            }

        } catch (IOException e) {
        }
    }
}
