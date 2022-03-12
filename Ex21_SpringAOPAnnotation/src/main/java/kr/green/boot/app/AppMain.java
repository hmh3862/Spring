package kr.green.boot.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.boot.config.AppConfig;
import kr.green.boot.service.EmployeeService;
import kr.green.boot.vo.EmployeeVO;

public class AppMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		EmployeeVO vo = employeeService.selectById(1);
		System.out.println(vo);
		System.out.println("-".repeat(80));
		
		
		List<EmployeeVO> list = employeeService.selectList();
		System.out.println(list);
		System.out.println("-".repeat(80));
		
		
		employeeService.insertEmployee(null);
		
		context.close();
	}
}
