package kr.green.boot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDAO")
public class TestDAOImpl implements TestDAO {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public String getMessage() {
		String message = "";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select '재미없다' ");
			//rs = stmt.executeQuery("select '재미없다' from dual");
			rs.next();
			message = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public int getResult() {
		int result = 0;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select 34*56 ");
			// rs = stmt.executeQuery("select 34*56 from dual");
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Date getToday() {
		Date today = null;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select now() ");
			//rs = stmt.executeQuery("select SYSDATE from dual ");
			rs.next();
			today = rs.getTimestamp(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
