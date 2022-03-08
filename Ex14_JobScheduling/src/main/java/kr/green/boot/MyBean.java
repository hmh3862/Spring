package kr.green.boot;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
    public void printMessage() {
        System.out.println("I am called by Spring scheduler");
    }
    
    public void printMessage2() {
    	System.out.println("나는 어떻게 실행될까요?");
    }

    public void printMessage3() {
    	System.out.println("하하하하하~~~~~~~~~~~~~~~~~");
    }
}