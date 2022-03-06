package kr.green.boot.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.boot.config.AppConfig;
import kr.green.boot.service.PeopleService;
import kr.green.boot.vo.PeopleVO;

public class MainApp2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PeopleService peopleService = context.getBean("peopleService", PeopleService.class);
		// 모두 보기
		selectList(peopleService);
		
		// 저장하기
		if(peopleService.insert(new PeopleVO(0, "중운", "김", 58))){
			System.out.println("저장 성공!!!!");
		}else {
			System.out.println("저장 실패!!!!");
		}
		
		// 모두 보기
		selectList(peopleService);

		// 수정
		PeopleVO peopleVO = new PeopleVO(4, "학생", "장", 21);
		if(peopleService.update(peopleVO)) {
			System.out.println(peopleVO.getId() + "번 수정 성공!!!!");
		}else {
			System.out.println(peopleVO.getId() + "번 수정 실패!!!!");
		}
		// 삭제
		peopleVO.setId(1);
		if(peopleService.delete(peopleVO)) {
			System.out.println(peopleVO.getId() + "번 삭제 성공!!!!");
		}else {
			System.out.println(peopleVO.getId() + "번 삭제 실패!!!!");
		}
	
		// 모두 보기
		selectList(peopleService);

		context.close();
	}

	private static void selectList(PeopleService peopleService) {
		// 모두 보기
		List<PeopleVO> list = peopleService.selectList();
		System.out.println(list.size() + "개의 데이터가 있습니다.");
		for(PeopleVO vo : list) {
			System.out.println(vo);
		}
		System.out.println();
	}
}
