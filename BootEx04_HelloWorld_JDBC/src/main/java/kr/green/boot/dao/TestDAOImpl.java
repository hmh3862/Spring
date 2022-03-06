package kr.green.boot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("testDAO")
public class TestDAOImpl implements TestDAO{

	@Autowired
	JdbcTemplate jdbcTemplate; // 스프링에서 지원하는 DB사용 객체
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public String selectNow() {
		String now="";
		// DataSource 사용
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select sysdate from dual");
			rs.next();
			now = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return now;
	}

	@Override
	public Date selectToday() {
		// JdbcTemplate 사용
		return jdbcTemplate.queryForObject("select sysdate from dual", Date.class);
	}

	
}
