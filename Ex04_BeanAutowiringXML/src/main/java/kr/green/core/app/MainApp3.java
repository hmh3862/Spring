package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Application;

public class MainApp3 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig2.xml");
		
		Application application1 = context.getBean("application1", Application.class);
		System.out.println(application1.getApplicationUser().getName() + "님이 애플리케이션을 사용합니다.");
		
		Application application2 = context.getBean("application2", Application.class);
		System.out.println(application2.getApplicationUser().getName() + "님이 애플리케이션을 사용합니다.");
		
		Application application3 = context.getBean("application3", Application.class);
		System.out.println(application3.getApplicationUser().getName() + "님이 애플리케이션을 사용합니다.");

		Application application4 = context.getBean("application4", Application.class);
		System.out.println(application4.getApplicationUser());
		
		Application application5 = context.getBean("application5", Application.class);
		System.out.println(application5.getApplicationUser());
		
		context.close();
	}
}
