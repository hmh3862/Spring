package kr.green.boot.app;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.boot.service.PeopleService;
import kr.green.boot.service.TestService;
import kr.green.boot.vo.PeopleVO;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");
		
		TestService testService = context.getBean("testService", TestService.class);
		
		System.out.println("현재 : " + testService.today());
		System.out.println("덧셈 : " + testService.sum(22, 67));
		System.out.println("곱셈 : " + testService.mul(11, 89));
		System.out.println("VO : " + testService.vo(45, 78));
		System.out.println();
		
		
		PeopleService peopleService = context.getBean("peopleService", PeopleService.class);
		List<PeopleVO> list = peopleService.selectList();
		System.out.println(list.size() + "명");
		for(PeopleVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------");
		
		PeopleVO peopleVO = new PeopleVO(0, "하늘", "강", 23);
		peopleService.insert(peopleVO);
		
		list = peopleService.selectList();
		System.out.println(list.size() + "명");
		for(PeopleVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------");
		try {
			peopleService.delete(15);
		}catch(Exception e) {
			System.out.println("삭제 실패!!!");
		}
		
		list = peopleService.selectList();
		System.out.println(list.size() + "명");
		for(PeopleVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------");
		
		context.close();
	}
}
