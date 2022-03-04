package kr.green.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.EncrytionAppConfig;
import kr.green.core.vo.EncrytionApp;

public class MainApp7 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EncrytionAppConfig.class);
		
		EncrytionApp encrytionApp1 = context.getBean("encrytionApp1", EncrytionApp.class);
		encrytionApp1.encrytion();
		
		EncrytionApp encrytionApp2 = context.getBean("encrytionApp2", EncrytionApp.class);
		encrytionApp2.encrytion();
		
		context.close();
	}
}
