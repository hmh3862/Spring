package kr.green.boot.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.boot.config.AppConfig;
import kr.green.boot.service.MailService;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MailService mailService = context.getBean("mailService", MailService.class);
		
		// mailService.sendEmail();
		mailService.sendEmail("itsungnam202111@gmail.com", "하하하하 제목!!!!", "<h1>꽝!!! 난 해커</h1>"); 
		mailService.sendEmail("itsungnam202106@gmail.com", "하하하하 제목!!!!", "<h1>꽝!!! 난 해커</h1>"); 
		
		context.close();
	}
}
