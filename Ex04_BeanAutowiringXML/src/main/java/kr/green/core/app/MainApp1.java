package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Application;

public class MainApp1 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig1.xml");
		
		Application application = context.getBean("application", Application.class);
		System.out.println(application.getApplicationUser().getName() + "님이 애플리케이션을 사용합니다.");
		
		context.close();
	}
}
