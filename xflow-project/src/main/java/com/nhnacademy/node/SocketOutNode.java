package com.nhnacademy.node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import com.nhnacademy.message.Message;

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

            for (int i = 0; i < getInputCount(); i++) {
                if (getInput(i).hasMessage()) {
                    Message message = getInput(i).get();
                    // 객체를 String으로 형변환을 해줘야함
                    socketOut.write(message.toString());
                    socketOut.flush();
                }

            }

        } catch (IOException e) {
            //

        }

    }

}
