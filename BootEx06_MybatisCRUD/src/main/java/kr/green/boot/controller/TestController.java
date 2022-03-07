package kr.green.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.green.boot.service.TestService;
import kr.green.boot.vo.TestVO;

@RestController
public class TestController {

	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/")
	public String main(Model model) {
		return testService.today();
	}
	@RequestMapping(value = "/today")
	public String today(Model model) {
		return testService.today();
	}

	@RequestMapping(value = "/sum")
	public String sum(@RequestParam(defaultValue = "0") int num1, @RequestParam(defaultValue = "0") int num2) {
		return "덧셈 : " + testService.sum(num1, num2);
	}
	@RequestMapping(value = "/mul")
	public String mul(@RequestParam(defaultValue = "0") int num1, @RequestParam(defaultValue = "0") int num2) {
		return "곱셈 : " + testService.mul(num1, num2);
	}

	@RequestMapping(value = "/testVO")
	public TestVO vo(@RequestParam(defaultValue = "0") int num1, @RequestParam(defaultValue = "0") int num2) {
		return testService.vo(num1, num2);
	}
	
}
