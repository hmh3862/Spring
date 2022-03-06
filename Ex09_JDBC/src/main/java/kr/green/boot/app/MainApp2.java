package kr.green.boot.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.boot.config.AppConfig;
import kr.green.boot.service.TestService;
import kr.green.boot.vo.TestVO;

public class MainApp2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
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
