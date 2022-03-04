package kr.green.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.core.dao.EmpDAO;
import kr.green.core.vo.EmpVO;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO empDAO;
	
	@Override
	public void insert(EmpVO empVO) {
		empDAO.insert(empVO);
	}

	@Override
	public String selectNow() {
		return empDAO.selectNow();
	}
	
}
