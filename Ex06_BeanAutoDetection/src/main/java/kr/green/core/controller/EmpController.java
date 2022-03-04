package kr.green.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.green.core.service.EmpService;
import kr.green.core.vo.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	public void insert(EmpVO empVO) {
		empService.insert(empVO);
	}

	public String selectNow() {
		return empService.selectNow();
	}
}
