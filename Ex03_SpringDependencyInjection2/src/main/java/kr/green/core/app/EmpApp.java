package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.EmpVO;

public class EmpApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("empConfig.xml");
		
		EmpVO empVO1 = context.getBean("emp1", EmpVO.class);
		System.out.println(empVO1);

		EmpVO empVO2 = context.getBean("emp2", EmpVO.class);
		System.out.println(empVO2);
		
		EmpVO empVO3 = context.getBean("emp3", EmpVO.class);
		System.out.println(empVO3);
		
		EmpVO empVO4 = context.getBean("emp4", EmpVO.class);
		System.out.println(empVO4);
		
		EmpVO empVO5 = context.getBean("emp5", EmpVO.class);
		System.out.println(empVO5);
		
		EmpVO empVO6 = context.getBean("emp6", EmpVO.class);
		System.out.println(empVO6);
		
		EmpVO empVO7 = context.getBean("emp7", EmpVO.class);
		System.out.println(empVO7);
		
		EmpVO empVO8 = context.getBean("emp8", EmpVO.class);
		System.out.println(empVO8);
		
		EmpVO empVO9 = context.getBean("emp9", EmpVO.class);
		System.out.println(empVO9);
		
		EmpVO empVO10 = context.getBean("emp10", EmpVO.class);
		System.out.println(empVO10);
		
		
		context.close();
	}
}
