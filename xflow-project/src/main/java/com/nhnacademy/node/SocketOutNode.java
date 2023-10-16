package com.nhnacademy.node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import com.nhnacademy.message.Message;
import com.nhnacademy.wire.Wire;

public class SocketOutNode extends OutputNode {

    Socket socket;

    public SocketOutNode(Socket socket) {
        super(count);
        this.socket = socket;
    }

    @Override
    public void process() {

        try {
            BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            for (int i = 0; i < getInputWireCount(); i++) {
                Wire wire = getInputWire(i);
                if (wire != null && wire.hasMessage()) {
                    Message message = wire.get();
                    socketOut.write(message.toString());
                    socketOut.flush();
                }
            }

        } catch (IOException e) {
        }
    }
}
