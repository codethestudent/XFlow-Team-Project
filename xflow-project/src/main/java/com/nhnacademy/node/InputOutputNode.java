package com.nhnacademy.node;

import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.message.Message;
import com.nhnacademy.port.Port;

public abstract class InputOutputNode extends ActiveNode {
    final Port[] ports;
    final Port[] peerPorts;

    InputOutputNode(int inCount, int outCount) {
        super();

        ports = new Port[inCount];
        for (int i = 0; i < ports.length; i++) {
            ports[i] = new Port();
        }

        peerPorts = new Port[outCount];
    }

    public void connect(int index, Port port) {
        if (index < 0 || peerPorts.length <= index) {
            throw new OutOfBoundsException();
        }

        peerPorts[index] = port;
    }

    public int getInputPortCount() {
        return ports.length;
    }

    public Port getInputPort(int index) {
        if (index < 0 || ports.length <= index) {
            throw new OutOfBoundsException();
        }

        return ports[index];
    }

    void output(Message message) {
        for (Port port : peerPorts) {
            if (port != null) {
                port.put(message);
            }
        }
    }
}
