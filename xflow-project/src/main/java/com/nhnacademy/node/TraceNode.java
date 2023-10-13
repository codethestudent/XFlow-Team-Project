package com.nhnacademy.node;

import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

public class TraceNode extends OutputNode {
    // 출력 log, exception
    public TraceNode() {
        super(count);
    }


    // void preprocess() {

    // }

    // port번호별로 log 줘야하나?
    @Override
    void process() {
        Logger log = LoggerFactory.getLogger();
        log.info("");
    }

    @Override
    void postprocess() {

    }
}
