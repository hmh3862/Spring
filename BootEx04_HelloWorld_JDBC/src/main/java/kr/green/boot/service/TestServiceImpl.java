package kr.green.boot.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.boot.dao.TestDAO;

@Service("testService")
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestDAO testDAO;

	@Override
	public String selectNow() {
		return testDAO.selectNow();
	}

	@Override
	public Date selectToday() {
		return testDAO.selectToday();
	}

}
