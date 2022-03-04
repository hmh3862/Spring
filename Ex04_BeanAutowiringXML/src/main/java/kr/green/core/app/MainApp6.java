package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Driver;

public class MainApp6 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig5.xml");
		
		Driver driver1 = context.getBean("driver1", Driver.class);
		System.out.println(driver1);
		
		Driver driver2 = context.getBean("driver2", Driver.class);
		System.out.println(driver2);
		
		Driver driver3 = context.getBean("driver3", Driver.class);
		System.out.println(driver3.getName() + "님의 면허번호는 " + driver3.getLicense().getNumber() + "입니다.");
		
		context.close();
	}
}
