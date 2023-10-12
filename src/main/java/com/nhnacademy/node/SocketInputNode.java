package com.nhnacademy.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.nhnacademy.message.Message;

/* socket in -> output message queue
 * socket에서 들어오는 데이터를 flow message로 만들어 flow에 넣는다
 * (서버 클라이언트로 들어온 메세지를 읽음)
 */
public class SocketInputNode extends InputNode {
    Message message;
    Socket socket;

    SocketInputNode(Socket socket, Message message) {
        super();
        this.message = message;
        this.socket = socket;
    }

    @Override
    public Message process(Message message) {
        return message;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (true) {
                this.message.setData(reader.readLine());
                addOutputMessageQueue(message);
            }
        } catch (IOException e) {
        }
    }

}
