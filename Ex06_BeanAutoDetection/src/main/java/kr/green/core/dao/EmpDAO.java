package kr.green.core.dao;

import kr.green.core.vo.EmpVO;

public interface EmpDAO {
	void insert(EmpVO empVO);
	
	String selectNow();
}
