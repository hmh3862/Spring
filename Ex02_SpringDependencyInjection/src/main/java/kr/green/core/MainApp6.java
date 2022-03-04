package kr.green.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.EncrytionApp;

public class MainApp6 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig3.xml");
		
		EncrytionApp encrytionApp1 = context.getBean("encrytionApp1", EncrytionApp.class);
		encrytionApp1.encrytion();
		
		EncrytionApp encrytionApp2 = context.getBean("encrytionApp2", EncrytionApp.class);
		encrytionApp2.encrytion();
		
		context.close();
	}
}
