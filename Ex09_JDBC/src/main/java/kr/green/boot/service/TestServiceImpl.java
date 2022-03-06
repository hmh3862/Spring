package kr.green.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.boot.dao.TestDAO;
import kr.green.boot.vo.TestVO;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Autowired
	TestDAO testDAO;

	@Autowired
	TestDAO testDAO2;
	
	@Override
	public TestVO selectTest() {
		TestVO testVO = new TestVO();
		testVO.setMessage(testDAO.getMessage());
		testVO.setResult(testDAO.getResult());
		testVO.setToday(testDAO.getToday());
		return testVO;
	}
	@Override
	public TestVO selectTest2() {
		TestVO testVO = new TestVO();
		testVO.setMessage(testDAO2.getMessage());
		testVO.setResult(testDAO2.getResult());
		testVO.setToday(testDAO2.getToday());
		return testVO;
	}

}
