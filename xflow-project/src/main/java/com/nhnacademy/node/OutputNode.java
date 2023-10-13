package com.nhnacademy.node;

import com.nhnacademy.exception.InvalidArgumentException;
import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.port.Port;

public abstract class OutputNode extends ActiveNode {
    Port[] ports;

    OutputNode(int count) {
        super();
        if (count <= 0) {
            throw new InvalidArgumentException();
        }

        ports = new Port[count];
        for (int i = 0; i < count; i++) {
            ports[i] = new Port();
        }
    }

    public int getInputCount() {
        return ports.length;
    }

    public Port getInput(int index) {
        if (index < 0 || ports.length <= index) {
            throw new OutOfBoundsException();
        }

        return ports[index];
    }
}
