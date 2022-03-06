package kr.green.boot.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("testDAO2")
public class TestDaoImple2 implements TestDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public String getMessage() {
		return jdbcTemplate.queryForObject("select '안녕 JdbcTemplate'", String.class);
	}

	@Override
	public int getResult() {
		return jdbcTemplate.queryForObject("select 36*56", int.class);
	}

	@Override
	public Date getToday() {
		return jdbcTemplate.queryForObject("select now()", Date.class);
	}

}
