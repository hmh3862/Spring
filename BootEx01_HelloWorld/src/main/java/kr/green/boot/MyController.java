package kr.green.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스를 REST 컨트롤러로 사용하겠다.
public class MyController {
	
	@GetMapping(value = "/") // Get방식의 요청 한개를 만든다. 주소는 /이다.
	public String hello() {
		return "Hello Spring Boot!!!";
	}
	
	@RequestMapping(value = "/hi") // 모든 요청 방식을 받는다. 주소는 "/hi"이다.
	// @RequestParam(required = false) : 파라메터를 받겠다. 필수가 아니다.
	public String hello(@RequestParam(required = false) String name) {
		if(name==null || name.trim().length()==0) name="손";
		return name + "님 반갑습니다.";
	}
}
