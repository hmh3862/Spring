package kr.green.boot.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.boot.service.MailService;

public class MainApp2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");
		
		MailService mailService = context.getBean("mailService", MailService.class);
		
		mailService.sendEmail("itsungnam202106@gmail.com", "하하하하 제목!!!!", "<h1>꽝!!! 난 해커</h1>"); 
		
		context.close();
	}
}
