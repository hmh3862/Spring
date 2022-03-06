package kr.green.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.green.boot.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/")
	public String now(Model model) {
		model.addAttribute("now", testService.selectNow());
		model.addAttribute("today", testService.selectToday());
		
		return "now";
	}
}
