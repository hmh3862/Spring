package kr.green.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.green.core.vo.EmpVO;

@Repository("empDAO") // 객체 등록
public class EmpDAOImpl implements EmpDAO{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void insert(EmpVO empVO) {
		System.out.println(empVO + "를 저장합니다." );		
	}

	@Override
	public String selectNow() {
		String today = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select now()");
			rs.next();
			today = rs.getString(1);
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
		return today;
	}
}
