package com.nhnacademy.node;

import java.util.ArrayList;
import java.util.List;
import com.nhnacademy.message.StringMessage;
import com.nhnacademy.wire.BufferedWire;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TraceNode extends OutputNode {

    static TraceNode traceNode;

    private TraceNode() {
        super(1); // Message 종류만큼 생성해야함
    }

    public static TraceNode getTraceNode() {
        if (traceNode == null) {
            traceNode = new TraceNode(); // instance 이름 생성할때는 new();
        }
        return traceNode;
    }

    /*
     * TODO :
     * secret, 400, 500 단어 포함되어있는지 확인해주세요.
     * 있다면 예외처리
     */

    @Override
    void preprocess() {

    }

    @Override
    void process() {
        for (Wire wire : inputWires) { // for문 돌면서 list에 있는 값을 차례대로 wire에 하나씩 넣어줌
            if (wire.hasMessage()) {
                log.trace(((StringMessage) wire.get()).getPayload()); // get의 반환 type : Message
            }
        }
    }

    @Override
    void postprocess() {
        inputWires = null; // wire 안 비워주기
    }

}
