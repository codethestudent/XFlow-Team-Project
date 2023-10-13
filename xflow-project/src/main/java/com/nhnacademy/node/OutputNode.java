package com.nhnacademy.node;

import com.nhnacademy.exception.AlreadyExistsException;
import com.nhnacademy.exception.InvalidArgumentException;
import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.port.Port;
import com.nhnacademy.wire.Wire;

public abstract class OutputNode extends ActiveNode {
    Port[] ports;
    Wire[] inputWires;

    /*
     * 추가된 부분
     */
    OutputNode(String name, int count) {
        super(name);
        if (count <= 0) {
            throw new InvalidArgumentException();
        }

        inputWires = new Wire[count];
    }

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

    /*
     * 추가된 부분
     */
    public void connectInputWire(int index, Wire wire) {
        if (inputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        if (inputWires[index] != null) {
            throw new AlreadyExistsException();
        }

        inputWires[index] = wire;
    }

    public int getInputWireCount() {
        return inputWires.length;
    }

    public Wire getInputWire(int index) {
        if (index < 0 || inputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        return inputWires[index];
    }

}
