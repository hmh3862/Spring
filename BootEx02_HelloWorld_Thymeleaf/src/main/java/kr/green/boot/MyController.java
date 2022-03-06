package kr.green.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@GetMapping(value = {"/","/index","/index.it"}) // 주소를 동시에 여러개 생성
	public ModelAndView index() {
		// templates/index.html 을 뷰로 사용하겠다.
		ModelAndView mv = new ModelAndView("index");
		// 서비스 클래스를 호출하여 원하는 결과를 받아 ModelAndView에 저장해주면 템플릿에서 그 내용을 출력에 사용한다.
		Map<String, Object> map = new HashMap<>(); 
		map.put("name","한사람");
		map.put("age",22);
		map.put("gender","여자");
		
		List<String> hobby = new ArrayList<>();
		hobby.add("잠자기");
		hobby.add("술먹기");
		hobby.add("고성방가하기");
		
		mv.addObject("map", map);
		mv.addObject("hobby", hobby);
		mv.addObject("title", "타임리프를 이용한 출력 만들기");
		
		return mv;
	}
}
