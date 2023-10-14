package com.nhnacademy.node;

import java.util.Scanner;
import com.nhnacademy.message.StringMessage;

//Scanner로 들어오는 data를 MSG로 만들어서 flow에 넣기
public class StdInNode extends InputNode {
    Scanner sc = new Scanner(System.in);

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
        String inData = sc.nextLine();
        StringMessage message = new StringMessage(inData);

        output(message);
    }

    @Override
    void postprocess() {
        sc = null;
    }
}
