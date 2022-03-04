package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.PersonVO;

public class PersonApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("personConfig.xml");
		
		PersonVO vo1 = context.getBean("person1", PersonVO.class);
		System.out.println(vo1);
		
		PersonVO vo2 = context.getBean("person2", PersonVO.class);
		System.out.println(vo2);
		
		PersonVO vo3 = context.getBean("person3", PersonVO.class);
		System.out.println(vo3);
		
		PersonVO vo4 = context.getBean("person4", PersonVO.class);
		System.out.println(vo4);
		
		PersonVO vo5 = context.getBean("person5", PersonVO.class);
		System.out.println(vo5);
		
		context.close();
	}
}
