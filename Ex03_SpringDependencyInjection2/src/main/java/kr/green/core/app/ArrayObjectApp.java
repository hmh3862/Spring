package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.ArrayObject;

public class ArrayObjectApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("arrayConfig.xml");
		
		ArrayObject arrayObject1 = context.getBean("arrayObject1", ArrayObject.class);
		System.out.println(arrayObject1);
		
		ArrayObject arrayObject2 = context.getBean("arrayObject2", ArrayObject.class);
		System.out.println(arrayObject2);
		
		
		context.close();
	}
}
