package kr.green.boot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.green.boot.vo.PeopleVO;

// select명령으로 나오는 한행의 결과와 VO를 매칭시켜 준다.
public class PeopleMapper implements RowMapper<PeopleVO> {
	@Override
	public PeopleVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PeopleVO peopleVO = new PeopleVO();
		peopleVO.setId(rs.getInt("id"));
		peopleVO.setFirstName(rs.getString("first_name"));
		peopleVO.setLastName(rs.getString("last_name"));
		peopleVO.setAge(rs.getInt("age"));
		return peopleVO;
	}
}
