package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.config.ApplicationConfig1;
import kr.green.core.vo.Application;
import kr.green.core.vo.Bond;
import kr.green.core.vo.Driver;
import kr.green.core.vo.License;

public class MainApp1 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig1.class);
		
		Application application = context.getBean("application", Application.class);
		System.out.println(application.getApplicationUser().getName() + "님이 애플리케이션을 사용합니다.");
		
		//License license = context.getBean("license", License.class);
		//System.out.println(license);
		
		Driver driver = context.getBean("driver", Driver.class);
		System.out.println(driver.getName() + "님의 면허 : " + driver.getLicense().getNumber());
		
		Bond bond = context.getBean("bond", Bond.class);
		bond.showCar();
		
		context.close();
		
		System.out.println("--------------------------------------------------------------------------");
		//=====================================================================================================
		
		AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("appConfig.xml");
		
		Application application2 = context2.getBean("application", Application.class);
		System.out.println(application2.getApplicationUser().getName() + "님이 애플리케이션을 사용합니다.");
		
		context2.close();
		
		
	}
}
