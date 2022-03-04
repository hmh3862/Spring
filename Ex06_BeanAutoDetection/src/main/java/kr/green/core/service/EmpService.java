package kr.green.core.service;

import kr.green.core.vo.EmpVO;

public interface EmpService {
	void insert(EmpVO empVO);
	String selectNow();
}
