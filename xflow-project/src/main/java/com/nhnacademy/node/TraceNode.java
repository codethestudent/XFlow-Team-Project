package com.nhnacademy.node;

import java.util.ArrayList;
import java.util.List;
import com.nhnacademy.message.StringMessage;
import com.nhnacademy.wire.BufferedWire;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TraceNode extends OutputNode {
    List<BufferedWire> connectWires = new ArrayList<>();

    static TraceNode traceNode;

    private TraceNode() {
        super(count);
    }

    public static TraceNode getTraceNode() {
        if (traceNode == null) {
            traceNode = new TraceNode(); // instance 이름 생성할때는 new();
        }
        return traceNode;
    }

    // wire 생성, connectWire에 저장
    public void connect(InputNode inputNode) {
        BufferedWire wire = new BufferedWire();
        connectWires.add(wire);
        inputNode.traceWire = wire;
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
        for (BufferedWire w : connectWires) { // for문 돌면서 list에 있는 값을 차례대로 w에 하나씩 넣어줌
            if (w.hasMessage()) {
                log.trace(((StringMessage) w.get()).getPayload()); // get의 반환 type : Message
            }
        }
    }

    @Override
    void postprocess() {
        connectWires.clear(); // wire 안 비워주기
    }

}
