package kr.green.boot;

import org.springframework.scheduling.annotation.Scheduled;

public class MyBean {
	
	@Scheduled(fixedDelay = 5000)
	public void printMessage() {
        System.out.println("I am called by Spring scheduler");
    }
    
	@Scheduled(initialDelay = 1000, fixedDelay = 3000)
    public void printMessage2() {
    	System.out.println("나는 어떻게 실행될까요?");
    }
	
	@Scheduled(cron = "*/3 * * * * *")
    public void printMessage3() {
    	System.out.println("하하하하하~~~~~~~~~~~~~~~~~");
    }
}