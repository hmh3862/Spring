package kr.green.core.app;

import java.util.TreeSet;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.SetObject;

public class SetObjectApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("setConfig.xml");
		
		SetObject setObject1 = context.getBean("setObject1", SetObject.class); 
		System.out.println(setObject1);
		
		SetObject setObject2 = context.getBean("setObject2", SetObject.class); 
		System.out.println(setObject2);
		
		SetObject setObject3 = context.getBean("setObject3", SetObject.class); 
		System.out.println(setObject3);
		
		@SuppressWarnings("unchecked")
		TreeSet<String> treeSet = context.getBean("treeSet", TreeSet.class); 
		System.out.println(treeSet);
		context.close();
	}
}
