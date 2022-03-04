package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.config.ApplicationConfig1;
import kr.green.core.controller.EmpController;
import kr.green.core.vo.EmpVO;

public class MainApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig1.class);
		EmpController empController = context.getBean("empController", EmpController.class);
		empController.insert(new EmpVO(1001, "한사람"));
		System.out.println("DB 시간 : " + empController.selectNow());
		context.close();
		
		
		AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("appConfig.xml");
		EmpController empController2 = context2.getBean("empController", EmpController.class);
		empController2.insert(new EmpVO(1002, "두사람"));
		System.out.println("DB 시간 : " + empController2.selectNow());
		context2.close();
	}
}
