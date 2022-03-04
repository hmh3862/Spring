package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Emp;

public class MainApp4 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig3.xml");
		
		Emp emp = context.getBean("emp", Emp.class);
		System.out.println(emp);
		
		context.close();
	}
}
