package com.nhnacademy.node;

import java.util.Scanner;
import com.nhnacademy.message.StringMessage;

import lombok.extern.slf4j.Slf4j;

//Scanner로 들어오는 data를 MSG로 만들어서 flow에 넣기
@Slf4j
public class StdInNode extends InputNode {
    Scanner sc;

    public StdInNode() {
        this(1); // 다른 생성자 호출
    }

    public StdInNode(int count) {
        super(count);
    }

    // 앞에서 남긴 개행을 nextLine()이 읽고 입력으로 처리되어 입력 전 프로그램이 종료될까봐
    @Override
    void preprocess() {
        sc = new Scanner(System.in);
    }

    @Override
    void process() {
        log.info("enter a message : ");
        String inData = sc.nextLine();
        StringMessage message = new StringMessage(inData);

        output(message);
    }

    @Override
    void postprocess() {
        sc = null;
    }
}
