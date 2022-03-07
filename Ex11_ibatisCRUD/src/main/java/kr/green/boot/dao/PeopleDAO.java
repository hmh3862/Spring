package kr.green.boot.dao;

import java.sql.SQLException;
import java.util.List;

import kr.green.boot.vo.PeopleVO;

public interface PeopleDAO {
	PeopleVO selectByIdx(int id) throws SQLException;
	List<PeopleVO> selectList() throws SQLException;
	void insert(PeopleVO peopleVO) throws SQLException;
	void update(PeopleVO peopleVO) throws SQLException;
	void delete(int id) throws SQLException;
}
