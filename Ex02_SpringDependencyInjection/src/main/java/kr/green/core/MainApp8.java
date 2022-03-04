package kr.green.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.EncrytionMessaging;

public class MainApp8 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig4.xml");
		
		EncrytionMessaging encrytionMessaging1 = context.getBean("encrytionMessaging1", EncrytionMessaging.class);
		encrytionMessaging1.getEncryption().EncryptData();
		encrytionMessaging1.getMessaging().sendMessage();
		System.out.println();
		
		EncrytionMessaging encrytionMessaging2 = context.getBean("encrytionMessaging2", EncrytionMessaging.class);
		encrytionMessaging2.getEncryption().EncryptData();
		encrytionMessaging2.getMessaging().sendMessage();
		System.out.println();
		
		EncrytionMessaging encrytionMessaging3 = context.getBean("encrytionMessaging3", EncrytionMessaging.class);
		encrytionMessaging3.getEncryption().EncryptData();
		encrytionMessaging3.getMessaging().sendMessage();
		System.out.println();
		
		EncrytionMessaging encrytionMessaging4 = context.getBean("encrytionMessaging4", EncrytionMessaging.class);
		encrytionMessaging4.getEncryption().EncryptData();
		encrytionMessaging4.getMessaging().sendMessage();
		System.out.println();
		
		context.close();
	}
}
