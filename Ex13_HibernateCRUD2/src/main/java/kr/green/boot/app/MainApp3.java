package kr.green.boot.app;

import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.boot.app.config.AppConfig;
import kr.green.boot.service.StudentService;
import kr.green.boot.vo.StudentVO;

public class MainApp3 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		StudentService studentService = context.getBean("studentService", StudentService.class);
		
		// 저장
		studentService.insert(new StudentVO(0, "하늘", "강" , "자바"));
		studentService.insert(new StudentVO(0, "두만", "박" , "자바"));
		studentService.insert(new StudentVO(0, "낙동", "최" , "JSP"));
		studentService.insert(new StudentVO(0, "한강", "이" , "JSP"));
		
		showAll(studentService);
		
		StudentVO studentVO = studentService.selectByIdx(11);
		System.out.println("11번 학생 : " + studentVO);
		
		
		studentVO.setFirstName("변경");
		studentVO.setLastName("국");
		studentVO.setSection("군대");
		
		studentService.update(studentVO);
		
		studentVO = studentService.selectByIdx(3);
		System.out.println("11번 학생 : " + studentVO);
		
		studentService.delete(new Random().nextInt(10));
		
		showAll(studentService);
		
		context.close();
	}

	private static void showAll(StudentService studentService) {
		// 모두 읽기
		List<StudentVO> list = studentService.selectList();
		System.out.println(list.size() + "명");
		for(StudentVO vo : list) {
			System.out.println(vo);
		}
	}
}
