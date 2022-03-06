package kr.green.boot.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.boot.service.TestService;
import kr.green.boot.vo.TestVO;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		
		TestService testService = context.getBean("testService", TestService.class);
		// 순수 JDBC
		TestVO testVO = testService.selectTest();		
		System.out.println(testVO);

		// JdbcTemplate
		TestVO testVO2 = testService.selectTest2();		
		System.out.println(testVO2);
		
		context.close();
	}
}
