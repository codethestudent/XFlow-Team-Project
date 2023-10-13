package com.nhnacademy.node;

import com.nhnacademy.exception.AlreadyExistsException;
import com.nhnacademy.exception.InvalidArgumentException;
import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;
import com.nhnacademy.wire.BufferedWire;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SelectionNode extends ActiveNode {

    Wire[] inputWires;
    Wire[] outputWires;


    SelectionNode(String name, int count) {
        super(name);

        if (count <= 0) {
            throw new InvalidArgumentException();
        }

        inputWires = new Wire[count];

        outputWires = new Wire[3];
        outputWires[0] = new BufferedWire();
        outputWires[1] = new BufferedWire();
        outputWires[2] = new BufferedWire();

    }

    SelectionNode(int count) {
        super();

        if (count <= 0) {
            throw new InvalidArgumentException();
        }

        outputWires = new Wire[3];
        outputWires[0] = new BufferedWire();
        outputWires[1] = new BufferedWire();
        outputWires[2] = new BufferedWire();
    }



    public int getOutputWireCount() {
        return outputWires.length;
    }

    public Wire getoutputWire(int index) {
        if (index < 0 || outputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        return outputWires[index];
    }

    void output(Message message) {
        // log.trace("Message Out");
        // for (Wire wire : outputWires) {
        // if (wire != null) {
        // wire.put(message);
        // }
        // }

        if (message instanceof StringMessage) {


            log.trace("String Message Out");
            outputWires[0].put(message);

        } else if (message instanceof LongMessage) {

            log.trace("Long Message Out");
            outputWires[1].put(message);

        } else if (message instanceof IntMessage) {

            log.trace("Int Message Out");
            outputWires[2].put(message);
        }
    }

}
