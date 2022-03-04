package kr.green.core.app;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.ListObject;

public class ListObjectApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("listConfig.xml");
		
		ListObject listObject1 = context.getBean("listObject1", ListObject.class);
		System.out.println(listObject1);
		
		ListObject listObject2 = context.getBean("listObject2", ListObject.class);
		System.out.println(listObject2);
		
		ListObject listObject3 = context.getBean("listObject3", ListObject.class);
		System.out.println(listObject3);
		
		@SuppressWarnings("unchecked")
		List<String> list = context.getBean("nameList", List.class);
		System.out.println(list);
		
		context.close();
	}
}
