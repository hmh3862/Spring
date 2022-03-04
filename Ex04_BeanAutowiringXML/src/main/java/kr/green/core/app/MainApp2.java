package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.ApplicationConfig;
import kr.green.core.vo.Application;

public class MainApp2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Application application = context.getBean("application", Application.class);
		System.out.println(application.getApplicationUser().getName() + "님이 애플리케이션을 사용합니다.");
		
		context.close();
	}
}
